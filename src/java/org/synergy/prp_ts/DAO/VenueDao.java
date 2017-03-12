/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.DAO;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class VenueDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static VenueDetails getVenueDetailsById(String venueId){
        
        session = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Query query = session.createQuery("from VenueDetails where venueId = :n");
            query.setParameter("n", venueId);
            
            List<VenueDetails> detailses = query.list();
                    
            if(query.list().size() > 0){
                return (VenueDetails) query.list().get(0);
                
            }
            
            return null;
            
        }
        finally{
            
            session.close();
            
        }
        
    }
    
    public static VenueDetails getVenueDetailsByName(String venueName){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from VenueDetails where venueName = :n");
            query.setParameter("n", venueName);
            
            if(query.list().size() > 0){
                
                return (VenueDetails) query.list().get(0);
                
            }
            
            return null;
        }
        finally{
            
            session.close();
            
        }
        
    }
    
    public static void addVenue(VenueDetails venueDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                              
            session.save(venueDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void updateVenue(VenueDetails venueDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.update(venueDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void deleteVenue(VenueDetails venueDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.delete(venueDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
}
