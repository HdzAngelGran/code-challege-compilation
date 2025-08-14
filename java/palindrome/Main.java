package palindrome;

public class Main {
  public static boolean palindrome(int number) {
    String numberString = Integer.toString(number);
    String reversedNumber = new StringBuilder(numberString).reverse().toString();

    int sumDigits = 0;
    for (char digit : numberString.toCharArray()) {
      sumDigits += Character.getNumericValue(digit);
    }

    boolean isEven = sumDigits % 2 == 0;

    return numberString.equals(reversedNumber) && isEven;
  }

  public static void main(String[] args) {
    boolean result = palindrome(121);
    System.out.println(result);
  }
}
