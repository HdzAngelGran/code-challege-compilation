package reverseword;

public class Main {

  private static void reverseWord(String string) {
    String[] words = string.split("\\s");
    StringBuilder reversedString = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
      char[] chars = words[i].toCharArray();
      for (int j = chars.length - 1; j >= 0; j--) {
        reversedString.append(chars[j]);
      }
      reversedString.append(" ");
    }

    System.out.println(reversedString);
  }

  public static void main(String[] args) {
    reverseWord("Java Concept Of The Day");
  }
}
