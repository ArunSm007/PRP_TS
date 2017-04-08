import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.synergy.prp_ts.beans.AssessmentDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        AssessmentDetails assessmentDetails = new AssessmentDetails();
        assessmentDetails.setAssessmentName("Arun");
        session.save(assessmentDetails);
        session.getTransaction().commit();
        HibernateUtil.closeSessionFactory();
    }
}
