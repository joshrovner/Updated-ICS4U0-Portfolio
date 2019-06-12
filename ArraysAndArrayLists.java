//THIS MUST BE IMPORTED IN ORDER TO USE ARRAYLISTS!
import java.util.*;

public class ArraysAndArrayLists
{
    public static void main (String[] args)
    {
        //using shorthand to declare an array of Strings with predefined contents
        String[] stringArray = {"My", "name", "is", "Josh"}; 
        
        /*declaring an array of 4 integers - values are set to 0 for each index when dealing with 
        numerical arrays, and null when dealing with Strings and objects*/
        int[] intArray = new int[4]; 
        
        //printing out the values of the integer array
        System.out.print ("Default Integer Array: ");
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
            
        System.out.println ();
        
        /*each position in the integer array will now be given a value from 0 to 3 representing 
        its index - notice the use of ".length" as a placeholder for the length of the array*/
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i;
        
        //printing out the values of the integer array
        System.out.print ("Integer Array With Values: ");
        for (int i = 0; i < intArray.length; i++)
            System.out.print (intArray[i] + " ");
        
        System.out.println ();    
        
        //printing out the values of the string array
        System.out.println ("Values in String Array: ");
        for (int i = 0; i < stringArray.length; i++)
            System.out.println ("Position " + i + " = " + stringArray[i] + " ");
        
        //accessing and then printing index 2 of string array
        String temp = stringArray [2];
        System.out.println ("Value at Index 2 of String Array: " + temp);
        
        //trying to remove final element of string array using remove () method: UNCOMMENT LINE BELOW TO SEE WHAT HAPPENS (see bottom of code for explanantion)
        //stringArray.remove (3);
        
        System.out.println ();
        
        //declaring a string arraylist with predefined contents
        ArrayList<String> stringArrayList = new ArrayList<String>(Arrays.asList ("Hello", "there"));
        
        //declaring an Integer arraylist - cannot use primitive data types with arraylists
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        
        //printing out the values of the Integer arraylist using a for-each loop - nothing is output as there is nothing in the list
        System.out.print ("Default Integer ArrayList: ");
        for (Integer i : intArrayList)
            System.out.print(i + " ");
        
        System.out.println ();
        
        //printing out the values of the String arraylist using a for-each loop
        System.out.println ("String ArrayList: ");
        for (String s : stringArrayList)
            s += "z";
        
        //adding 4 elements, 0 to 3, each to the back of the Integer arraylist
        for (int i = 0; i < 4; i++)
          intArrayList.add (i);
        
        //printing out the elements of the Integer arraylist
        System.out.print ("Edited Integer ArrayList: ");
        for (Integer i : intArrayList)
            System.out.print (i + " ");
        
        System.out.println ();
        
        //accessing and then printing index 2 of Integer arraylist
        Integer i = intArrayList.get (2);
        System.out.println ("Index 2 of Integer ArrayList: " + i);
        
        //trying to remove first element from Integer arraylist: UNCOMMENT LINE BELOW TO SEE WHAT HAPPENS (see bottom of code for explanantion)
        //intArrayList [0] = 0;
        
        //removing first element from String arraylist
        stringArrayList.remove (0);
        System.out.print ("Edited String ArrayList: ");
        for (String s : stringArrayList)
            System.out.print (s + " ");
        
        System.out.println ();
        
        /*EXPLANATION 1: the remove method on the string array did not work because the Array class has no remove method - only arraylists have this functionality.
        Thus, to remove a value in an array, it must be set to 0, or a copy of the array must be made without that element.*/
        
        /*EXPLANATION 2: conversely, an index in an arraylist cannot be accessed with square brackets - instead, the get () method must be used.*/
   }
}
       
