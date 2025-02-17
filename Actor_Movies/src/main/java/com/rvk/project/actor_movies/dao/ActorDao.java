package com.rvk.project.actor_movies.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rvk.project.actor_movies.entity.Actor;
import com.rvk.project.actor_movies.entity.Movie;

public class ActorDao {
	Scanner scan = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-j");

	// 1
	public void addActor() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Actor a = new Actor();
		System.out.print("Enter the Id for Actor : ");
		a.setActorId(scan.nextInt());
		System.out.print("Enter the actor name : ");
		a.setActorName(scan.next());
		System.out.print("Enter the Age of actor : ");
		a.setAge(scan.nextInt());
		System.out.print("Enter the Salary : ");
		a.setSalary(scan.nextInt());
		System.out.print("Enter the Industry He From : ");
		a.setIndustry(scan.next());
		System.out.println("Enter the Natinality : ");
		a.setNatinality(scan.next());

		em.persist(a);

		et.commit();
		em.close();
	}

	// 2
	public void findActorById() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		System.out.print("Enter The Id for Actor to Find : ");
		Actor a = em.find(Actor.class, scan.nextInt());
		System.out.println(a.toString());

		et.commit();
		em.close();
	}

	// 3
	public void findActorByName() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query q = em.createQuery("SELECT a FROM Actor a WHERE actorName = ?1", Actor.class);
		System.out.print("Enter the Name of Actor : ");
		q.setParameter(1, scan.next());

		@SuppressWarnings("unchecked")
		List<Actor> actorList = q.getResultList();
		for (Actor a : actorList) {
			System.out.println(a.toString());
		}

		et.commit();
		em.close();
	}

	// 4
	public void findAllActorByIndustry() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);
		cq.where(cb.equal(root.get("industry"), scan.next()));

		Query q = em.createQuery(cq);

		@SuppressWarnings("unchecked")
		List<Actor> actorList = q.getResultList();
		for (Actor a : actorList) {
			System.out.println(a.toString());
		}

		et.commit();
		em.close();
	}

	// 5
	public void findAllActorsBetweenAge() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query q = em.createQuery("SELECT a FROM Actor a WHERE a.age BETWEEN ?1 AND ?2", Actor.class);
		System.out.print("Enter the age between range 1 : ");
		q.setParameter(1, scan.nextInt());
		System.out.print("Enter the age between range 2 : ");
		q.setParameter(2, scan.nextInt());

		@SuppressWarnings("unchecked")
		List<Actor> actorList = q.getResultList();
		for (Actor a : actorList) {
			System.out.println(a.toString());
		}

		et.commit();
		em.close();
	}

	// 6
	public void findAllActorsByMovieId() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query q = em.createQuery("FROM Movie");
		List<Movie> movieList = q.getResultList();
		for (Movie m : movieList) {
			System.out.println("Movie [movieId=" + m.getMovieId() + ", title=" + m.getTitle() + ", director="
					+ m.getDirector() + ", genre=" + m.getGenre() + ", vendict=" + m.getVendict() + ", collection="
					+ m.getCollection() + "]");
		}

		System.out.print("Enter the Movie id to Find Actor : ");
		int id = scan.nextInt();

		Query actorQuery = em.createQuery("FROM Actor_Movie a WHERE movieId = ?1");
		actorQuery.setParameter(1, id);
		List<Actor> listId = actorQuery.getResultList();
		for (Actor a : listId) {
			System.out.println(a);
		}

		et.commit();
		em.close();
	}

	// 7
	public void updateAllActorSalaryByMoviestitle() {

	}

	// 8
	public void deleteAllActorWithSalaryGreaterThan() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);
		System.out.print("Enter The salary for Deletion of Greater Than ?  : ");
		cq.where(cb.greaterThan(root.get("salary"), scan.nextInt()));

		Query q = em.createQuery(cq);

		@SuppressWarnings("unchecked")
		List<Actor> actorList = q.getResultList();
		for (Actor a : actorList) {
			System.out.println(a.toString());
		}

		et.commit();
		em.close();
	}

	// 9
	public void deleteAllActorByMovieGenre() {

	}
}
