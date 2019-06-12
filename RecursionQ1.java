/**
 * This class allows the user to enter a group of strings, and once they enter a period, the strings will be returned in reverse order.
 * 
 * @author Joshua Rovner
 * @version 1 04.15.2019
 * 
 * <p>
 * <b>Global Variables:
 * <p>
 * <b>textInput </b> This stores a collection of all the string inputs.
 */

import java.util.*;

public class RecursionQ1
{
  static String textInput;
  
  /**
   * This method reads in the input and adds it to the textInput variable.
   * 
   * <p>
   * <b>Local Variables
   * <p>
   * <b>sc </b>The scanner used to read in the input.
   */
  public static void readInput ()
  {
    textInput = "";
    Scanner sc = new Scanner (System.in);
    while (textInput.indexOf(".") == -1)
    {
      System.out.println ("Enter any string: ");
      String nextStr = sc.nextLine();
      textInput += nextStr +"\n";
    }
  }
  
  /**
   * This method processes the text by finding every new line and returning the rest of the string. In this fashion,
   * each string entered can be returned in opposite order.
   * 
   * @param inputText the collection of all inputs
   * @return the rest of the string after the first new line is found
   */
  public static String revText (String inputText)
  {
    if (inputText.indexOf ("\n") == -1)
      return inputText;
    return revText (inputText.substring (inputText.indexOf ("\n") + 1)) + inputText.substring (0, inputText.indexOf("\n") + 1);
  }
  
  /**
   * This is the main method of the class. It calls the readInput () method and then prints out the result of the revText method
   * based on the input entered in the previous method.
   */
   public static void main (String[] args)
  {
    readInput ();
    System.out.println (RecursionQ1.revText (textInput));
  }
}