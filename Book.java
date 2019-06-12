/**
 * The Book class creates an object of the book. It has setTitle and setCourse mutators, as well as a toString method
 * which returns the title of the book.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>title </b>This variable stores the title of the book.
 * <p>
 * <b>course </b>This variable stores the course for which the book is used.
 * 
 * @author Joshua Rovner
 * @verson 1 18.04.2019
 */
public class Book
{
  String title;
  String course;
  
  /**
   * This is the class constructor. It creates a default Book without any features.
   */
  public Book()
  {
  }
  
  /**
   * This method sets the title to the parameter passed in with the method call.
   * 
   * @param title the new title of the book
   */
  public void setTitle (String title)
  {
    this.title = title;
  }
  
  /**
   * This method sets the course of the book to the parameter passed in with the method call.
   * 
   * @param course the new course of the book
   */
  public void setCourse(String course)
  {
    this.course = course;
  }
  
  /**
   * This method returns the title of the book.
   * 
   * @return the title of the book
   * @Overrirde
   */
  public String toString()
  {   
    return course;
  } 
}
