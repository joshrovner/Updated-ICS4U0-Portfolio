/**
 * The VirtualSchool class simulates a school where a student tries to enter classrooms. They are either turned away or 
 * allowed to enter based on certain criteria.
 * 
 * @author Joshua Rovner
 * @version 1 24.04.2019
 */
public class VirtualSchool
{
  /**
   * This is the main method od the class. First, a student named "Joshua" and a computer science classroom are made. Then,
   * the student puts their jacket away and tries to enter the classroom, but since they do not have their textbook, they are
   * denied entry, sent to the office and given their book. Then, the student takes their jacket from their locker and tries
   * to enter the classroom, gets denied, and puts the jacket back. But, they also put their textbook away, and get denied
   * when trying to enter again due to this. Finally, the student gets their textbook and is allowed into class.
   */
  public static void main (String[] args)
  {
    Student me = new Student("Joshua");
    ClassRoom ics = new ClassRoom ("ICS4U0", "Ms. Krasteva");
    
    System.out.println("Student: "+me+"\n"); 
    
    me.myLocker.putJacket (me.myJacket);
    System.out.println (me + " put his jacket away.");
    
    System.out.println (me + " is attempting to enter computer science class.");
    
    if (ics.enter (me) == true)
    {
      System.out.println (me + " was allowed into class.");
    }
    else
    {
      System.out.println (me + " was not allowed into class.");        
    }
    System.out.println ();
    
    me.myJacket = me.myLocker.getJacket ();
    System.out.println (me + " has taken his jacket from his locker.");
    System.out.println (me + " is attempting to enter computer science class.");
    
    if (ics.enter (me) == true)
    {
      System.out.println (me + " was allowed into class.");
    }
    else
    {
      System.out.println (me + " was not allowed into class.");        
    }
    System.out.println ();
    
    me.myLocker = null;
    System.out.println (me + " had his locker removed.");
    System.out.println (me + " is attempting to enter computer science class.");
    
    if (ics.enter (me) == true)
    {
      System.out.println (me + " was allowed into class.");
    }
    else
    {
      System.out.println (me + " was not allowed into class.");        
    }
    
    System.out.println ();
    
    System.out.println (me + " has put his " + me.books[0].title + " book away.");
    me.myLocker.putABook (me.books[0]);
    
    System.out.println (me + " is attempting to enter computer science class without his textbook.");
    
    if (ics.enter (me) == true)
    {
      System.out.println (me + " was allowed into class.");
    }
    else
    {
      System.out.println (me + " was not allowed into class.");        
    }
    System.out.println ();
    
    System.out.println (me + " is attempting to enter computer science class with his textbook.");
    
    if (ics.enter (me) == true)
    {
      System.out.println (me + " was allowed into class.");
    }
    else
    {
      System.out.println (me + " was not allowed into class.");        
    }
  }
}

