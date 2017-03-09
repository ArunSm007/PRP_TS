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
import org.synergy.prp_ts.beans.CategoryDetails;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class CategoryDao {
    private static Session session;
    private static Transaction transaction;
    
    public static void updateCategory(List<CategoryDetails> categoryList){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            
            Query result = session.createQuery("from CategoryDetails");
            
            List<CategoryDetails> categoryDetailses = result.list();
            CategoryDetails categoryDetails,categoryDetails1;
            
            int i=0,j=0;
            for(;i<categoryList.size();i++,j++){
                
                categoryDetails1 = categoryList.get(i);
                
                if(j<categoryDetailses.size()){
                    
                    categoryDetails = categoryDetailses.get(j);
                    categoryDetails.setCategoryId(categoryDetails1.getCategoryId());
                    categoryDetails.setCategoryName(categoryDetails1.getCategoryName());
                    
                    session.update(categoryDetails);
                    
                }
                else{
                    session.save(categoryDetails1);
                }
            }
            
            if(j<categoryDetailses.size()){
                for(;j < categoryDetailses.size();j++)
                    session.delete((CategoryDetails)categoryDetailses.get(j));
            }

            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
}
