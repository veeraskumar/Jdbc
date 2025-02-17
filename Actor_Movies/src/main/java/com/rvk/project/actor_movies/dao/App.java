package com.rvk.project.actor_movies.dao;

public class App {

	public static void main(String[] args) {
		ActorDao a = new ActorDao();
		MovieDao m = new MovieDao();

		while (true) {
			System.out.print("Hello, Welcome :-) \n" + "1. Add Actor \n" + "2. Find Actors By Id \n"
					+ "3. Find Actors By Name \n" + "4. Find all Actors By industry \n"
					+ "5. Find All Actors Between Age \n" + "6. Find All Actorsn By Movie Id \n"
					+ "7. Update All Actor Salary By Movies title \n"
					+ "8. Delete All Actor With Salary Greater Than \n" + "9. Delete All Actor By Movie Genre \n"
					+ "10. Exit. \n" + "Enter the Number Between 1 to 10 : ");
			int x = a.scan.nextInt();
			switch (x) {
			case 1:
				System.out.println("Add Actor");
				a.addActor();
				break;
			case 2:
				a.findActorById();
				break;
			case 3:
				a.findActorByName();
				break;
			case 4:
				a.findAllActorByIndustry();
			case 5:
				a.findAllActorsBetweenAge();
				break;
			case 6:
				a.findAllActorsByMovieId();
				break;
			case 7:
				a.updateAllActorSalaryByMoviestitle();
			case 8:
				a.deleteAllActorWithSalaryGreaterThan();
				break;
			case 9:
				a.deleteAllActorByMovieGenre();
				break;
			case 10:
				System.out.println("Thanks....");
				a.emf.close();
				return;
			case 11:
				m.addMovie();
				break;
			default:
				System.err.println("please enter the value number ");
				a.emf.close();
				throw new IllegalArgumentException();
			}
		}
	}
}
