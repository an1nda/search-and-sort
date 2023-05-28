import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where the tools to shuffle, swap, setup, 
 * and draw the current state of the array 
 * are stored.
 * 
 * @author Aninda
 * @version v2
 */
public class SortUtil extends Canvas
{
    // The size of your array
    protected int N = 125;

    // The main array to visualize
    protected int[] nums;

    // A timer for keeping track of how long your algorithm takes
    protected SimpleTimer timer = new SimpleTimer();
    
    /**
     * Act - do whatever the SortUtil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * Set up the array so that every element has a value that is an integer
     * from 1 to the length of the array (1 - N).
     * @param arr An array of integers
     */
    void setup(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            arr[i] = i;
        }
    }
    
    void setupBinary(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            arr[i] = Greenfoot.getRandomNumber(arr.length);
        }
    }

    /**
     * TODO: Implement this method
     * Swap elements at index positions i and j in the given array.  
     * @param arr An integer array
     * @param a The index of one of the elements to swap
     * @param b The index of the other element to swap with
     */
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Shuffle an array using the Fisher-Yates method.
     * The Fisher-Yates method iterates the array once, swapping each
     * element with a random element chosen in the range between
     * the current position to the length of the array.
     * @param arr An array of integers
     */
    void shuffle(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int num = Greenfoot.getRandomNumber(arr.length-i) + i;
            swap(arr, arr[i], arr[num]);
        }
    }
    
    /**
     * Draw the given array
     * @param arr An array of integers
     */
    public void drawArray(int[] arr)
    {
        double bin = 1.0/N;
        for(int i = 0; i < N; i++)
        {
            double height = (double)arr[i]/N;
            double x = i * bin;
            double y = 0;
            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);
        }
        // Show the canvas
        update();
    }

    /**
     * Draw the given array, highlighting the element at position k
     * @param arr An integer array
     * @param k The position in the array to draw in a different color. k < arr.length
     */
    public void drawArray(int[] arr, int k)
    {
        // Exit this method if k is larger than the length of the array
        if(k > arr.length)
        {
            return;
        }

        double bin = 1.0/N;
        for(int i = 0; i < N; i++)
        {
            double height = (double)arr[i]/N;
            double x = i * bin;
            double y = 0;

            // Change the color for the one index
            if(i == k)
            {
                setColor(Color.RED);
            }

            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);

            if(i == k)
            {
                setColor(Color.BLACK);
            }
        }
        // Show the canvas
        update();
    }
}
