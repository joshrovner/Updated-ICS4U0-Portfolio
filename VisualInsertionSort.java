import java.awt.*;
import javax.swing.*;

public class VisualInsertionSort extends JPanel
{
    public void paintComponent (Graphics g)
    {
	//Setup Graphics
	super.paintComponent (g);
	Graphics2D g2d = (Graphics2D) g;

	int arr[] = new int [5]; //Unsorted Array Decleration
	int n = arr.length;
	boolean restart = true;

	//Generate Values for Array
	for (int i = 0 ; i < n ; i++)
	{
	    restart = true;
	    while (restart)
	    {
		restart = false;
		int x = (int) (1 + Math.random () * 5);
		for (int j = 0 ; j < i ; j++)
		{
		    if (x == arr [j])
			restart = true;
		}
		if (restart == false)
		    arr [i] = x;
	    }
	}

	//Background
	g2d.setColor (new Color (0, 255, 255));
	g2d.fillRect (0, 0, 600, 670);

	//Title
	g2d.setFont (new Font ("Arial", Font.PLAIN, 40));
	g2d.setColor (new Color (0, 0, 0));
	g2d.drawString ("Insertion Sort", 175, 40);

	//Unsorted Array Visual
	for (int k = 0 ; k < n ; k++)
	{
	    if (k == 1)
		g2d.setColor (new Color (11, 137, 40));
	    else
		g2d.setColor (new Color (255, 0, 0));
	    g2d.fillRect (k * 120 + (50 - arr [k] * 10), 100 - arr [k] * 10, arr [k] * 20, arr [k] * 20);
	}

	//Sorts Array using Insertion Sort
	for (int i = 1 ; i < n ; ++i)
	{
	    int key = arr [i];
	    int j = i - 1;

	    while (j >= 0 && arr [j] > key)
	    {
		arr [j + 1] = arr [j];
		j = j - 1;
	    }
	    arr [j + 1] = key;

	    //Current Array Visual
	    for (int k = 0 ; k < arr.length ; k++)
	    {
		if (k == i + 1)
		    g2d.setColor (new Color (11, 137, 40));
		else if (k == j + 1)
		    g2d.setColor (new Color (0, 0, 255));
		else
		    g2d.setColor (new Color (255, 0, 0));
		g2d.fillRect (k * 120 + (50 - arr [k] * 10), (100 + i * 120) - arr [k] * 10, arr [k] * 20, arr [k] * 20);
	    }
	    //Dividers
	    g2d.setColor (new Color (0, 0, 0));
	    g2d.fillRect (0, 50 + i * 120 - 15, 1000, 10);
	}
    }


    public static void main (String[] args)
    {
	VisualInsertionSort v = new VisualInsertionSort ();
	JFrame frame = new JFrame ("Rectangles");
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.getContentPane ().add (v);
	frame.setSize (600, 670);
	frame.setLocationRelativeTo (null);
	frame.setVisible (true);
	//Setting up frame
	new VisualInsertionSort ();
    }
}
