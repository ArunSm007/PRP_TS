/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.administrators;

import org.synergy.prp_ts.DAO.TrainerDao;
import org.synergy.prp_ts.beans.TrainerDetails;

/**
 *
 * @author Arun
 */
public class TrainerAdmin {
    
    public static int addTrainer(String trainerId,String trainerName){
        
        if(TrainerDao.getTrainerDetails(trainerId) == null){
            
            TrainerDetails trainerDetails = new TrainerDetails();
            trainerDetails.setName(trainerName);
            trainerDetails.setWcfId(trainerId);
            TrainerDao.addTrainer(trainerDetails);
            
            return 1;
        }
        
        return -1;
        
    }
}
