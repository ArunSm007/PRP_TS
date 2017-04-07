package org.synergy.prp_ts.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.TrainerDetails;
import org.synergy.prp_ts.util.HibernateUtil;
/**
 *
 * @author Harishkumar
 */
public class TrainerDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static TrainerDetails getTrainerDetails(String trainerId){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from TrainerDetails where wcfId = :n");
            query.setParameter("n", trainerId);
            
            if(query.list().size() > 0){
                
                return (TrainerDetails) query.list().get(0);
                
            }
            
            return null;
            
        }
        finally{
            
            session.close();
            
        }
        
    }
    
    public static void addTrainer(TrainerDetails trainerDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                              
            session.save(trainerDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void updateTrainer(TrainerDetails trainerDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.update(trainerDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void deleteTrainer(TrainerDetails trainerDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.delete(trainerDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
}
