package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
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
			System.out.println("1. Look for a film by film ID ");
			System.out.println("2. Look for a film by keyword search ");
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
						System.out.println("The film ID you entered was not found. \n");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (selection == 2) {
				System.out.println("Enter the search keyword: ");
				String keyword = input.next();
				List<Film> film = new ArrayList<Film>();

				try {
					film = db.findFilmByKeyword(keyword);

					if (film.size() > 0) {
						for (Film film2 : film) {
							System.out.println(film2);
						}

					} else {
						System.out.println("The keyword you entered returned no results. \n");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (selection == 3) {
				System.out.println("Thanks for using the Film Query App. Goodbye!");
				menu = false;
			}
		}
	}
}
