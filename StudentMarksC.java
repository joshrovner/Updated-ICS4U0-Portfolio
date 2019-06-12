import java.util.*;
import java.io.*; 
/**
 * The StudentMarksC class sorts the data from the "A7-1" text file into numerical order.
 * 
 * @authors Joshua Rovner, Eric Myzelev, and Isaac Rosenberg
 * @version 1 03.24.2019
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>names </b> The array of student names.
 * <p>
 * <b>marks </b> The array of student marks.
 * <p>
 * <b>COUNTER </b> The length of each array.
 */
public class StudentMarksC extends StudentMarksA
{
  private String[] names;
  private int[] marks;
  private final int COUNTER = 35;
  
  /**
   * This method sorts the marks and names array using an insertion sort. The marks of two students are compared,
   * and if they are switched, the according student names will also be switched.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>n </b> The length of the marks array.
   * <p>
   * <b>currentKeyNames </b> The current position in the marks array.
   * <p>
   * <b>currentKeyMarks </b> The current position in the names array.
   */
  public void sort ()
  {
    read ();
    
    names = getNames ();
    marks = getMarks ();
    
    int n = marks.length; 
    
    for (int i = 1; i < n; i++)
    { 
      int currentKeyNames = marks[i]; 
      String currentKeyMarks = names[i];
      int j = i - 1; 
      
      while (j >= 0 && marks[j] > currentKeyNames) 
      { 
        marks[j + 1] = marks[j];
        names[j + 1] = names[j];
        j = j - 1; 
      } 
      marks[j + 1] = currentKeyNames; 
      names[j + 1] = currentKeyMarks;
    } 
  }
  
  /**
   * This method displays the sorted contents of the two arrays so that the marks are all in the same column regardless of name length.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>numSpaces </b> Stores the number of spaces to be made after printing the name.
   * <p>
   * <b>counter2 </b> Used to determine the number of spaces already made.
   * 
   * @Override
   */
  public void display ()
  {
    sort ();
    
    int numSpaces, counter2 = 0;
    for (int i = 0; i < COUNTER; i++)
    {
      counter2 = 0;
      System.out.print (names[i]);
      //determines number of spaces needed to keep all marks in the same column
      numSpaces = 10 - names[i].length ();
      while (counter2 < numSpaces)
      {
        System.out.print (" ");
        counter2++;  
      }
      if (i % 4 == 0 && i != 0)
        System.out.println (marks[i]);
      else
        System.out.print (marks[i] + "  ");
    }
  }
  
  /**
   * This is the main method - it creates a new object of the class, and calls the display () method.
   */
  public static void main (String[] args)
  { 
    StudentMarksC q3 = new StudentMarksC ();
    q3.display ();
  }
  
}
