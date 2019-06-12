import java.util.*;
import java.io.*; 
/**
 * This class reads in the contents of the "A7-1" text file and splits them into two arrays:
 * one containing names, and the other containing grades. Then, it displays the according names
 * and grades on each line, 5 spaces apart.
 * 
 * @authors Joshua Rovner, Eric Myzelev, and Isaac Rosenberg
 * @version 1 03.24.2019
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>names </b> Stores the list of names from the input file.
 * <p>
 * <b>marks </b> Stores the list of marks from the input file.
 * <p>
 * <b>counter </b> Used to determine the current line that is being read.
 */
public class StudentMarksA
{
  private String[] names;
  private int[] marks;
  private int counter;
  
  /**
   * This method reads in the file contents into two separate arrays.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>file </b> Stores the input file name.
   */
  public void read ()
  {
    counter = 0;
    File file = new File ("A7-1.txt");
    
    //determines number of lines
    try
    {
      Scanner sc = new Scanner (file);
      while (sc.hasNextLine ())
      {
        counter++; 
        sc.nextLine ();
      }
    }
    catch (FileNotFoundException e)
    {
    }
    
    //array creation
    names = new String [counter / 2];
    marks = new int [counter / 2];
    
    counter = 0;
    
    //assigning input file contents to arrays
    try
    {
      Scanner sc2 = new Scanner (file);
      while (sc2.hasNextLine ())
      {
        names [counter] = sc2.nextLine ();
        counter++;
        marks[counter - 1] = Integer.parseInt (sc2.nextLine ());
      }
    }
    catch (FileNotFoundException e)
    {
    }
  }
  
  /**
   * This method displays the contents of the two arrays so that the marks are all in the same column regardless of name length.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>numSpaces </b> Stores the number of spaces to be made after printing the name.
   * <p>
   * <b>counter2 </b> Used to determine the number of spaces already made.
   */
  public void display ()
  {
    int numSpaces, counter2 = 0;
    for (int i = 0; i < counter; i++)
    {
      counter2 = 0;
      //determines number of spaces needed to format names properly
      numSpaces = 7 - names[i].length ();
      while (counter2 < numSpaces)
      {
        System.out.print (" ");
        counter2++;  
      }
      System.out.print (names[i] + "     ");
      if (i % 4 == 0 && i != 0)
        System.out.println (marks[i]);
      else
        System.out.print (marks[i]);
    }
  }
  
  /**
   * This method returns the names array.
   * 
   * @return names the array of student names
   */
  public String[] getNames ()
  {
    return names;
  }
  
  /**
   * This method returns themarks array.
   * 
   * @return marks the array of student marks
   */
  public int[] getMarks ()
  {
    return marks;
  }
  
  /**
   * The main method creates an object of the class and then calls the read () and display () methods,
   * resulting in an output with 2 columns, 5 spaces apart.
   */
  public static void main (String[] args)
  {
    StudentMarksA q1 = new StudentMarksA ();
    q1.read ();
    q1.display ();
  }
  
}
