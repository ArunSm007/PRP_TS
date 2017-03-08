/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Arun
 */
public class HibernateUtil {
    private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static void closeSessionFactory(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
