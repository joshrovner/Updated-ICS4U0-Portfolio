/**
 * This class simulates a maze, trying to find a path of 0's from a start point to finish point.
 * 
 * @author Joshua Rovner
 * @version 1 04.15.2019
 */

public class RecursionQ4
{
  /**
   * This method calls the findNextPoint () method and ultimately returns whether or not a full path is found.
   * 
   * @param maze the maze being worked with
   * @return whether or not an exit is found
   */
  public static boolean isExitFound (int[][] maze)
  {
    for (int i = 0; i < maze.length; i++)
    {
      if (findNextPoint (maze, i, 0) || findNextPoint (maze, 0, i))
        return true;
    }
    return false;
  }
  
  /**
   * This method checks the surrounding indices for a 0. If one is found, the method returns true and moves on to that index,
   * or returns false otherwise, which means that no full paths can be found.
   * 
   * @param maze the maze being worked with
   * @param rowNum the current row number the simulation is on
   * @param columnNum the current column number the simulation is on
   * @return whether or not the next point is found
   */
  public static boolean findNextPoint (int[][] maze, int rowNum, int columnNum)
  {
    if (rowNum < 0 || rowNum > maze.length || columnNum < 0 || columnNum > maze.length || (maze[rowNum][columnNum] == 1 || maze[rowNum][columnNum] == -1))
      return false;
    else
      maze[rowNum][columnNum] = -1;
    if ((rowNum == maze.length - 2 && maze [rowNum + 1][columnNum] == 0) || (columnNum == maze.length - 2 && maze[rowNum][columnNum + 1] == 0))
      return true;
    return findNextPoint (maze, rowNum - 1, columnNum) || findNextPoint (maze, rowNum + 1, columnNum) || findNextPoint (maze, rowNum, columnNum - 1) || findNextPoint (maze, rowNum, columnNum + 1);
  }
  
  /**
   * This is the main method of the class. It creates a 5x5 integer array as the maze, and prints out the result of the
   * isExitFound () method.
   */
  public static void main (String[] args)
  {       
    int[][] maze = { 
      {0, 0, 1, 1, 1},
      {0, 0, 0, 0, 1},
      {1, 1, 0, 0, 1},
      {1, 0, 0, 1, 1},
      {1, 0, 1, 1, 1}};
    System.out.println (RecursionQ4.isExitFound (maze));
  }
}

