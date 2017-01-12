package com.tsystem.dia1.world_csv.configuration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.domain.HibernateCityEntity;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static {
	try {
	    sessionFactory = new Configuration()//
		    .addAnnotatedClass(CountryEntity.class)//
		    .addAnnotatedClass(HibernateCityEntity.class)//
		    .buildSessionFactory();
	} catch (Throwable ex) {
	    throw new ExceptionInInitializerError(ex);
	}
    }

    public static Session getSession() throws HibernateException {
	return sessionFactory.openSession();
    }
}
