public class Pharaoh extends King {
  private int numberOfPyramids;
  private String vizier;   //The vizier was second in command to the pharaoh.
  private String burialGrounds;
  private int dynasty;
  
  public Pharaoh ()
  {
    nationName = "Egypt";
    numberOfPyramids = 0;
    vizier = "";
    burialGrounds = "";
  }
  
  public Pharaoh (String n, double territory, int army, String nation, int castles, boolean m, int prisoners, String viz, String bur, int dyn)
  {
    super (n, territory, army, nation, castles, m, prisoners);
    vizier = viz;
    burialGrounds = bur;
    dynasty = dyn;
  }
  
  public void setName (String newName)
  {
    super.setName (newName);
  }
  
  public void setVizier (String name)
  {
    vizier = name;
  }
  
  public void digBurialGround (String burialName)
  {
    burialGrounds = burialName;
  }
  
  public void buildPyramid ()
  {
    numberOfPyramids++;
  }
  
  public void destroyPyramid ()
  {
    numberOfPyramids--;
  }
  
  public void changeDynasty (int newDynasty)
  {
    dynasty = newDynasty;
  }
   
  public boolean conquerTerritory (double territoryAmount)
  {
    if (super.conquerTerritory (territoryAmount) == true)
 return true;
    else
 return false;
  }
   
  public boolean grantIndependence (double territoryAmount)
  {
    if (super.grantIndependence (territoryAmount) == true)
 return true;
    else
 return false;
  }
  
  public void addSoldiers (int soldierAmount)
  {
    super.addSoldiers (soldierAmount);
  }
  
  public void removeSoldiers (int soldierAmount)
  {
    super.removeSoldiers (soldierAmount);
  }
  
  public void marry ()
  {
    super.marry ();
  }
  
  public void divorce ()
  {
    super.divorce ();
  }
  
  public void releasePrisoners ()
  {
    super.releasePrisoners ();
  }
   
  public String getPharaohName ()
  {
    return super.getName ();
  }
  
  public String getVizierName ()
  {
    return vizier;
  }
  
  public String getBurialGrounds ()
  {
    return burialGrounds;
  }
  
  public int getDynasty ()
  {
    return dynasty;
  } 
  
  public double getTerritorySquareKm ()
  {
    return super.getTerritorySquareKm ();
  }
  
  public int getArmySize ()
  {
    return super.getArmySize ();
  }
  
  public boolean married ()
  {
    return super.getMarried ();
  }
  
  public int getNumPrisoners ()
  {
    return super.getNumPrisoners ();
  }
}
