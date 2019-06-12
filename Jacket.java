/**
 * The Jacket class creates an object of a jacket. It has a toString method which returns the name of the jacket's owner.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>owner </b>The student that owns the jacket.
 * 
 * @author Joshua Rovner
 * @verson 1 18.04.2019
 */
public class Jacket
{
  Student owner;
  
  /**
   * This is the class constructor, which assigns ownership of the jacket to the student passed in during the object
   * creation.
   * 
   * @param me the Student owner of the jacket
   */
  public Jacket (Student me)
  {
    owner = me;
  }
  
  /**
   * This method returns the jacket's owner's name.
   * 
   * @return the name of the jacket owner
   * @Overrirde
   */
  public String toString ()
  {
    return owner.toString ();
  }
  
}
