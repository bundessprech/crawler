package de.dtonal.bundessprech;

import java.util.Scanner;

public class CrawlerApplication {
	public static void main(String[] args) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("Welcome to Bundessprech Crawler");
		System.out.println("-------------------------------");
		System.out.println("");
		System.out.println("Option (1): Clear DB");
		System.out.println("Option (2): Init DB");
		System.out.println("Option (3): Clear & Init DB");
		System.out.println("Option (4): Exit");
		int option = 0;
		do {
			Scanner reader = new Scanner(System.in); // Reading from System.in
			System.out.println("Enter a number: ");
			option = reader.nextInt();
		} while (option < 1 && option < 4);
		switch (option) {
		case 1:
			DataBaseInitialiser.clearDb();
			break;
		case 2:
			DataBaseInitialiser.initDB();
			break;
		case 3:
			DataBaseInitialiser.clearDb();
			DataBaseInitialiser.initDB();
			break;
		case 4:
			break;
		}
		System.out.println("Thank you and Goodbye :-)");
		System.exit(0);
	}
}
