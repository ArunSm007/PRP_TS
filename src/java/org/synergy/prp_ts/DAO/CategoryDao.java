package org.synergy.prp_ts.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.CategoryDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class CategoryDao {
    
    private static Session session;
    private static Transaction transaction;
    
    public static CategoryDetails getCategoryDetails(String categoryId){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            
            Query query = session.createQuery("from CategoryDetails where categoryId = :n");
            query.setParameter("n", categoryId);
            
            if(query.list().size() > 0){
                
                return (CategoryDetails) query.list().get(0);
                
            }
            
        }
        finally{
            
            session.close();
            return null;
            
        }
        
    }
    
    public static void addCategory(CategoryDetails categoryDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                              
            session.save(categoryDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void updateCategory(CategoryDetails categoryDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.update(categoryDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
    public static void deleteCategory(CategoryDetails categoryDetails){
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
                        
            session.delete(categoryDetails);
            transaction.commit();
            
        }
        finally{
            session.close();
        }
        
    }
    
}
