package exercises;

////////////////////////////////////////////////////////////////////
// Welcome to the fifth exercise!                                 //
//                                                                //
// QUIZ TIME                                                      // 
//                                                                // 
// Write fizzbuzz!                                                //
// This was the first homework assignment I had                   //       
// in a class equivalent to this                                  // 
//                                                                // 
//  https://en.wikipedia.org/wiki/Fizz_buzz                       //
//    ^ Explains what fizzbuzz is                                 // 
//                                                                //
//  Remember.. % is modulo                                        //
//  https://www.google.com/search?client=firefox-b-1-d&q=modulo   //
////////////////////////////////////////////////////////////////////

public class Exercise_007 {
  public static void main(String[] args) {

    for (int i = 1; i <= end; i++) {

      if ((({INSERT} % 5) == 0) && (({INSERT} % 7) == 0)) {
        System.out.println("fizzbuzz");
      } else if (({INSERT} % 5) == 0) {
        System.out.println("fizz");
      } else if (({INSERT} % 7) == 0) {
        System.out.println("buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
