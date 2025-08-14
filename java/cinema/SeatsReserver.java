package cinema;

import java.util.Scanner;

public class SeatsReserver {
  private char[][] seats = new char[10][10];

  private Scanner scanner = new Scanner(System.in);

  private void initSeats() {
    for (int row = 0; row < 10; row++) {
      for (int seat = 0; seat < 10; seat++) {
        seats[row][seat] = 'L';
      }
    }
  }

  private void viewSeats() {
    System.out.print("""
          ---------- Movie Theater ----------
        @ 0123456789
        """);
    for (int row = 0; row < 10; row++) {
      System.out.print((char) ('A' + row) + " ");
      for (int seat = 0; seat < 10; seat++) {
        System.out.print(seats[row][seat]);
      }
      System.out.println("");
    }
  }

  private void reserveSeat() {
    System.out.print("""
          ---------- Please select a seat ----------
          Our theater counts with 10 rows going from A to J
          And 10 seats each row, going from 0 to 9
          Select your seat by typing: e.g. A7
        """);
    System.out.print("Enter your seat: ");

    char[] seatElements = scanner.next().toUpperCase().toCharArray();

    if (seatElements.length != 2) {
      System.out.println("Invalid seat input");
      return;
    }

    boolean isRowValid = seatElements[0] >= 'A' && seatElements[0] <= 'J';
    boolean isColValid = seatElements[1] >= '0' && seatElements[1] <= '9';

    if (!isRowValid || !isColValid) {
      System.out.println("Invalid seat input");
      return;
    }

    int row = seatElements[0] - 'A';
    int col = seatElements[1] - '0';

    char seat = seats[row][col];

    if (seat == 'X') {
      System.out.println("Seat already reserved");
    } else {
      seats[row][col] = 'X';
      System.out.println("Seat reserved");
    }
  }

  public void enterSeatReserver() {
    initSeats();

    System.out.print("""
          Welcome to arkn cinemas
          The movie for tonight is
          How to Train Your Dragon
        """);

    int action = 0;

    do {
      System.out.print("""
              ---------- Menu ----------
              1) View available seats
              2) Select your seat
              3) Exit the program
          """);
      System.out.print("Choose an action: ");

      action = scanner.nextInt();

      switch (action) {
        case 1 -> viewSeats();
        case 2 -> reserveSeat();
        case 3 -> System.out.println("""
              Thanks for your visit
              See you soon ;)
            """);
        default -> {
          System.out.println("Number " + action + " is not a alid action");
          System.out.println("Try again");
        }
      }
    } while (action != 3);
    scanner.close();
  }

}