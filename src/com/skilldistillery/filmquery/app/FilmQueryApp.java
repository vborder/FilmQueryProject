package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean menu = true;

		System.out.println("Welcome to the Film Query App.\n");

		while (menu) {
			System.out.println("Choose an option: ");
			System.out.println("1. Look for a film by its film ID ");
			System.out.println("2. Look for a film by a search keyword ");
			System.out.println("3. Exit the application ");
			int selection = input.nextInt();
			if (selection == 1) {
				System.out.println("Enter the film ID: ");
				int filmID = input.nextInt();
				Film film = null;
				try {
					film = db.findFilmById(filmID);
					if (film != null) {
						System.out.println(film + "\n");
					} else {
						System.out.println("The film ID you entered was not found. Please enter another ID. \n");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					break;
				}
			}

			if (selection == 2) {
				System.out.println("Enter the search keyword: ");
				String keyword = input.next();
				Film film = null;

				try {
					film = db.findFilmByKeyword(keyword);
				} catch (SQLException e) {
					System.out.println("The keyword you entered was not found. Please enter another keyword.");
					e.printStackTrace();
				}

				System.out.println(film);

			}

			if (selection == 3) {
				System.out.println("Goodbye!");
				menu = false;

			}

		}

//	  if (selection == 2) {
//		  System.out.println("Enter the search keyword: ");
//		  int actorID = input.nextInt();
//		  Actor actor = null;
//		  
//		  try {
//				actor = db.findActorById(actorID);
//			} catch (SQLException e) {
//				System.out.println("The actor ID you entered was not found. Please enter another ID.");
//				e.printStackTrace();
//			}
//		  
//		  System.out.println(actor);
//		  
//	  }
//	  
//	  if (selection == 3) {
//		  System.out.println("Goodbye!");
//		  System.exit(0);
//		  
//	  }
	}

}
