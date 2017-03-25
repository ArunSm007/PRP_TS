import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.synergy.prp_ts.DAO.CategoryDao;
import org.synergy.prp_ts.DAO.LoginDao;
import org.synergy.prp_ts.DAO.StreamDao;
import org.synergy.prp_ts.DAO.VenueDao;
import org.synergy.prp_ts.beans.AssessmentDetails;
import org.synergy.prp_ts.beans.CategoryDetails;
import org.synergy.prp_ts.beans.LoginDetails;
import org.synergy.prp_ts.beans.ModuleDetails;
import org.synergy.prp_ts.beans.StreamDetails;
import org.synergy.prp_ts.beans.SubModuleDetails;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.generators.VenueIdGenerator;
import org.synergy.prp_ts.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        VenueDetails details = new VenueDetails();
        details.setVenueName("Arun");
        VenueDao.addVenue(details);
        HibernateUtil.closeSessionFactory();
    }
}
