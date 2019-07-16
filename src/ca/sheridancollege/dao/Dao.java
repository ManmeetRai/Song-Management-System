package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import ca.sheridancollege.beans.Contacts;


public class Dao {


	//Grabs our config settings, configures Hibernate to use them, 	//and builds
    //a session factory we can use to open a database session with.
	SessionFactory sessionFactory = new Configuration()
		.configure("ca/sheridancollege/config/hibernate.cfg.xml")
		.buildSessionFactory();

	public void addSong(Contacts c) {
		//Open a new session and begin a transaction.
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(c);
		
		//Commit the transaction and close the session.
		session.getTransaction().commit();
		session.close();
	}
	public List<Contacts> querySongs() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Contacts");
		List<Contacts> c = (List<Contacts>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		return c;
	}
	public List<Contacts> queryByCategory(String genre) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Contacts where genre=:genre");
		query.setParameter("genre", genre);
		List<Contacts> c = (List<Contacts>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		return c;
	}
	public Contacts queryByID(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Contacts where id=:id");
		query.setParameter("id", id);
		List<Contacts> contact = (List<Contacts>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		Contacts c = new Contacts();
		if (!contact.isEmpty()) {
			c = contact.get(0);
		}
		return c;
	}
	public void deleteSong(int index) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Contacts s = (Contacts) session.get(Contacts.class, index);
		session.delete(s);

		session.getTransaction().commit();
		session.close();
	}
	public List<Contacts> querySearchByValueCriteria(String searchBy, String value) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Contacts> criteria = criteriaBuilder.createQuery(Contacts.class);
		Root<Contacts> root = criteria.from(Contacts.class);
		criteria.where(criteriaBuilder.equal(root.get(searchBy), value));
		List<Contacts> DogList = session.createQuery(criteria).getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return DogList;
	}
}



