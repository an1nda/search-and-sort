import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Quick Sort
 */
public class G extends SortUtil
{
    /**
     * TODO: Implement a Quick Sort visualization
     */
    public G()
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
        quicksort(nums);  

        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;

        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    public int partition(int[] a, int lo, int hi) {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo])  // Find item on left to swap 
                if (i == hi) break; 
            while (a[--j] > a[lo]) 
                if (j == lo) break;

            if (i >= j) break;  // Check if pointers cross 
            swap(a, i, j);  // Swap
        } 
        swap(a, lo, j);  // Swap partitioning element  
        return j;  // Return index of item now know to be in place
    }

    public void quicksort(int[] a) {
        shuffle(a); 
        quicksort(a, 0, a.length - 1); 
    }

    // quicksort the subarray from a[lo] to a[hi]  
    private void quicksort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        drawArray(a, j);
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi); 
    }

}
