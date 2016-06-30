package com.liibrarymanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
  private static boolean loggedIn = false;
  private static String savedLibraryNumber = "";

  public static void main(String[] args) {
    InputStreamReader inputStream = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStream);
    while (true) {
      showLibraryMenu();

      int currentUserInput = 0;
      try {
        currentUserInput = readUserInput(reader);
      } catch (Exception e) {
        errorInInput();
      }
      switch (currentUserInput) {
        case 1:
          displayListOfBooks();
          break;
        case 2:
          selectAndIssueBook(reader);
          break;
        case 3:
          checkIfUserLoggedIn();
          break;
        case 4:
          displayListOfMovies();
          break;
        case 5:
          loginUser(reader);
          break;

        case 9:
          quitSystem(reader);
          return;
        default:
          errorInInput();
      }

    }
  }

  private static void errorInInput() {
    System.out.println("\n");
    System.out.println("Enter a valid integer!!");
  }

  private static void quitSystem(BufferedReader reader) {
    System.out.println("Quitting...");
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void loginUser(BufferedReader reader) {
    clearLogin();
    System.out.println("Enter your library number");
    try {
      String libraryNumber = reader.readLine();
      if (validLibraryNumber(libraryNumber)) {
        try {
          System.out.println("Enter your Password: ");
          String password = reader.readLine();
          if (validPassword(password)) {
            loggedIn = true;
            savedLibraryNumber = libraryNumber;
          }
        } catch (Exception e) {

        }
      }
    } catch (Exception e) {

    }
  }

  private static void checkIfUserLoggedIn() {
    if (loggedIn) {
      System.out.println("\n");
      System.out.println("Your library number is " + savedLibraryNumber);
    } else {

      System.out.println("\n");
      System.out.println("Please talk to Librarian. Thank you.");
    }
  }

  private static void selectAndIssueBook(BufferedReader reader) {
    int userSelectedBookId = 0;
    try {
      System.out.println(" Please enter the number of the book you wish to checkout: ");

      userSelectedBookId = readUserInput(reader);
      issueBook(userSelectedBookId);
    } catch (IOException e) {
      System.out.println("not a valid input");
    }
  }

  private static int readUserInput(BufferedReader reader) throws IOException {
    int userInput;
    String value = reader.readLine();
    userInput = Integer.parseInt(value);
    return userInput;
  }

  private static void displayListOfMovies() {
    System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
    System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
    System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
    System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
    System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
    System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
    System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
    System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
    System.out.println(createMovie("Inception", "Frank Darabont", "10"));
    System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
  }

  private static void displayListOfBooks() {
    System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
    System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
    System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
    System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
  }

  private static void showLibraryMenu() {
    System.out.println("**********************************************************");
    System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
    System.out.println("**********************************************************");
    System.out.println("*                Menu                                    *");
    System.out.println("*         =====================                          *");
    System.out.println("*         1. List Book Catalog                           *");
    System.out.println("*         2. Check out Book                              *");
    System.out.println("*         3. Check Library Number                        *");
    System.out.println("*         4. Movie Listing                               *");
    System.out.println("*         5. Login                                       *");
    System.out.println("*         9. Exit                                        *");
    System.out.println("**********************************************************");
    System.out.println("Your Selection: ");
  }

  private static void issueBook(int indexOfBook) {
    switch (indexOfBook) {
      case 1:
        System.out.println("\n");
        System.out.println(" Thank You! Enjoy the book.");
        break;
      case 2:
        System.out.println("\n");
        System.out.println(" Thank You! Enjoy the book.");
        break;
      case 3:
        System.out.println("\n");
        System.out.println(" Thank You! Enjoy the book.");
        break;
      case 4:
        System.out.println("\n");
        System.out.println(" Thank You! Enjoy the book.");
        break;
      default:
        System.out.println("\n");
        System.out.println("Sorry we don't have that book yet.");
    }
  }

  private static boolean validPassword(String password) {
    return "bhaisahab".equals(password);
  }

  private static boolean validLibraryNumber(String libraryNumber) {
    return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
  }

  private static boolean loggedIn() {
    return loggedIn;
  }


  private static void clearLogin() {
    loggedIn = false;
    savedLibraryNumber = "";
  }

  private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
    return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
  }
}

