/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.LoginDetails;
import org.synergy.prp_ts.util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class LoginDao {
    private static Session session;
    private static Transaction transaction;
    public static int validateUser(String username,String password){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            Query query = session.createQuery("from LoginDetails where userName = :un");
            query.setParameter("un", username);

            List result = query.list();

            if(result.size() == 1){

                LoginDetails loginDetails = (LoginDetails) result.get(0);

                if(loginDetails.getPassword().equals(password)){

                    if(loginDetails.getActiveStatus() != 1){

                        loginDetails.setActiveStatus(1);
                        loginDetails.setLoginTime(new Date());
                        loginDetails.setLogoutTime(null);
                        
                        session.update(loginDetails);
                        transaction.commit();
                        
                        return 1;
                    }

                    return 2;

                }
                return 0;
            }

            return -1;
        }
        finally{
            session.close();
        }
        
    }
    
    public static int changePassword(String username,String password){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from LoginDetails where userName = :un");
            query.setParameter("un", username);

            List result = query.list();

            if(result.size() == 1){

                LoginDetails loginDetails = (LoginDetails) result.get(0);
                loginDetails.setPassword(password);

                session.update(loginDetails);
                transaction.commit();
                
                return 1;

            }
            
            return 0;
        }
        finally{
            session.close();
        }
      
    }
    
    public static int logoutUser(String username){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            Query query = session.createQuery("from LoginDetails where userName = :un");
            query.setParameter("un", username);

            List result = query.list();

            if(result.size() == 1){

                LoginDetails loginDetails = (LoginDetails) result.get(0);

                if(loginDetails.getLogoutTime() == null){
                    
                    loginDetails.setActiveStatus(0);
                    loginDetails.setLogoutTime(new Date());
                    
                    session.update(loginDetails);
                    transaction.commit();
                    
                    return 1;
                }
            }

            return -1;

        }
        finally{
            session.close();
        }
    }
}
