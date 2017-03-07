
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.synergy.prp_ts.beans.StreamDetails;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        s.close();
        sf.close();
    }
}
