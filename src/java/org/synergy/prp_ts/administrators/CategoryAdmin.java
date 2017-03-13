/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.administrators;

import org.synergy.prp_ts.DAO.CategoryDao;
import org.synergy.prp_ts.DAO.VenueDao;
import org.synergy.prp_ts.beans.CategoryDetails;
import org.synergy.prp_ts.beans.VenueDetails;

/**
 *
 * @author Arun
 */
public class CategoryAdmin {
    public static int addCategory(String categoryName){
        
        if(CategoryDao.getCategoryDetailsByName(categoryName) == null){
            
            CategoryDetails categoryDetails = new CategoryDetails();
            categoryDetails.setCategoryName(categoryName);
            CategoryDao.addCategory(categoryDetails);
            
            return 1;
        }
        
        return -1;
        
    }
    
     public static int updateCategory(String currentCategoryName,String newCategoryName){
        VenueDetails venueDetails = VenueDao.getVenueDetailsByName(currentCategoryName);
        if(venueDetails != null){
          
            venueDetails.setVenueName(newCategoryName);
            VenueDao.updateVenue(venueDetails);
        
            return 1;
        }
        
        return -1;
    }
}
