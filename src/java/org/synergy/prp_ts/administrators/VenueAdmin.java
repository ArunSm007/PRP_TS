package org.synergy.prp_ts.administrators;

import org.synergy.prp_ts.DAO.VenueDao;
import org.synergy.prp_ts.beans.VenueDetails;

public class VenueAdmin {
    
    public static int addVenue(String venueName){
        
        if(VenueDao.getVenueDetailsByName(venueName) == null){
            
            VenueDetails venueDetails = new VenueDetails();
            venueDetails.setVenueName(venueName);
            VenueDao.addVenue(venueDetails);
            
            return 1;
        }
        
        return -1;
    }
    public static int updateVenue(String currentVenueName,String newVenueName){
        VenueDetails venueDetails = VenueDao.getVenueDetailsByName(currentVenueName);
        if(venueDetails != null){
          
            venueDetails.setVenueName(newVenueName);
            VenueDao.updateVenue(venueDetails);
        
            return 1;
        }
        
        return -1;
    }
}
