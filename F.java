import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Merge Sort
 */
public class F extends SortUtil
{
    /**
     * TODO: Implement a merge sort visualization
     */
    public F()
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
        mergesort(nums);  

        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;

        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    public void mergesort(int[] a)
    { 
        int[] temp = new int[a.length];
        mergesort(a, temp, 0, a.length - 1);
    }

    private void mergesort(int[] a, int[] temp, int lo, int hi)
    {
        // Array is sorted if low is greater than high
        if (lo >= hi)  return;
        int mid = (lo + hi) / 2;  //index of middle element
        mergesort(a, temp, lo, mid);    //Sort left side of array
        mergesort(a, temp, mid + 1, hi);//Sort right side of array
        merge(a, temp, lo, mid, hi);    //Combine both halves
    } 

    void merge(int[] a, int[] temp, int lo, int mid, int hi)
    {
        for(int k = lo; k <= hi; k++) // copy
            temp[k] = a[k];
        int i = lo;  
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) { // merge
            drawArray(a, k);
            if (i > mid)
            {
                a[k] = temp[j++];
            }
            else if (j > hi)
            {
                a[k] = temp[i++];
            }
            else if (temp[j] < temp[i])
            {
                a[k] = temp[j++];
            }
            else   
            {
                a[k] = temp[i++];
            }
        }
    }

}
