package emojiesum;

public class Main {
  private static void getSum(String string) {
    int sum = 0;
    char[] chars = string.toCharArray();

    for (int i = 1; i < chars.length - 1; i++) {
      if (chars[i] != ':')
        continue;

      if (chars[i - 1] == '(')
        sum += 1;
      else if (chars[i - 1] == ')')
        sum -= 1;

      if (chars[i + 1] == ')')
        sum += 1;
      else if (chars[i + 1] == '(')
        sum -= 1;
    }
    System.out.println(sum);
  }

  public static void main(String[] args) {
    getSum("(:()::::::))");
  }
}
