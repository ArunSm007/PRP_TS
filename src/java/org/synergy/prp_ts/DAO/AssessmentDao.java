package org.synergy.prp_ts.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.synergy.prp_ts.beans.AssessmentDetails;
import org.synergy.prp_ts.util.HibernateUtil;

public class AssessmentDao {
    private static Session session;
    private static Transaction transaction;
    
    public static AssessmentDetails getAssessmentDetails(int assessmentId){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            return (AssessmentDetails) session.get(AssessmentDetails.class, assessmentId);
        }
        finally{
            session.close();
        }
    }
    
    public static void setAssessmentDetails(AssessmentDetails assessmentDetails){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(assessmentDetails);
            transaction.commit();
        }
        finally{
            session.close();
        }
    }
}
