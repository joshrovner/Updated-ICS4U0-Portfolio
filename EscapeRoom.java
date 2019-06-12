import javafx.stage.*;

/**
 * This class creates the escape room, dealing with game movement in the final room.
 * 
 * 
 * <p>
 * <b>Global Variables: </b>
 * <p>
 * <b>gameSpeed </b>This variable stores the speed at which the game is moving.
 * <p>
 * <b>questions </b>This array stores the set of all questions and answers.
 * <p>
 * <b>options </b>This variable stores the possible response options to each question.
 * <p>
 * <b>answers </b>This array stores several boolean values, which represent whether the first answer is correct or not.
 * 
 * 
 * @author Joshua Rovner and Eric Myzelev
 * @version 4 03.06.2019
 */
public class EscapeRoom extends GameGraphics
{ 
  private int gameSpeed;
  
  private static String [] questions = 
  {"You planned to watch a movie with a friend. At the last minute, they cancel. ",
    "Your classmate tells you that you have a very long nose. ",
    "A parent punishes you for not doing the dishes. ",
    "A sibling steals your tablet. ",
    "Your friends go to a concert without asking you if you want to come. ",
    "At school, you are sent to the office for causing a disruption. ",
    "You are forced to take a class at school which you do not like. ",
    "Your family cancels a vacation that you were excited for. ",
    "You feel left out because your parents need to deal with a big issue with a sibling. ",
    "A camp counselor makes a joke about you, but did not intend to be mean. ",
    "Your friends all do better on an assignment than you. ",
    "A classmate calls you a bad name. ",
    "The school bully steals your lunch money in front of all your friends. ",
    "You have plans with friends, but then your parents ask you to babysit your younger sibling. ",
    "You are spending time at a friends house, but have to leave due to your parents curfew. ",
    "You had to miss some school assignments due to a sports game, and need to make up for them today after school. But, you have another game at the same time. ",
    "Your friends make fun of you because you are bad at a sport. ",
    "You just sat down to do your homework when your mom asks you to do the dishes. ",
    "You try to watch a movie, but when you get to the theater, the tickets are sold out. ",
    "Your teacher gives you a lot of homework. ",
    "Your teacher accuses you of cheating on a test because you are not smart enough to get such a good grade. ",
    "Your gaming device is taken away by your parents as punishment. ",
    "You do not wake up to your alarm and get to school half an hour late, and your teacher sends you to the office. ",
    "You ask your sibling to do you a favour, but they forget several days in a row. ",
    "A teacher gives you some confusing homework due tomorrow. ",
    "A classmate keeps annoying you, and you ask them to stop. Your teacher tells you to be quiet, as the announcements are on. ",
    "Your friend does not invite you to their birthday party. ",
    "You are playing a video game after finishing your homework, when your parent walks in and switches it off, telling you to finish your homework. You lose all of your progress. ",
    "Your parents have been fighting a lot, and your brother tells you that it is because of you. ",
    "Your classmate calls your parents annoying after meeting them. ",
    ""};
  private static String [][] options = 
  {{"Yell at them. ", "Ask them to give you advance notice next time. "}, 
    {"Ask them to stop. ", "Make fun of them. "}, 
    {"Smash things in your room. ", "Ask them if you can do something to make up for it. "},
    {"Ask them to give it back or else you will tell your parents. ", "Go through their room when they are not there. "},
    {"Throw a tantrum. ", "Explain that you wanted to come with them. "},
    {"Yell at your teacher. ", "Consider your actions and apologize to the teacher. "},
    {"Complain about it for the whole time. ", "Try participating and see what happens. "},
    {"Have an argument with your parents. ", "Ask them to schedule one in the near future. "},
    {"Act mean to them. ", "Ask if they can spend a few minutes talking with you. "},
    {"Hit them during cabin time. ", "Talk to them about not doing so again."},
    {"Ignore them for the rest of the day. ", "Ask them to show you their work so you can learn for next time. "},
    {"Tell the teacher. ", "Fight them after school. "},
    {"Tell your parents. ", "Steal your friends money. "},
    {"Ignore them and leave anyways. ", "Ask your friends to move the plans to another day. "},
    {"Stay later in spite of your parents. ", "Come back despite the fun you are missing. "},
    {"Ignore your teacher. ", "Ask your parents to speak with the team coach. "},
    {"Try to make them do something they�re bad at as revenge. ", "Accept that the sport is not your strength and ask them to stop making fun of you. "},
    {"Ignore her. ", "Ask her if you could do it later. "},
    {"Yell at the cashier. ", "Try to watch it at a later time. "},
    {"Complain about it for the whole night. ", "Focus and finish it efficiently. "},
    {"Ask your parents to speak with your teacher. ", "Argue with the teacher. "},
    {"Accept your bad behaviour. ", "Start a confrontation with your parents. "},
    {"Explain why you were late to the principal. ", "Get mad at your teacher. "},
    {"Start a fight with them. ", "Ask your parents to speak with your sibling. "},
    {"Refuse to do it. ", "Ask for help. "},
    {"Wait until the end of announcements to explain the situation to your teacher. ", "Immediately start arguing with your teacher. "},
    {"Ask why and nicely try to get invited. ", "Walk away from them and stop being their friend. "},
    {"Explain to them you already finished and ask them not to do it again. ", "Yell at them and throw a tantrum. "},
    {"Start an argument with him and stress out your parents. ", "Wait until your parents finish their argument to tell them what he said. "},
    {"Speak with your parents about it. ", "Fight with them. "},
    {"", ""}};
  
  private static boolean [] answers = {false, true, false, true, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, true, true, true, false, false, true, true, true, false, true, false};
  
  /**
   * This is the class constructor, taking the stage as a parameter and creating the room, and setting the game speed to 0.
   * 
   * 
   * @param stage the window on which the game is being played
   */
  public EscapeRoom (Stage stage)
  {
    super (stage, 1000, 3);
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
   * This method returns the options with the parameter's index from the options array.
   * 
   * 
   * @param index the index of the options array for the desired options
   * @return the options at the specified index
   */
  public static String [] getOptions (int index)
  {
    return options [index];
  }
  
  /**
   * This method returns whether or not the first answer to the question is correct with the parameter's index from the 
   * answers array.
   * 
   * 
   * @param index the index of the answers array for the desired answer
   * @return whether or not the answer is true at the specified index
   */
  public static boolean getAnswer (int index)
  {
    return answers [index];
  }
  
  public static int getQuestionsLength ()
  {
    return questions.length;
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
      gameSpeed = getScore() + 4;
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
    moveAllLeft (gameSpeed, 3);
    drawAll (false, 3);
    if (lostGame ())
    {
      super.stop();
      GameInput.layout.getChildren().clear ();
      GameOver g = new GameOver(10 + getScore(), 3);
      g.gameOver(getStage());
      g.updateHighScores (3);
    }
    handleFuel(gameSpeed);
    updateRocket();
  }
}