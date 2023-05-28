import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Example Canvas for practicing how to draw/visualize an array
 */
public class A extends SortUtil
{
    /**
     * When this class is instantiated, set up and shuffle the main array
     */
    public A()
    {
        // Instantiate the main array
        nums = new int[N];

        // Setup the array 
        setup(nums);

        // shuffle the array
        shuffle(nums);
    }

    /**
     * TODO: Replace this code with your own code to draw your array.
     */
    public void run()
    {
        // Set the timer to 0
        timer.mark();
        
        // Run the sort algorithm on an array
        bubbleSort(nums);  
        
        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;
        
        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    /**
     * TODO: Implement any other methods that you need below.  These are
     * sometimes called 'helper' methods
     */

    

    

    /**
     * A simple sorting algorithm
     * @param arr An integer array
     */
    public void bubbleSort(int[] arr)
    {
        timer.mark();
        int N = arr.length;
        for(int i = 0; i < N; i++)
        {
            for(int j = 1; j < N; j++)
            {
                if(arr[j] < arr[j-1])
                {
                    swap(arr, j, j-1);
                    drawArray(arr, j);
                }
            }
        }
    }
}
