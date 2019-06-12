public class InsertionSort
{
    public static void sort (int arr[]) //sorts the integer array passed as a parameter
    {
	int len = arr.length; //local variable "len" stores the array length
	for (int j = 1 ; j < len ; j++) //outer loop passes through all elements with index 1 until n - 1
	{
	    int key = arr [j]; //sets the "key" variable to the current index being compared in the array
	    int i = j - 1; //sets "i" to be the position before "j"
	    while ((i > -1) && (arr [i] > key)) //loops backwards through the array until the current index is greater than key or until index 0
	    {
		arr [i + 1] = arr [i]; //"shifts" the values by setting the next index to be equal to the current index
		i--; //decrements i
	    }
	    arr [i + 1] = key; //sets the index after i to be the "key"
	}
    }


    public static void main (String[] args)
    {
	int[] testArr = {6, 12, 1, 39, 17, 8, 31, 2}; //creates test array
	
	System.out.println ("Before Insertion Sort:");
	
	for (int i = 0; i < testArr.length; i++)
	{
	    System.out.print (testArr[i] + " "); //prints out unsorted elements
	}
	
	System.out.println ("\n");

	sort (testArr); //sorts test array with insertion sort

	System.out.println ("After Insertion Sort:");
	
	for (int i = 0; i < testArr.length; i++)
	{
	    System.out.print (testArr[i] + " "); //prints out sorted elements
	}
    }
}
