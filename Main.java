public class Main {
  public static void main(String[] args) {
    String excersise = "001";
    while (true) {
      if (excersise.equals("003"))
        break;

      if (TestJavaPrograms.Testing(excersise) == false) {
        break;
      }
      excersise = upExcersise(excersise);
    }
  }

  public static String upExcersise(String e) {
    // Convert string to integer
    int number = Integer.parseInt(e);
    // Increment the number
    number++;
    // Format back to a string with leading zeros if needed (e.g., "001" -> "002")
    return String.format("%03d", number);
  }
}
