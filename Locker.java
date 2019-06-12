/**
 * The Locker class creates an object of a locker. It has a constructor which sets some default values, a getABook ()
 * method which gives the student the requested book, a putABook () method which puts a book back, a getJacket () method which
 * gives the student their jacket, a checkJacket () method which allows the student to check for their jacket, a putJacket ()
 * method which simulates the student putting their jacket into their locker, an assignOwner () method which assigns the locker's
 * owner, and a toString () method which returns the locker number.
 * the student's name.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>number </b>The variable stores the locker number.
 * <p>
 * <b>owner </b>This variable stores the locker's owner.
 * <p>
 * <b>studentJacker </b>This variable stores the student's jacket.
 * <p>
 * <b>books </b>This variable stores the student's books.
 * 
 * @author Joshua Rovner
 * @verson 1 18.04.2019
 */
public class Locker
{
  int number;
  Student owner;
  private Jacket studentJacket;
  private Book[] books;
  
  /**
   * This is the class constructor, which sets the owner to be the student being passed in, the number to be a random 4-digit
   * integer, and the number of books to 4.
   * 
   * @param me the Student owner of the locker
   */
  public Locker (Student me)
  {
    owner = me;
    number = (int) (9000 * Math.random () + 1000);
    books = new Book [4];
  }
  
  /**
   * This method checks through the locker's books for a book with the course name matching that of the requested course.
   * It creates a copy of the book at the current index, and returns the copy if the book is found, setting the book that was taken
   * to null in the locker. If the book is not found, null is returned.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>studentBook </b>The book at the current index in the book array.
   * 
   * 
   * @param course the course the books belongs to
   * @return the book which the student wants to take out
   */
  public Book getABook (String course)
  {
    Book studentBook;
    int i = 0;
    while (i < books.length - 1)
    {
      if (books[i] != null)
      {
        if (books[i].course.equals (course))
        {
          studentBook = new Book ();
          studentBook.course = books[i].course;
          studentBook.title = books[i].title;
          books[i] = null;
          return studentBook;
        }
      }
      i++;
    }
    return null;
  }
  
  /**
   * This method simulates the student putting a book into the locker. It checks for an empty slot in the locker, and as
   * soon as one is found, the book is inserted at that position. If there is no empty slot, an error message is printed
   * and the method is exited. If an empty slot is found, the student who put the book into the locker willhave it
   * removed from their array of books. 
   * 
   * @param book the book to be put back
   */
  public void putABook (Book book)
  {
    for (int i = 0 ; i < books.length ; i++)
    {
      if (books [i] == null)
      {
        books[i] = book;
        for (int x = 0; x < owner.books.length; i++)
        {
          if (owner.books[x] != null && owner.books[x].equals (book))
          {
            owner.books[i] = null;
            break;
          }
        }
        return;
      }
    }
    System.out.println ("Sorry, no more books can be put into the locker.");
    return;
  }
  
  /**
   * This method allows the student to get their jacket from their locker. First, it creates a copy of the student jacket.
   * Then, if the copy is empty, an error message is printed and the method is exited. Othewise, the jacket in the locker is
   * deleted and the copy is returned.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>jacketCopy </b>This variable stores a copy of the jacket in the locker.
   * 
   * @return the Jacket to be taken by the Student
   */
  public Jacket getJacket ()
  {
    Jacket jacketCopy = studentJacket;
    if (jacketCopy == null)
    {
      System.out.println ("There is no jacket in the locker to take.");
      return null;
    }
    else
    {
      studentJacket = null;
      return jacketCopy;
    }
  }
  
  /**
   * This method allows the student to check if their jacker is in their locker.
   * 
   * @return studentJacket the jacket in the locker
   */
  public boolean checkJacket ()
  {
    if (studentJacket == null)
      return false;
    return true;
  }
  
  /**
   * This method allows the student to put their jacket into their locker. First, it deletes the jacket from the student.
   * Then, if the locker already has a jacket, an error message is printed and the method is exited. Othewise, the student's
   * jacket is put into their locker.
   * 
   * 
   * @param thisJacket the jacket to be put into the locker
   */
  public void putJacket (Jacket thisJacket)
  {
    thisJacket.owner.myJacket = null;
    if (studentJacket != null)
    {
      System.out.println ("Sorry, jacket is already in locker.");
      return;
    }
    else
      studentJacket = thisJacket;
  }
  
  
  /**
   * This method assigns the owner of the locker to be the Student passed in the method call.
   * 
   * @param me the new Student owner
   */
  public void assignOwner (Student me)
  {
    owner = me;
  }
  
  /**
   * This method returns the locker number as a string.
   * 
   * @return the locker number
   * @Overrirde
   */
  public String toString ()
  {
    return "" + number;
  }
}
