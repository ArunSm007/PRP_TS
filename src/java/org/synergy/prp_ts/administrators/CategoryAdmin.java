/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.administrators;

import org.synergy.prp_ts.DAO.CategoryDao;
import org.synergy.prp_ts.beans.CategoryDetails;

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
}
