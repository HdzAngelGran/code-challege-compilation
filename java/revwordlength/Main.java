package revwordlength;

public class Main {

  private static void reverseWordByLength(String phase) {
    String[] words = phase.split("\\s");

    String reversedString = phase.replaceAll("\\s", "");
    reversedString = new StringBuilder(reversedString).reverse().toString().toLowerCase();
    char[] letter = reversedString.toCharArray();

    StringBuilder reversedPhase = new StringBuilder();

    int phaseLength = 0;

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        reversedPhase.append(j == 0 ? Character.toUpperCase(letter[phaseLength]) : letter[phaseLength]);
        phaseLength++;
      }
      reversedPhase.append(" ");
    }

    System.out.println(reversedPhase.toString());
  }

  public static void main(String[] args) {
    reverseWordByLength("Java Concept Of The Day");
  }
}