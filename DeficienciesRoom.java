import javafx.stage.*;

/**
 * This class creates the deficiencies room, dealing with game movement in the first room.
 * 
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>gameSpeed </b>This variable stores the speed at which the game is moving.
 * <p>
 * <b>questions </b>This array stoores the set of all questions and answers.
 * <p>
 * <b>answers </b>This array stores several boolean values, which represent whether the first answer is correct or not.
 * 
 * 
 * @author Joshua Rovner and Eric Myzelev
 * @version 4 03.06.2019
 */
public class DeficienciesRoom extends GameGraphics
{ 
  private int gameSpeed;
  
  private static String [] questions = 
  {"Your friend steals your lunchbox. You punch them to get it back. Go through no, because punching is bad. ",
    "Your teacher gives a lower mark than you expected. You ask how you can improve for next time. Go through yes, because positive improvement is good. ",
    "You get benched during a sports game. You try to improve for next time. Go through yes, because positive improvement is good. ",
    "Your sibling spills their hot soup on you. You take your cup of water and spill it on them. Go through no because retaliating is bad. ",
    "Your mother asks you to do the dishes right when you start to play a game. You ignore her. Go through no because you shouldn't ignore anyone. ",
    "Your sibling forgets to do something for you several days in a row. You yell at them for forgetting. Go through no because you shouldn't yell. ",
    "You are given a lot of homework. You do it diligently, understanding that this won't usually happen. Go through yes, because you will occasionally have to do lots of work. ",
    "Your classmate calls you annoying. You ask them why and tell them not to do it again. Go through yes, because you should settle disputes with words. ",
    "Your gaming device is taken by your parents. You yell at your parents and throw a tantrum. Go though no, because you should never yell at your parents. ",
    "Due to traffic, you are late to school and are sent to the office. You go and explain the situation to the principal. Go through yes, because calm explanations are always good. ",
    ""};
  private static boolean [] answers = {false, true, true, false, false, false, true, true, false, true, false};
  
  /**
   * This is the class constructor, taking the stage as a parameter and creating the room, and setting the game speed to 0.
   * 
   * 
   * @param stage the window on which the game is being played
   */
  public DeficienciesRoom (Stage stage)
  {
    super (stage, 1250, 1);
    gameSpeed = 0;
  }
  
  /**
   * This method returns the question with the parameter's index from the questions array.
   * 
   * 
   * @param index the index of the questions array for the desired question
   * @return the question at the specified index
   */
  public static String getQuestion (int index)
  {
    return questions [index];
  }
  
  /**
   * This method returns whether or not the first answer is correct with the parameter's index from the answers array.
   * 
   * 
   * @param index the index of the answers array for the desired answer
   * @return whether or not the answer is true at the specified index
   */
  public static boolean getAnswer (int index)
  {
    return answers [index];
  }
  
  /**
   * This method sets the game speed to 5 whenever movement is occuring, otherwise it sets it to 0.
   * 
   * 
   * @param move whether or not movement is happening
   */
  public void gameMovement (boolean move)
  {
    if (move)
      gameSpeed = 5;
    else 
      gameSpeed = 0;
  }
  
  /**
   * This method is more graphic-oriented, as it sets the questions, moves everything left at the game speed, draws
   * everything, and coordinates responses to the room being passed or not. In addition, it updates the rocket on the
   * screen.
   * 
   * 
   * @param currentTime the current value of the JVM's time source
   */
  public void handle (long currentTime)
  {   
    setupQuestions (1);
    moveAllLeft (gameSpeed, 1);
    drawAll (true, 1);
    if (lostGame ())
    {
      super.stop();
      GameInput.layout.getChildren().clear ();
      GameOver g = new GameOver(0, 1);
      g.gameOver(getStage());
      g.updateHighScores (1);
    }
    if (wonGame ())
    {
      super.stop();
      GameInput.layout.getChildren().clear ();
      LevelComplete lc = new LevelComplete ();
      lc.draw(getStage(), 0, 1);
      super.stop();
    }
    handleFuel(gameSpeed);
    updateRocket();
  }
}