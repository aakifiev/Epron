package main.java.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	static {
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
