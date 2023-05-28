import greenfoot.*;

/**
 * Linear Search
 * 
 */
public class B extends SortUtil
{    
    /**
     * TODO: Refactor the array and any relevant helper methods
     */
    int x;
    /**
     * TODO: Set up this canvas by
     * 1. Instantiating the main array
     * 2. Choosing a target number to search for
     * 3. Shuffling the array
     */
    public B()
    {
        nums = new int[N];
        setup(nums);
        
        x = Greenfoot.getRandomNumber(nums.length);
        
        shuffle(nums);
        x = nums[x];
    }

    /**    
     * TODO: Refactor any relevant code from class A into Canvas superclass
     * so that you can use it in this class
     * 
     * TODO: Implement the code to show a linear search.
     */
    public void run()
    {
        timer.mark();
        
        linSearch(nums, x);
        
        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;
        
        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }


    /**
     * TODO: complete the code for this linear search algorithm
     * to draw the array, highlighting the rectangle at position i
     */
    private boolean linSearch(int[] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            // TODO: draw the array highlighting the rectangle at position i
            drawArray(nums, i);
            if(nums[i] == target)
            {
                return true;
            }
        }
        return false;
    }

 
}