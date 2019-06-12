/** 
  * @Author Joshua Rovner and Eric Myzelev
  * @Version 1
  */
public class King
{
    private String name;
    private double territorySquareKm;
    private int armySize;
    protected String nationName;
    protected int numberOfCastles;
    private boolean married;
    private int numPrisoners;

    /**
     * This is the default constructor. 
     */
    public King ()
    {
      name = "";
      territorySquareKm = 100000;
      armySize = 10000;
      nationName = "";
      numberOfCastles = 0;
      married = false;
      numPrisoners = 0;
    }

    
    /**
     * This is the overloaded constructor that takes several parameters.
     * @param n the name of the king
     * @param territory the amount of territory owned by the nation
     * @param army the size of the army
     * @param nation the name of the nation
     * @param castles the number of castles
     * @param m whether or not king is married
     * @param prisoners the number of prisoners
     */
    public King (String n, double territory, int army, String nation, int castles, boolean m, int prisoners)
    {
      name = n;
      territorySquareKm = territory;
      armySize = army;
      nationName = nation;
      numberOfCastles = castles;
      married = m;
      numPrisoners = prisoners;
    }

    /**
     * This method changes the name of the king.
     * @param newName the new name of the king.
     */
    public void setName (String newName)
    {
      name = newName;
    }

    /**
     * This method changes the name of the nation.
     * @param newName the new name of the nation.
     */
    public void setNationName (String newNationName)
    {
      nationName = newNationName;
    }

    /**
     * This method simulates the conquering of territory. Each square kilometer  takes 5 soldiers to capture.
     * @return true if the army is large enough to conquer the territory and false if the army is too small.
     * @param territoryAmount the new amount of territory to be conquered.
     */
    public boolean conquerTerritory (double territoryAmount)
    {
      if (territoryAmount * 5 <= armySize)
      {
        territorySquareKm += territoryAmount;
        armySize -= territoryAmount * 5;
        numPrisoners += territoryAmount / 2;
        return true;
      }
      else
        return false;
    }

    /**
     * This method simulates the granting of independance to another nation/colony.
     * @return true if territorySquareKm is large enough to grant independance to the new nation and false if territorySquareKm is too small.
     * @param territoryAmount the amount of territory granted to the new nation.
     */
    public boolean grantIndependence (double territoryAmount)
    {
      if (territoryAmount < territorySquareKm)
      {
        territorySquareKm -= territoryAmount;
        return true;
      }
      else
        return false;
    }

    /**
     * This method increases armySize.
     * @param soldierAmount the number of soldiers to be added.
     */
    public void addSoldiers (int soldierAmount)
    {
      armySize += soldierAmount;
    }

    /**
     * This method decreases armySize.
     * @param soldierAmount the number of soldiers to be removed.
     */
    public void removeSoldiers (int soldierAmount)
    {
      armySize -= soldierAmount;
    }

    /**
     * This method increases numberOfCastles.
     * @param castleAmount the number of castles to be built.
     */
    public void buildCastles (int castleAmount)
    {
      numberOfCastles += castleAmount;
    }

    /**
     * This method decreases numberOfCastles.
     * @return true if there are less castles to be destroyed than their are castles and returns false otherwise.
     * @param castleAmount the number of castles to be destroyed.
     */
    public boolean destroyCastles (int castleAmount)
    {
      if (castleAmount < numberOfCastles)
      {
        numberOfCastles -= castleAmount;
        return true;
      }
      else
        return false;
    }

    /**
     * This method sets married to true.
     */
    public void marry ()
    {
      married = true;
    }

    /**
     * This method sets married to false.
     */
    public void divorce ()
    {
      married = false;
    }

    /**
     * This method sets numPrisoners to 0.
     */
    public void releasePrisoners ()
    {
      numPrisoners = 0;
    }

    /**
     * This method returns name.
     * @return the name of the king.
     */
    public String getName ()
    {
      return name;
    }

    /**
     * This method returns territorySquareKm.
     * @return the amount of territory
     */
    public double getTerritorySquareKm ()
    {
      return territorySquareKm;
    }

    /**
     * This method returns armySize.
     * @return the size of the army.
     */
    public int getArmySize ()
    {
      return armySize;
    }

    /**
     * This method returns nationName.
     * @return the name of the nation.
     */
    public String getNationName ()
    {
      return nationName;
    }

    /**
     * This method returns numberOfCastles.è
     * @return the number of castles.
     */
    public int getNumberOfCastles ()
    {
      return numberOfCastles;
    }

    /**
     * This method returns married.
     * @return whether or not the king is married
     */
    public boolean getMarried ()
    {
      return married;
    }

    /**
     * This method returns numPrisoners.
     * @return the number of prisoners
     */
    public int getNumPrisoners ()
    {
      return numPrisoners;
    }
}
