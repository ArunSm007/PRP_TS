/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.TrainingDetails;
import org.synergy.prp_ts.util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class TrainingDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static TrainingDetails getTrainingDetails(String trainingId){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from TrainingDetails where trainingId = :n");
            query.setParameter("n", trainingId);
            
            if(query.list().size() > 0){
                
                return (TrainingDetails) query.list().get(0);
                
            }
            
        }
        finally{
            
            session.close();
            return null;
            
        }
        
    }
    
    public static void addTraining(TrainingDetails trainingDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                              
            session.save(trainingDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void updateTraining(TrainingDetails trainingDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.update(trainingDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void deleteTraining(TrainingDetails trainingDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.delete(trainingDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
}
