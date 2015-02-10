package main.java.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import main.java.model.immutable.VPerson;
import main.java.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("serial")
public class PersonService implements Serializable{

	@Inject
	HibernateUtil hUtil;
	
	@SuppressWarnings("unchecked")
	public List<VPerson> getAllVPersons(){
		Session session = null;
        List<VPerson> vPersons = new ArrayList<VPerson>();
        try {
            session = hUtil.getSessionFactory().openSession();
            vPersons = session.createCriteria(VPerson.class).list();
        } catch (Exception e) {
    //        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return vPersons;
	}

	/*@Override
	public void addAbonent(Abonent abonent) {
		Session session = null;
        try {
            session = hUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(abonent);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	@Override
	public void removeAbonent(Abonent abonent) {
		Session session = null;
        try {
            session = hUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(abonent);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}
	
	@Override
	public void removeAbonentById(Long id) {
		Session session = null;
        try {
            session = hUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Abonent abonent = (Abonent) session.createCriteria(Abonent.class)
            		.add(Restrictions.eq("id", id)).uniqueResult();
            session.delete(abonent);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}*/
	
	
	public VPerson getVPersonById(String id) {
		Session session = null;
		VPerson vPerson = null;
        try {
            session = hUtil.getSessionFactory().openSession();
            session.beginTransaction();
            vPerson = (VPerson) session.get(VPerson.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
   //         JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return vPerson;
        
/*    	Session session = null;
		VPerson vPerson = null;
        try {
            session = hUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(VPerson.class);
            //cr.add(Restrictions.eq("personid", id));
            //vPerson = (VPerson)cr.list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
   //         JOptionPane.showMessageDialog(null, e.getMessage(), "Îøèáêà I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return vPerson;*/
	}
}
