import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Binary Search
 */
public class C extends SortUtil
{
    int r;
    /**
     * TODO: Implement the code to show a binary search
     * 1. Create a method that creates an array with random numbers to allow for the
     * potential for duplicates and missing values.
     * 2. Sort
     * 3. Create a target value that is a random integer from 1 to the size of the array
     * 4. Search the array, returning the time it took to find the target OR
     * return 'target not found'
     */
    public C()
    {
        // Instantiate the main array
        nums = new int[N];

        // Setup the array 
        setupBinary(nums);

        // random key
        r = nums[Greenfoot.getRandomNumber(nums.length)];
    }
    public void run()
    {
        bubbleSort(nums);
        timer.mark();
        
        binarySearch(nums, r);        
        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;
        
        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    public int binarySearch(int[] array, int key)
    {
        int low = 0;
        int high = array.length - 1;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            int cur = array[mid];
            drawArray(array, cur);
            if(cur == key)
            {
                return mid;
            }
            else if(cur < key)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return -1;
    }
    
    public void bubbleSort(int[] arr)
    {
        int N = arr.length;
        for(int i = 0; i < N; i++)
        {
            for(int j = 1; j < N; j++)
            {
                if(arr[j] < arr[j-1])
                {
                    swap(arr, j, j-1);
                }
            }
        }
    }
}
