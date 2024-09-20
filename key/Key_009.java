package key;

public class Key_009 {
  public static void main(String[] args) {
    int end = 100;

    for (int i = 1; i <= end; i++) {

      if (((i % 5) == 0) && ((i % 7) == 0)) {
        System.out.println("fizzbuzz");
      } else if ((i % 5) == 0) {
        System.out.println("fizz");
      } else if ((i % 7) == 0) {
        System.out.println("buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
