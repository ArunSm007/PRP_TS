
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.synergy.prp_ts.DAO.CategoryDao;
import org.synergy.prp_ts.DAO.LoginDao;
import org.synergy.prp_ts.DAO.VenueDao;
import org.synergy.prp_ts.beans.CategoryDetails;
import org.synergy.prp_ts.beans.LoginDetails;
import org.synergy.prp_ts.beans.StreamDetails;
import org.synergy.prp_ts.beans.VenueDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
           
        List<CategoryDetails> cd=new ArrayList<>();
        
        CategoryDetails obj1 = new CategoryDetails();
        obj1.setCategoryId(0);
        obj1.setCategoryName("IT");
        
       CategoryDetails obj2 = new CategoryDetails();
        obj2.setCategoryId(1);
        obj2.setCategoryName("Non-IT");
       
      CategoryDao.updateCategory(cd);
        HibernateUtil.closeSessionFactory();
    }
}
