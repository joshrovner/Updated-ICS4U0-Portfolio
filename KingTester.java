/** 
  * @Author Joshua Rovner and Eric Myzelev
  * @Version 1
  */
public class KingTester
{
    /**
     * This is the main method, which creates objects of the King and Pharaoh classes. 
     */
    public static void main (String[] args)
    {
      King k = new King ();
      k.setName ("Henry IX");
      k.setNationName ("Great Britain");
      k.addSoldiers (100000);
      System.out.println (k.getName ());
      System.out.println ("Conquered territory: " + k.conquerTerritory (10000));
      System.out.println ("The number of castles is: " + k.getNumberOfCastles ());
      System.out.println ("The number of prisoners is " + k.getNumPrisoners ());
      System.out.println ("The number of soldiers in the army is " + k.getArmySize ());
      System.out.println ("The size of " + k.getNationName () + " is " + k.getTerritorySquareKm () + " km2.");
      k.destroyCastles (1);
      
      System.out.println ();
      
      Pharaoh p = new Pharaoh ("Amenhotep III", 800000.0, 100000, "Ancient Egypt", 2, false, 10000, "Amenhotep-Huy", "King's Valley 22", 18);
      System.out.println (p.getName ());
      System.out.println ("Independance Granted: " + p.grantIndependence (5000));
      p.buildPyramid ();
      p.removeSoldiers (20000);
      p.buildCastles (2);
      p.destroyPyramid ();
      p.marry ();
      System.out.println ("The name of the vizier is " + p.getVizierName ());
      System.out.println ("The name of the pharaoh is " + p.getName ());
      System.out.println ("Pharaoh is Married: " + p.getMarried ());
      System.out.println ("The name of the nation is: " + p.getNationName ());
      System.out.println ("The number of castles is: " + p.getNumberOfCastles ());
    }
}
