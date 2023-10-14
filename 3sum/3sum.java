class Solution {
    public List<List<Integer>> threeSum(int[] nums)
    {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet<>();
        
        for (int i = 0; i < nums.length - 2; i++)
        {
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end)
            {   
                if (nums[i] + nums[start] + nums[end] < 0)
                    start++;
                else if (nums[i] + nums[start] + nums[end] > 0)
                    end--;
                else
                    result.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
            }
        }
        
        return new ArrayList<>(result);
    }
}