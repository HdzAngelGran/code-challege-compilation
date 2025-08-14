package movezeros;

import java.util.Arrays;

public class Main {

  private static void moveZeros(int[] nums) {
    int[] newNumbers = new int[nums.length];
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        newNumbers[index] = nums[i];
        index++;
      }
    }
    for (int i = index; i < nums.length; i++) {
      newNumbers[nums.length - 1] = 0;
    }
    System.out.println(Arrays.toString(newNumbers));
  }

  public static void main(String[] args) {
    moveZeros(new int[] { 12, 0, 7, 0, 8, 0, 3 });

    moveZeros(new int[] { 1, -5, 0, 0, 8, 0, 1 });

    moveZeros(new int[] { 0, 1, 0, 1, -5, 0, 4 });

    moveZeros(new int[] { -4, 1, 0, 0, 2, 21, 4 });
  }
}
