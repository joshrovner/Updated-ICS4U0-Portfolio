import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.io.*;

/**
 * This class creates the game over page. It displays the user's score, and writes it to the high scores file.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>timer </b>This variable stores an instance of the AnimationTimer class, which
 * allows for the stage to be continuously updated with graphics.
 * <p>
 * <b>room </b>This variable stores the current room the user is in.
 * <p>
 * <b>score </b>This variable stores the user's score.
 * <p>
 * <b>NUM_SCORES </b>This variable holds 10, the number of scores to be displayed in the page.
 * <p>
 * <b>userHomeFolder </b>This variable stores the user's computer's home folder, where the HighScores file is written.
 * <p>
 * <b>highScores </b>This variable stores the location and name of the HighScores file.
 * 
 * @author Joshua Rovner and Eric Myzelev
 * @version 4 03.06.2019
 */
public class GameOver
{
  private AnimationTimer timer;
  private final int room;
  private final int score;
  public static final int NUM_SCORES = 10;
  /*the following declarations, which writed a file to the computer itself, was take from:
   https://stackoverflow.com/questions/8357022/write-file-to-desktop*/
  private static String userHomeFolder = System.getProperty("user.home");
  public static File highScores = new File(userHomeFolder, "HighScores.txt");
  
  public GameOver (int score, int room)
  {
    this.score = score;
    this.room = room;
  }
  
  /**
   * This method updates the HighScores file. It initializes the contents that will be read in, reads in the data, adds
   * the newest score, and sorts the scores and their according names.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>line </b>This variable stores the contents of the current line.
   * <p>
   * <b>tempName </b>This variable stores a temporary name in order to sort the scores.
   * <p>
   * <b>lineCounter </b>This variable counts the lines of the text file while it is being read.
   * <p>
   * <b>tempScore </b>This variable stores a temporary score in order to sort the scores.
   * <p>
   * <b>topScorerNames </b>This array stores the list of names on the leaderboard.
   * <p>
   * <b>topScorerScores </b>This array stores the list of scores on the leaderboard.
   * 
   * 
   * @param lastRoom the last room played
   */
  public void updateHighScores (int lastRoom)
  {
    //variable declaration
    String line;
    String tempName;
    int lineCounter = -1;
    int tempScore;
    
    String[] topScorerNames = new String [NUM_SCORES + 1];
    int[] topScorerScores = new int [NUM_SCORES + 1];
    
    try
    {
      //initializing arrays to default values in case file does not yet exist or it does not contain 10 entries yet
      for (int i = 0 ; i <= NUM_SCORES ; i++)
      {
        topScorerNames [i] = "-------";
        topScorerScores [i] = -1;
      }
      
      //reads names and scores from file into arrays until a null or empty line is found if high scores file exists
      if (highScores.exists ())
      {
        try
        {
          BufferedReader reader = new BufferedReader (new FileReader (highScores));
          //loop for as long as there is data in  the file
          while ((line = reader.readLine ()) != null) //my father showed me that I can use readLine () method as a condition
          {
            if (line.equals (""))
              break;
            lineCounter++;
            String[] data = line.split (" ", 2);
            topScorerNames [lineCounter] = data [0];
            topScorerScores [lineCounter] = Integer.parseInt (data [1]);
          }
          reader.close ();
        }
        catch (IOException e)   //catch any file related errors
        {
        }
      }
      
      //TODO - into game over
      //checks user name and assigns "no_name" if nothing was entered
      if (lastRoom > 1)
      {
        if (CustomizationGraphics.userName.equals (""))
          CustomizationGraphics.userName = "no_name";
        //adding previous game score and username to topScores arrays
        lineCounter++;
        topScorerNames [lineCounter] = CustomizationGraphics.userName;
        topScorerScores [lineCounter] = score;
      }
      
      //sorting top 10 scores using insertion sort - www.java2novice.com/java-sorting-algorithms/insertion-sort/
      for (int i = 1 ; i < topScorerNames.length ; i++)
      {
        for (int j = i ; j > 0 ; j--)
        {
          if (topScorerScores [j] > topScorerScores [j - 1])
          {
            tempScore = topScorerScores [j];
            tempName = topScorerNames [j];
            topScorerScores [j] = topScorerScores [j - 1];
            topScorerNames [j] = topScorerNames [j - 1];
            topScorerScores [j - 1] = tempScore;
            topScorerNames [j - 1] = tempName;
          }
        }
      }
      
      //writing sorted NUM_SCORES to file
      try
      {
        PrintWriter output = new PrintWriter (new FileWriter (highScores));
        for (int i = 0 ; i < topScorerNames.length - 1 ; i++)
        {
          output.println (topScorerNames [i] + " " + topScorerScores [i]);
        }
        output.close ();
      }
      catch (IOException e)
      {
      }
    }
    catch (Exception e)
    {
    }
  }
  
  /**
   * /**
   * This method creates the game over page, including all buttons and graphics. It creates a layout consisting of the
   * home button, and then draws graphics inside an anonymous AnimationTimer 
   * class.
   * 
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>canvas </b>This variable stores an instance of the Canvas class, which allows graphics to be drawn.
   * <p>
   * <b>home </b>This variable stores an image of the home picture.
   * <p>
   * <b>layout </b>This variable stores the layout in which the home button is embedded.
   * <p>
   * <b>home1 </b>This variable stores an ImageView of the home picture.
   * <p>
   * <b>background </b>This variable stores an image of the background.
   * 
   * 
   * @param stage the window on which the game is being played
   */
  public void gameOver (Stage stage)
  {   
    //setting up canvas
    Canvas canvas = new Canvas (700, 500);
    
    //adding home button
    Image home = new Image ("images/Home.png");
    VBox layout = new VBox ();
    ImageView home1 = new ImageView (home);
    Button btn = new Button("", home1);
    layout.setPadding(new Insets(20, 20, 20, 590));
    btn.setOnMouseClicked(e -> {
      timer.stop();
      MainMenu.numTimesPlayed += 1;
      MainMenu.mainMenu (stage);
    });
    layout.getChildren().add(btn);
    MainMenu.root.getChildren().addAll (canvas, layout);
    
    //background image
    Image background = new Image("images/MainBackground.jpg");
    
    /**
     * This is an anonymous AnimationTimer class, which allows for the handle (long) method to be overridden and graphics
     * to be drawn inside of it.
     */
    timer = new AnimationTimer()
    {
      /**
       * This is the overriden method of the AnimationTimer class, where all graphics, such as the background and title,
       * are drawn.
       * 
       * <p>
       * <b>Local Variables: </b>
       * <p>
       * <b>theFont </b>This variable stores the font for the title.
       * 
       * 
       * @param currentNanoTime the current value of the JVM's time source
       */
      public void handle(long currentNanoTime)
      {
        //Drawing Graphics
        Main.gc.drawImage(background, 0, 0);
        Main.gc.setFill (Color.BEIGE);
        Main.gc.fillRect (200, 20, 300, 40);
        Main.gc.fillRect (75, 80, 550, 380);
        Main.gc.setStroke (Color.BLUE);
        Main.gc.strokeRect (200, 20, 300, 40);
        Main.gc.setStroke(Color.YELLOW);
        Main.gc.strokeRect (75, 80, 550, 380);
        Main.gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 22);
        Main.gc.setFont(theFont);
        Main.gc.setFill (Color.BLACK);
        Main.gc.fillText("Game Over", 290, 47);
        
        //Text On Screen
        if (room != 1)
        {
          if (room == 3)
            Main.gc.fillText("Well done!", 292, 230);
          else
            Main.gc.fillText("Try again next time.", 260, 200);
          Main.gc.fillText ("Your final score is " + score + ".", 255, 300);
        }
        else if (room == 1)
          Main.gc.fillText ("Try again next time.", 260, 248);
      }
    };
    timer.start ();
  }
}