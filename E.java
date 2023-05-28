import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
/**
 * Selection Sort
 */
public class E extends SortUtil
{
    /**
     * TODO: Implement a selection sort visualization
     */
    public E()
    {
        // Instantiate the main array
        nums = new int[N];

        // Setup the array 
        setup(nums);

        // shuffle the array
        shuffle(nums);
    }
    
    public void run()
    {
        // Set the timer to 0
        timer.mark();

        // Run the sort algorithm on an array
        selectionSort(nums);  

        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;

        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    public void selectionSort(int[] arr)
    {
        for(int curIndex = 0; curIndex < arr.length - 1; curIndex++)
        {
            // Find minimum in the rest of the list
            int minIndex = findMin(arr, curIndex);
            

            // Swap the minimum into the correct position
            swap(arr, curIndex, minIndex);
            drawArray(arr, curIndex);
        }
    }

    private int findMin(int[] arr, int startingIndex)
    {
        int minIndex = startingIndex;

        for(int i = minIndex + 1; i < arr.length; i++)
        {
            if(arr[i] < arr[minIndex])
            {
                minIndex = i;
            }
        }

        return minIndex;
    }
}
