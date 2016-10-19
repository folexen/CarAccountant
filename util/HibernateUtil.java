package com.caracount.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            String cfgFile = "src\\com\\caracount\\resources\\hibernate.cfg.xml";
            File configFile = new File(cfgFile);
            Configuration cfg = new Configuration();
            cfg.configure(configFile);
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
