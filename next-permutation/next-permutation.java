class Solution
{
    public void nextPermutation(int[] nums)
    {
        int[][] pair = new int[2][2]; // Space: O(1)
        
        // Find the pair of increasing order from the right most side
        for (int i = nums.length-1; i > 0; i--) // Time: O(n)
        {
            System.out.println(nums[i-1] + " <= " + nums[i]);
            
            if (nums[i-1] < nums[i])
            {
                pair[0][0] = nums[i-1];
                pair[0][1] = i-1;
                pair[1][0] = nums[i];
                pair[1][1] = i;
                
                break;
            }
        }
        
        System.out.println("Pairs Index: " + pair[0][1] + " " + pair[1][1]);
        
        if (pair[0][1] == nums.length-2 && pair[1][1] == nums.length-1) // O(1)
            nums = swap(pair[0][1], pair[1][1], nums);
        else
        {
            boolean elementFound = false;
            int smallElement = Integer.MAX_VALUE;
            int smallIndex = 0;
            
            for (int i = pair[1][1]; i < nums.length; i++)
            {
                if (nums[i] > pair[0][0] && nums[i] < smallElement)
                {
                    smallElement = nums[i];
                    elementFound = true;
                    smallIndex = i;
                }
            }
            
            System.out.println("Smallest Element: " + smallElement);
            
            if (elementFound)
            {
                swap(pair[0][1], smallIndex, nums);
                
                // for (int x : nums)
                //     System.out.print(x + " ");
                
                // System.out.println();
                // System.out.println("Len: " + ((nums.length - pair[0][1]) - 1));
                
                int[] rest = new int[(nums.length - pair[0][1]) - 1];
                for (int i = pair[0][1] + 1, j = 0; i < nums.length; i++, j++)
                {
                    // System.out.println("i: " + i + " j: " + j);
                    rest[j] = nums[i];
                }
                
                Arrays.sort(rest);
                
                // for (int x : rest)
                //     System.out.print(x + " ");
                
                // System.out.println();
                    
                for (int i = pair[0][1] + 1, j = 0; i < nums.length; i++, j++)
                {
                     nums[i] = rest[j];
                }
            }
            else
            {
                swap(pair[1][1], pair[0][1], nums);
            }
        }
        
        for (int x : nums)
            System.out.print(x + " ");
    }
    
    public int[] swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return arr;
    }
}