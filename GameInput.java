import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import java.util.*;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * This class deals with user input during the gameplay. It sets the current room, and contains a play (Stage) method,
 * which actually checks user input and deals with it accordingly, in terms of the rocket position and decreasing fuel.
 * 
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>graphics </b>This variable stores an instance of the GameGraphics class to draw all the graphics.
 * <p>
 * <b>keyList </b>This variable stores the key presses, which ultimately control the direction of the rocket.
 * <p>
 * <b>layout </b>This variable stores the layout holding the home button.
 * 
 * 
 * @author Joshua Rovner and Eric Myzelev
 * @version 4 03.06.2019
 */
public class GameInput
{
  private static GameGraphics graphics;
  private static ArrayList<String> keyList = new ArrayList<String> ();
  public static VBox layout;
  
  /**
   * This method is the main part of this class, and does most of the processing. First, it sets the room. Then, it
   * continuously checks for up, down, or right key presses, and alters the rocket position and amount of fuel left
   * accordingly. Finally, it checks for a key release, where it slows down the rocket and resets the fuel to a slower 
   * depletion rate.
   * 
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>key </b>This variable stores the current key press.
   * <p>
   * <b>canvas </b>This variable stores an instance of the Canvas class, which allows graphics to be drawn.
   * <p>
   * <b>home </b>This variable stores an image of the home picture.
   * <p>
   * <b>layout </b>This variable stores the layout in which the home button is embedded.
   * <p>
   * <b>home1 </b>This variable stores an ImageView of the home picture.
   * <p>
   * <b>btn </b>This variable stores an instance of the Button class for the home button.
   * 
   * 
   * @param stage the window on which the game is being played
   * @param room the current room that is being played in
   */
  public static void play (Stage stage, int room)
  {
    //sets room
    if (room == 1)
      graphics = new DeficienciesRoom (stage);
    else if (room == 2)
      graphics = new PanicRoom (stage);
    else
      graphics = new EscapeRoom (stage);
    graphics.start();
    
    //sets up page
    Canvas canvas = new Canvas (700, 500);
    
    //creating layout and image button
    Image home = new Image ("images/Home.png");
    layout = new VBox ();
    ImageView home1 = new ImageView (home);
    Button btn = new Button("", home1);
    layout.setPadding(new Insets(20, 20, 20, 30));
    //specifying mouse click response
    btn.setOnMouseClicked(e -> {
      graphics.stop();
      MainMenu.mainMenu (stage);
    });
    //adding contents to the page
    layout.getChildren().add(btn);
    MainMenu.root.getChildren().addAll (canvas, layout);
    
    MainMenu.scene.setOnMouseClicked
      (
       new EventHandler<MouseEvent>()
         {
      public void handle(MouseEvent e)
      {
      }
    });
    
    //checks for key press on right, up, or down
    MainMenu.scene.setOnKeyPressed(
                                   new EventHandler<KeyEvent>() {
      public void handle(KeyEvent e)
      {
        String key = e.getCode().toString();
        if (graphics.getRocket().getYPos () < 0 || graphics.getRocket().getYPos () > 461)
        {
          graphics.getRocket().setYVel(0);
          graphics.getRocket().setFuelVel(-1);
        }
        //key press right
        else if (key.equals ("D"))
        {
          if (!keyList.contains("D"))
            keyList.add("D");
          graphics.gameMovement (true);
          graphics.getRocket().setFuelVel(-2);
        }
        //key press up
        if (key.equals ("W"))
        {
          if (!keyList.contains("W"))
            keyList.add("W");
          graphics.getRocket().setYVel(-5);
          graphics.getRocket().setFuelVel(-2);
        }
        //key press down
        if (key.equals ("S"))
        {
          if (!keyList.contains("S"))
            keyList.add("S");
          graphics.getRocket().setYVel(5);
          graphics.getRocket().setFuelVel(-2);
        }
      }
    });
    
    //checks for key release
    MainMenu.scene.setOnKeyReleased(
                                    new EventHandler<KeyEvent>() {
      public void handle(KeyEvent e)
      {
        String key = e.getCode().toString();
        
        keyList.remove(key);
        
        if (!keyList.contains("W") && !keyList.contains("S") && !keyList.contains("D"))
          graphics.getRocket().setFuelVel(-1);
        
        if (key.equals ("W"))
          graphics.getRocket().setYVel(0);
        else if (key.equals ("S"))
          graphics.getRocket().setYVel(0);
        else if (key.equals ("D"))
          graphics.gameMovement(false);
      }
    });
  }
}