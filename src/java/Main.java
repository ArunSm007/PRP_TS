
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
import org.synergy.prp_ts.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
           
        StreamDetails sd = new StreamDetails();
        
        sd.setStreamId("S_004");
        sd.setStreamName("JavaHib");
        
        
        List<ModuleDetails> mds = new ArrayList<>();
        ModuleDetails md = new ModuleDetails();
        
        
        md.setCategoryId("C_001");
        md.setLogicalBuildingDuration(1.123f);
        md.setModuleDuration(1.123f);
        md.setModuleName("JAVA_OOPS");
        
        mds.add(md);
        sd.setModuleDetailses(mds);
        
        List<SubModuleDetails> mds1 = new ArrayList<>();
        SubModuleDetails md1 = new SubModuleDetails();
        
        md1.setSubModuleName("CLASSES");
        md1.setMiniprojectDuration(0);
        md1.setPracticeDuration(0);
        
        mds1.add(md1);
        md.setSubModules(mds1);
        
        List<AssessmentDetails> assessmentDetailses = new ArrayList<>();
        StreamDao.updateStream(sd);
        
        HibernateUtil.closeSessionFactory();
    }
}
