import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Insertion Sort
 * 
 */
public class D extends SortUtil
{
    /**
     * TODO: Implement an insertion sort visualization
     * Implement the code that will show an insertion sort.  Your code will be
     * similar to how you implemented the bubbleSort in class A
     */
    public D()
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
        insertionSort(nums);  
        
        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;
        
        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    // Implement recursive methods here
    public void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (a[j-1] > a[j])
                {
                    swap(a, j, j-1);  //swap elements
                    drawArray(a, j);
                }
                else break;
            }
        }
    } 

}
