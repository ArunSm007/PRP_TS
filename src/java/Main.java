
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.synergy.prp_ts.DAO.LoginDao;
import org.synergy.prp_ts.DAO.VenueDao;
import org.synergy.prp_ts.beans.LoginDetails;
import org.synergy.prp_ts.beans.StreamDetails;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
           
        List<VenueDetails> vd=new ArrayList<>();
        
        VenueDetails obj1 = new VenueDetails();
        obj1.setVenueId("R101");
        obj1.setVenueName("Founders Hall");
        
        VenueDetails obj2 = new VenueDetails();
        obj2.setVenueId("R102");
        obj2.setVenueName("Seminar Hall");
        
        VenueDetails obj3 = new VenueDetails();
        obj3.setVenueId("R103");
        obj3.setVenueName("Conference Hall");
        
        
        
        VenueDao.updateVenue(vd);
        HibernateUtil.closeSessionFactory();
    }
}
