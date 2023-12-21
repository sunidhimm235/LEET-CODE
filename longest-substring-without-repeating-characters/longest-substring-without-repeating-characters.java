class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0, count = 0;
        
        for (int i = 0; i < s.length(); i++)
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