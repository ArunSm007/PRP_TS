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
import org.synergy.prp_ts.util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class VenueDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static void updateVenue(List<VenueDetails> venueList){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            
            Query result = session.createQuery("from VenueDetails");
            
            List<VenueDetails> venueDetailses = result.list();
            VenueDetails venueDetails,venueDetails1;
            
            int i=0,j=0;
            for(;i<venueList.size();i++,j++){
                
                venueDetails1 = venueList.get(i);
                
                if(j<venueDetailses.size()){
                    
                    venueDetails = venueDetailses.get(j);
                    venueDetails.setVenueId(venueDetails1.getVenueId());
                    venueDetails.setVenueName(venueDetails1.getVenueName());
                    
                    session.update(venueDetails);
                    
                }
                else{
                    session.save(venueDetails1);
                }
            }
            
            if(j<venueDetailses.size()){
                for(;j < venueDetailses.size();j++)
                    session.delete((VenueDetails)venueDetailses.get(j));
            }

            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
}
