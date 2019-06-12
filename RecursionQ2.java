/**
 * Thiis class takes an integer and returns the number with reversed digits.
 * 
 * @author Joshua Rovner
 * @version 1 04.15.2019
 */

public class RecursionQ2
{
  /**
   * This method takes an integer as a parameter and returns it if it is lower than 10, otherwise the next digit from the
   * back is returned.
   * 
   * @param n the integer to reverse
   * @return the next digit from the back of the original
   */
  public static int revDigits (int n)
  {
    if (n < 10)
      return n;
    return ((n % 10) * ((int) Math.pow (10, (int) Math.log10 (n)))) + revDigits (n / 10);
  }
  
  /**
   * This is the main method of the class. It calls the revDigits () method twice and prints out the result each time.
   */
  public static void main (String[] args)
  {
    System.out.println (RecursionQ2.revDigits (543));
    System.out.println (RecursionQ2.revDigits (4));
  }
}