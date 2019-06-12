import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import java.awt.*;
import java.util.*;

/**
 * This class creates the graphics for the game, including the rocket, obstacles, and outlined annswers.
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>stage </b>This variable contains the window on which the game is being played.
 * <p>
 * <b>obstaclePosition </b>This variable stores the positon of the obstacles on the screen.
 * <p>
 * <b>backgroundPosition </b>This variable stores the position of the background.
 * <p>
 * <b>background </b>This variable stores an image of the background.
 * <p>
 * <b>round </b>This variable stores the current round number.
 * <p>
 * <b>randomNum </b>This variable stores the height of the top obstacle.
 * <p>
 * <b>randomNum2 </b>This variable stores the height of the middle obstacle.
 * <p>
 * <b>topObs </b>This variable holds an Obstacle instance to act as the top obstacle.
 * <p>
 * <b>middleObs </b>This variable holds an Obstacle instance to act as the middle obstacle.
 * <p>
 * <b>bottomObs </b>This variable holds an Obstacle instance to act as the bottom obstacle.
 * <p>
 * <b>currentQuestion </b>This variable stores the current question being asked.
 * <p>
 * <b>currentOptions </b>This variable stores the current possible options.
 * <p>
 * <b>currentAnswer </b>This variable stores the current answer.
 * <p>
 * <b>indices </b>This arraylist stores the indices of the already solved questions to avoid repetition.
 * <p>
 * <b>labelFont1 </b>This variable stores the first label font.
 * <p>
 * <b>labelFont2 </b>This variable stores the second label font.
 * <p>
 * <b>fuelAndScore </b>This variable stores the font for the fuel and score text.
 * <p>
 * <b>monospaceFont </b>This variable stores the font for the questions and yes or no answers.
 * <p>
 * <b>monospaceFont2 </b>This variable stores the font for the short answers.
 * 
 * 
 * @author Joshua Rovner and Eric Myzelev
 * @version 4 03.06.2019
 */
public abstract class GameGraphics extends AnimationTimer
{
  private Stage stage;
  private Rocket rocket;
  private int obstaclePosition;
  private int backgroundPosition;
  private Image background;
  private int round;
  private int randomNum;
  private int randomNum2;
  private Obstacle topObs;
  private Obstacle middleObs;
  private Obstacle bottomObs;
  private String currentQuestion;
  private String [] currentOptions;
  private boolean currentAnswer;
  private ArrayList<Integer> indices;
  
  private final Font labelFont1 = Font.font("Arial", FontWeight.BOLD, 30);
  private final Font labelFont2 = Font.font("Arial", FontWeight.BOLD, 15);
  private final Font fuelAndScore = Font.font("Arial", FontWeight.BOLD, 18);
  private final Font monospaceFont = Font.font("Lucida Console", FontWeight.EXTRA_BOLD, 20);
  private final Font monospaceFont2 = Font.font("Lucida Console", FontWeight.EXTRA_BOLD, 10);
  
  /**
   * This is the class constructor, which takes parameters for the stage and for the amount of fuel. Then, it sets
   * values for some of the class variables to be used during the game.
   * 
   * 
   * @param stage the window on which the game is being played
   * @param fuel the amount of fuel to begin with
   * @param room the current room
   */
  public GameGraphics (Stage stage, int fuel, int room)
  {
    rocket = new Rocket (230, fuel);
    this.stage = stage;
    obstaclePosition = 800;
    backgroundPosition = 0;
    background = new Image("images/GameBackground.jpg");
    round = 1;
    randomNum = (int) (84 * Math.random () + 50);
    randomNum2 = (int) (50 * Math.random () + 50);
    indices = new ArrayList<Integer> ();
    setupQuestions (room);
  }
  
  /**
   * This method is abstract, and is provided implementation in each of the rooms. It takes a boolean 'move' parameter
   * to see if the game should be moving.
   * 
   * 
   * @param move whether or not the game should keep going
   */
  public abstract void gameMovement (boolean move);
  
  /**
   * This method returns the current rocket.
   * 
   * 
   * @return the rocket being controlled
   */
  public Rocket getRocket ()
  {
    return rocket;
  }
  
  /**
   * This returns the stage, where the whole application is being run.
   * 
   * 
   * @return the game's stage
   */
  public Stage getStage ()
  {
    return stage;
  }
  
  /**
   * This method finds the last index of a space in a passed string, used to avoid words from getting cut off.
   * 
   * 
   * @param str the string to check
   * @param startIndex the index at which to start checking
   * @param endIndex the index at which to stop checking
   * @return the index of the last space
   */
  public int findSpace (String str, int startIndex, int endIndex)
  {
    for (int i = endIndex - 1 ; i >= startIndex ; i--)
    {
      if (str.charAt(i) == ' ')
        return i;
    }
    return -1;
  }
  
  /**
   * This method returns the score.
   * 
   * 
   * @return the user's score
   */
  public int getScore ()
  {
    return round - 1;
  }
  
  /**
   * This method sets up the questions based on the current room, as each one has differing questions and responses.
   * If the parameter room is 1, content from the deficiencies room is taken, if it is 2, content from the panic room
   * is taken, otherwise the escape room is used.
   * 
   * 
   * @param room the current room the user is in
   */
  public void setupQuestions (int room)
  {
    int questionIndex = 0;
    if (room == 1)
    {
      currentQuestion = DeficienciesRoom.getQuestion (round - 1);
      currentAnswer = DeficienciesRoom.getAnswer (round - 1);
    }
    else if (room == 2)
    {
      if (indices.size() == 10)
        indices.clear();
      questionIndex = (int) (Math.random() * 10);
      while (indices.contains(questionIndex))
      {
        questionIndex++;
        if (questionIndex >= 10)
          questionIndex = 0;
      }
      indices.add(questionIndex);
      currentQuestion = PanicRoom.getQuestion (questionIndex);
      currentAnswer = PanicRoom.getAnswer (questionIndex);
    }
    else
    {
      if (indices.size() == EscapeRoom.getQuestionsLength())
        indices.clear();
      questionIndex = (int) (Math.random() * EscapeRoom.getQuestionsLength());
      while (indices.contains(questionIndex))
      {
        questionIndex++;
        if (questionIndex >= EscapeRoom.getQuestionsLength())
          questionIndex = 0;
      }
      currentQuestion = EscapeRoom.getQuestion (questionIndex);
      currentOptions = EscapeRoom.getOptions (questionIndex);
      currentAnswer = EscapeRoom.getAnswer (questionIndex);
    }
  }
  
  /**
   * This method moves everything to the left as the game progresses, and repeatedly draws the background to make the
   * appearance of the rocket moving through space.
   *
   * 
   * @param gameSpeed the speed at which the game is progressing
   * @param room the current room
   */
  public void moveAllLeft (int gameSpeed, int room)
  {
    //Moves all obstacles to the left
    obstaclePosition -= gameSpeed;
    if (obstaclePosition < -50)
    {
      setupQuestions (room);
      round++;
      obstaclePosition = 1300;
      randomNum = (int) (84 * Math.random () + 50);
      randomNum2 = (int) (50 * Math.random () + 50);
    }
    //Adds background and moves it to the left
    if (gameSpeed != 0)
      backgroundPosition -= 2;
    Main.gc.drawImage(background, backgroundPosition, 0);
    //Loops the background so that the same image is drawn continuously
    if (backgroundPosition < -2540)
      backgroundPosition = 0;
    else if (backgroundPosition < -1841)
      Main.gc.drawImage(background, backgroundPosition + 2540, 0);
  }
  
  /**
   * This method draws everything onto the screen, including the obstacles, labels, and their outlines.
   * 
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>topColor </b>This variable stores the colour of the top label.
   * <p>
   * <b>bottomColor </b>This variable stores the colour of the bottom label.
   * <p>
   * <b>extension </b>This variable stores an extension for the answer labels.
   * 
   * 
   * @param outlineAnswers whether or not the answers are outlined
   * @param room the current room the user is in
   */
  public void drawAll (boolean outlineAnswers, int room)
  {
    Color topColor;
    Color bottomColor;
    int extension = 0;
    int nextCharIndex = -1;
    int currentLine = 0;
    int markedChar = 0;
    
    //Draws Obstacles
    topObs = new Obstacle (obstaclePosition, -1, randomNum);
    topObs.draw(Main.gc);
    middleObs = new Obstacle (obstaclePosition, randomNum + 90, randomNum2);
    middleObs.draw(Main.gc);
    bottomObs = new Obstacle (obstaclePosition, randomNum + randomNum2 + 180, 500 - (randomNum + randomNum2 + 180));
    bottomObs.draw(Main.gc);
    
    //Draws Labels
    Main.gc.setFill (Color.AQUA);
    Main.gc.setLineWidth(2);
    if (room == 3)
      extension = 32;
    Main.gc.fillRect (obstaclePosition - extension - 20, randomNum + 20, 90 + 2 * extension, 50); //Top Label
    Main.gc.fillRect (obstaclePosition - extension - 20, randomNum + randomNum2 + 110, 90 + 2 * extension , 50); //Bottom Label
    //Chooses Label Outlines
    if (outlineAnswers && currentAnswer)
    {
      topColor = Color.GREEN;
      bottomColor = Color.RED;
    }
    else if (outlineAnswers && !currentAnswer)
    {
      topColor = Color.RED;
      bottomColor = Color.GREEN;
    }
    else
    {
      topColor = Color.BLACK;
      bottomColor = Color.BLACK;
    }
    //Draws Outlines
    Main.gc.setStroke (topColor);
    Main.gc.strokeRect (obstaclePosition - extension - 20, randomNum + 20, 90 + 2 * extension, 50);
    Main.gc.setStroke (bottomColor);
    Main.gc.strokeRect (obstaclePosition - extension - 20, randomNum + randomNum2 + 110, 90 + 2 * extension , 50);
    //Text
    Main.gc.setFill (Color.BLACK);
    if (room == 1 || room == 2)
    {
      Main.gc.setFont(labelFont1);
      Main.gc.fillText("Yes", obstaclePosition - 1, randomNum + 55);
      Main.gc.fillText("No", obstaclePosition + 6, randomNum + randomNum2 + 145);
    }
    else
    {
      //Option 1
      Main.gc.setFill (Color.BLACK);
      Main.gc.setFont(monospaceFont2);
      while (nextCharIndex <= currentOptions[0].length() - 1)
      {
        if (nextCharIndex + 25 > currentOptions[0].length())
          markedChar = currentOptions[0].length();
        else
          markedChar = nextCharIndex + 25;
        Main.gc.fillText (currentOptions[0].substring(nextCharIndex + 1, 1 + findSpace(currentOptions[0], nextCharIndex, markedChar)), obstaclePosition - 50, randomNum + 32 + currentLine * 12);
        nextCharIndex = findSpace(currentOptions[0], nextCharIndex, markedChar);
        currentLine++;
        if (markedChar == currentOptions[0].length())
          break;
      }
      //Option 2
      nextCharIndex = -1;
      currentLine = 0;
      Main.gc.setFill (Color.BLACK);
      Main.gc.setFont(monospaceFont2);
      while (nextCharIndex <= currentOptions[1].length() - 1)
      {
        if (nextCharIndex + 25 > currentOptions[1].length())
          markedChar = currentOptions[1].length();
        else
          markedChar = nextCharIndex + 25;
        Main.gc.fillText (currentOptions[1].substring(nextCharIndex + 1, 1 + findSpace(currentOptions[1], nextCharIndex, markedChar)), obstaclePosition - 50, randomNum + randomNum2 + 120 + currentLine * 12);
        nextCharIndex = findSpace(currentOptions[1], nextCharIndex, markedChar);
        currentLine++;
        if (markedChar == currentOptions[1].length())
          break;
      }
    }
    
    //Draws Question
    Main.gc.setFill (Color.AQUA);
    Main.gc.setStroke (Color.BLACK);
    Main.gc.fillRect (obstaclePosition - 500, 20, 400, 200);
    Main.gc.strokeRect (obstaclePosition - 500, 20, 400, 200);
    //Text
    nextCharIndex = -1;
    currentLine = 0;
    Main.gc.setFill (Color.BLACK);
    Main.gc.setFont(monospaceFont);
    while (nextCharIndex <= currentQuestion.length() - 1)
    {
      if (nextCharIndex + 32 > currentQuestion.length())
        markedChar = currentQuestion.length();
      else
        markedChar = nextCharIndex + 32;
      Main.gc.fillText (currentQuestion.substring(nextCharIndex + 1, 1 + findSpace(currentQuestion, nextCharIndex, markedChar)), obstaclePosition - 490, 45 + currentLine * 25);
      nextCharIndex = findSpace(currentQuestion, nextCharIndex, markedChar);
      currentLine++;
      if (markedChar == currentQuestion.length())
        break;
    }
    
    //Display Score
    if (room != 1)
    {
      Main.gc.setFont(fuelAndScore);
      Main.gc.setFill (Color.GOLD);
      Main.gc.fillText ("Rounds Passed:", 9, 440);    
      Main.gc.setFill (Color.RED);
      Main.gc.fillText (Integer.toString((room - 2) * 10 + round - 1), 155, 440);
    }
  }
  
  /**
   * This method checks for collision with an obstacle or 0 fuel remaining.
   * 
   * 
   * @return whether or not the game has been lost
   */
  public boolean lostGame ()
  {
    return topObs.collision(rocket) || middleObs.collision(rocket) || bottomObs.collision(rocket) || rocket.getFuel() <= 0;
  }
  
  /**
   * This method checks if the user has won by checking if they have progressed past the escape room.
   * 
   * 
   * @return whether or not the user has won
   */
  public boolean wonGame ()
  {
    return round == 11;
  }
  
  /**
   * This method deals with fuel. It provides fuel for the correct answer, but does not provide any otherwise. It also
   * ensures that the rocket does not go off the screen vertically, does not lose fuel at either end, and draws the fuel
   * bar.
   * 
   * 
   * @param gameSpeed the speed at which the game is moving
   */
  public void handleFuel (int gameSpeed)
  {
    //Gives fuel for going through the correct opening
    if (rocket.getXPos() >= obstaclePosition - gameSpeed && rocket.getXPos() <= obstaclePosition - 1)
    {
      if ((currentAnswer && rocket.getYPos() >= randomNum - 1 && rocket.getYPos() <= randomNum + 90) || (!currentAnswer && rocket.getYPos() >= randomNum + randomNum2 + 90 && rocket.getYPos() <= randomNum + randomNum2 + 180))
        rocket.incrementFuel ((int) (rocket.getMaxFuel() * .6));
    }
    
    //Makes sure rocket does not go off screen vertically
    if (rocket.getYPos() < 0)
    {
      rocket.setYPos(0);
      rocket.setFuelVel(-1);
    }
    else if (rocket.getYPos() > 461)
    {
      rocket.setYPos(461);
      rocket.setFuelVel(-1);
    }
    
    //Draws Fuel Bar
    Main.gc.setFont(fuelAndScore);
    Main.gc.setFill (Color.RED);
    Main.gc.fillRect (60, 460, 150, 10);
    Main.gc.setFill (Color.GOLD);
    Main.gc.fillText ("Fuel:", 10, 470);
    Main.gc.fillRect (60, 460, rocket.getFuel() * 150 / rocket.getMaxFuel(), 10);
  }
  
  /**
   * This method updates the rockets position on the screen.
   */
  public void updateRocket ()
  {
    rocket.move(); //Moves the rocket based on the velocities
    rocket.draw (Main.gc); //Draws the rocket based on the coordinates 
  }
}