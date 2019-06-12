/**
 * The ClassRoom class creates an object of a classroom. It has a constructor which sets the course and teacher name, and an
 * enter method which checks if the student is allowed to enter the class based on several criteria.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>course </b>This variable stores the course code.
 * <p>
 * <b>teacher </b>This variable stores the teacher's name.
 * 
 * @author Joshua Rovner
 * @verson 1 18.04.2019
 */
public class ClassRoom
{
  private String course;
  private String teacher;
  
  /**
   * This is the class constructor, which sets the classroom's course code and teacher to the parameters passed in.
   * 
   * @param course the classroom's course code
   * @param teacher the teacher in the classroom
   */
  public ClassRoom (String course, String teacher)
  {
    this.course = course;
    this.teacher = teacher;
  }
  
  /**
   * This method checks if a student is allowed to enter a classroom. The student will be
   * denied entry if they do not have a locker, brought their jacket, or didn't bring their computer science book. 
   * If they are missing a locker, they are sent to the office and given a locker, if they have their jacket, 
   * they are sent to their locker  to put it away, and if they do not have their computer science book, they are sent 
   * to the office. If the student has the book in their locker, they take the book out, but if they do not have the book
   * at all (neither the student's nor the locker's books array contains it), the book is "given to them by the office" - 
   * a new Book is created and its variables are given proper values.
   * If all of the original criteria are met, the student is granted entry to the class.
   * 
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>studentHasBook </b>This variable stores whether or not the student has possession of the book.
   * 
   * @param me the Student trying to enter
   * @return whether or not the student was allowed to enter
   */ 
  public boolean enter (Student me)
  {
    boolean studentHasBook = false;
    
    if ((me.myLocker) == null)
    {
      me.sentToOffice ("does not have a locker.");
      me.myLocker = new Locker (me);
      me.myLocker.putJacket (new Jacket (me));
      return false;
    }
    else if (me.myJacket != null)
    {
      me.myLocker.putJacket (me.myJacket);
      return false;
    }
    for (int i = 0; i < me.books.length; i++)
    {
      if (me.books[i] != null)
      {  
        if (me.books[i].course.equals ("ICS4U0"))
          return true;
      }
    }
    me.sentToOffice ("does not have the correct book.");
    for (int i = 0; i < me.books.length; i++)
    {
      if (me.books[i] == null)
        me.books[i] = me.myLocker.getABook ("ICS4U0");
    }
    for (int i = 0; i < me.books.length; i++)
    {
      if (me.books[i] != null)
      {
        if (me.books[i].course.equals ("ICS4U0"))
          studentHasBook = true;
      }
    }
    if (!studentHasBook)
    {
      me.books [0] = new Book ();
      me.books [0].course = "ICS4U0";
      me.books[0].title = "AP Prep - Computer Science A";
    }
    return false;
  }
}

