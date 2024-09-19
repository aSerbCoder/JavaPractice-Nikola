package key;

public class Key_005 {
  public static void main(String[] args) {
    int sum = 0;

    // remember, sum up numbers 0 -> 9
    for (int step = 0; step < 10; step++) {
      // in other words, sum is equal to itself
      // plus whatever is on the right side.
      sum += step;
    }

    // print sum, you should know how to do this
    // by now
    System.out.println(sum);
  }
}
