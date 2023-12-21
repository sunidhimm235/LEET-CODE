class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0, count = 0, n = s.length();
        
        for (int i = 0; i < n; i++)
        {
            if (!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), i);
                count++;            
            }
            else
            {
                if (count > maxCount)
                    maxCount = count;
                
                i = map.get(s.charAt(i));
                map = new HashMap<>();
                count = 0;
            }
        }
        
        return count > maxCount ? count : maxCount;
    }
}