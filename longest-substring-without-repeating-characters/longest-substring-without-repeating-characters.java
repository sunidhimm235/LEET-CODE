class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0, start = 0, end = 0;
        int[] map = new int[256];
        
        Arrays.fill(map, -1);
        
        while (end < s.length())
        {
            if (map[s.charAt(end)] != -1)
                start = Math.max(start, map[s.charAt(end)] + 1);
            
            map[s.charAt(end)] = end;
            max = Math.max(max, end - start + 1);
            
            end++;
        }
        
        return max;
    }
}