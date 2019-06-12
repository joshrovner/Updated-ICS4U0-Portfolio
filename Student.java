/**
 * The Student class creates an object of a student. It has a constructor which sets some default values, a sentToOffice ()
 * method which simulates the student being sent to the office for a certain reason, and a toString () method which returns
 * the student's name.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>number </b>The variable stores the student's number.
 * <p>
 * <b>name </b>This variable stores the student's name.
 * <p>
 * <b>myLocker </b>This variable stores the student's locker.
 * <p>
 * <b>myJacket </b>This variable stores the student's jacket.
 * <p>
 * <b>books </b>This array variable stores the books the student is carrying with them.
 * 
 * @author Joshua Rovner
 * @verson 1 18.04.2019
 */
public class Student
{
  String number;
  String name;
  Locker myLocker;
  Jacket myJacket;
  Book[] books;
  
  /**
   * This is the class constructor. It assigns the student's name to the name passed in, the student number to be a string form
   * of a random 9 digit number, gives the student a locker and a jacket, and sets the number of books the student has to 4.
   * 
   * @param myName the student's name
   */
  public Student (String myName)
  {
    name = myName;
    number = "" + (int) (899999999 * Math.random () + 100000000);
    myLocker = new Locker (this);
    myJacket = new Jacket (this);
    books = new Book [4];
  }
  
  /**
   * This method prints the student going to the office, with the reason for doing so being passed in the method call.
   * 
   * @param reason the reason why the student was sent to the office
   */
  public void sentToOffice(String reason)
  {
    System.out.println (toString () + " has been sent to the office because he " + reason);
  }
  
  /** 
   * This method returns the name of the student.
   * 
   * @return the student's name
   * @Override
   */
  public String toString()
  {
    return name;
  }
  
} // Student class
