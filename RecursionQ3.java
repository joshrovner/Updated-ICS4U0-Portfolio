/**
 * This class searches through an array of comparables and tries to find a certain target element.
 * 
 * @author Joshua Rovner
 * @version 1 04.15.2019
 */

import java.util.*;

public class RecursionQ3
{
  /**
   * This method takes an array and target as parameters, and searches for the target in the array. If it is not found,
   * the same array but with the first index removed is returned. If it is found, the method returns true, and if the whole
   * array has been searched without finding the target, false is returned.
   * 
   * @param array the array of Comparables to search through
   * @param targetElement the target to find
   * @return whether or not the target is found
   */
  public static boolean searchItem (Comparable [] array, Comparable targetElement)
  {
    if (array [0].compareTo (targetElement) == 0) 
      return true;
    if (array.length == 1) 
      return false;
    return searchItem (Arrays.copyOfRange (array, 1, array.length - 1), targetElement);
  }
  
  /**
   * This is the main method of the class. It creates a Comparable array with a few strings and then prints out the
   * result of a call to the searchItem () method searching for the string "Hello".
   */
  public static void main (String[] args)
  {
    Comparable[] array = {"Hello", "My", "Name", "Is", "Josh"};
    System.out.println (RecursionQ3.searchItem (array, "Hello"));
  }
}
