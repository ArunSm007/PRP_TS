package org.synergy.prp_ts.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.StreamDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class StreamDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static StreamDetails getStreamDetails(String streamId){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from StreamDetails where streamId = :n");
            query.setParameter("n", streamId);
            
            if(query.list().size() > 0){
                
                return (StreamDetails) query.list().get(0);
                
            }
            
        }
        finally{
            
            session.close();
            return null;
            
        }
        
    }
    
    public static void addStream(StreamDetails streamDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                              
            session.save(streamDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void updateStream(StreamDetails streamDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.update(streamDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void deleteStream(StreamDetails streamDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.delete(streamDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
}
