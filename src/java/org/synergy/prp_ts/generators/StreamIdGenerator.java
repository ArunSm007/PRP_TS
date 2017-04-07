package org.synergy.prp_ts.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
/**
 *
 * @author Harishkumar
 */
public class StreamIdGenerator implements IdentifierGenerator{
    
    @Override
    public Serializable generate(SessionImplementor sessionImplementor,Object data)
        throws HibernateException {
        Serializable result = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String prefix = "SID_";
            connection = sessionImplementor.connection();
            statement = connection.createStatement();                   
             try {  
                 resultSet = statement.executeQuery("select stream_seq.nextval from dual");
             } catch(Exception ex) {
                 statement = connection.createStatement();
                 statement.execute("create sequence stream_seq start with 001 nocycle nocache increment by 1");
                 System.out.println("Sequece Created successfully.");
                 resultSet = statement.executeQuery("select stream_seq.nextval from dual");
             }
            
            if(resultSet.next()) {
                int nextValue = resultSet.getInt(1);                
                String suffix = String.format("%03d",nextValue);               
                result = prefix.concat(suffix);
                System.out.println("Custom generated Sequence value : "+result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
