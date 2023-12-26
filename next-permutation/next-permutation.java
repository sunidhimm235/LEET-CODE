class Solution
{
    public void nextPermutation(int[] nums)
    {
        int[][] pair = new int[2][2];
        
        // Find the pair of increasing order from the right most side
        for (int i = nums.length-1; i > 0; i--)
            if (nums[i-1] < nums[i])
                {
                    pair[0][0] = nums[i-1];
                    pair[0][1] = i-1;
                    pair[1][0] = nums[i];
                    pair[1][1] = i;

                    break;
                }
        
        // If that pair is at the end of the array, just swap
        if (pair[0][1] == nums.length-2 && pair[1][1] == nums.length-1) // O(1)
            nums = swap(pair[0][1], pair[1][1], nums);
        // Or..
        else
        {
            int smallElement = Integer.MAX_VALUE;
            int smallIndex = 0;
            
            // Find smallest element
            for (int i = pair[1][1]; i < nums.length; i++)
                if (nums[i] > pair[0][0] && nums[i] < smallElement)
                {
                    smallElement = nums[i];
                    smallIndex = i;
                }
            
            // Swap
            swap(pair[0][1], smallIndex, nums);
                
            // Get the rest of the array
            int[] rest = new int[(nums.length - pair[0][1]) - 1];
            for (int i = pair[0][1] + 1, j = 0; i < nums.length; i++, j++)
                rest[j] = nums[i];

            // Sort the rest of the array
            Arrays.sort(rest);

            // Add the rest of the array back in the original array
            for (int i = pair[0][1] + 1, j = 0; i < nums.length; i++, j++)
                nums[i] = rest[j];
        }
    }
    
    // Swap Function
    public int[] swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return arr;
    }
}