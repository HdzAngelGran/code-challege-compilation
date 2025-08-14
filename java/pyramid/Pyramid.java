package pyramid;

import java.util.Scanner;

public class Pyramid {

  private Scanner scanner = new Scanner(System.in);

  private void printPyramid(int height) {
    for (int i = 1; i <= height; i++) {
      for (int j = 0; j < height - i; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  public void enterPyramid() {
    System.out.println("Welcome to the pyramid generator");
    int action = 0;
    do {
      System.out.print("""
            ---------- Menu ----------
            1) Create pyramid
            2) EXIT
          """);
      action = scanner.nextInt();
      switch (action) {
        case 1 -> {
          System.out.print("How tall do you want your pyramid? ");
          int height = scanner.nextInt();
          printPyramid(height);
        }
        case 2 -> {
          System.out.println("""
                Thanks for your visit
                See you soon ;)
              """);
        }
        default -> {
          System.out.println("Number " + action + " is not a valid action");
          System.out.println("Try again");
        }
      }

    } while (action != 2);
    scanner.close();
  }
}
