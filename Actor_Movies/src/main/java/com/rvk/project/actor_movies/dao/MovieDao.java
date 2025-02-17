package com.rvk.project.actor_movies.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rvk.project.actor_movies.entity.Actor;
import com.rvk.project.actor_movies.entity.Movie;

public class MovieDao {
	Scanner scan = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-j");

	public void addMovie() {
		Movie m = new Movie();

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		System.out.print("Enter Movie Id : ");
		m.setMovieId(scan.nextInt());
		System.out.print("Enter title of Movies : ");
		m.setTitle(scan.next());
		System.out.print("Enter Director name : ");
		m.setDirector(scan.next());
		System.out.print("Enter Genre of Movie : ");
		m.setGenre(scan.next());
		System.out.print("Enter vendict of movie : ");
		m.setVendict(scan.next());
		System.out.println("Enter the total Collection of Movies : ");
		m.setCollection(scan.nextInt());

		Query q = em.createQuery("FROM Actor");
		@SuppressWarnings("unchecked")
		List<Actor> selectOfActorAdd = q.getResultList();
		for (Actor a : selectOfActorAdd) {
			System.out.println(a.toString());
		}
		System.out.println();
		System.out.print("Enter id Speareted with SpecialChart (,) : ");
		String ids = scan.next();

		List<Actor> actorList = new ArrayList<Actor>();

		for (String num : ids.split(",")) {
			int actorId = Integer.parseInt(num);
			Actor actor = em.find(Actor.class, actorId);
			actorList.add(actor);
		}

		m.setActor(actorList);
		em.persist(m);

		et.commit();
		em.close();
	}
}
