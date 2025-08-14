package romannumber;

import java.util.Arrays;

public class Main {

  private enum RomanCatalog {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1),
    ;

    private final int decimal;

    private RomanCatalog(int decimal) {
      this.decimal = decimal;
    }

    public int getDecimal() {
      return this.decimal;
    }

    public static RomanCatalog getNearestDecimal(int decimal) {
      for (RomanCatalog romanCatalog : values()) {
        if (romanCatalog.getDecimal() <= decimal)
          return romanCatalog;
      }
      throw new IllegalArgumentException("Unknown enum type with uuid " + decimal + ", Allowed values for position are "
          + Arrays.toString(values()));
    }
  }

  public static void convertToRoman(int number) {
    StringBuilder romanNumber = new StringBuilder();

    while (number > 0) {
      RomanCatalog romanCatalog = RomanCatalog.getNearestDecimal(number);
      romanNumber.append(romanCatalog);
      number -= romanCatalog.getDecimal();
    }

    System.out.println(romanNumber);
  }

  public static void main(String[] args) {
    convertToRoman(66);
  }
}
