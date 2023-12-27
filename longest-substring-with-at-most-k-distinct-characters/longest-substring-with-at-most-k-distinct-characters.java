class Solution
{
    public int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        if (k == 0)
            return 0;
        
        HashMap<Character, Integer> charKeeper = new HashMap<>();
        int maxLen = 0, curLen = 0;
        
        for (int startIdx = 0, endIdx = 0; endIdx < s.length();)
        {
            if (!charKeeper.containsKey(s.charAt(endIdx)))
            {   
                if (charKeeper.size() < k)
                {
                    charKeeper.put(s.charAt(endIdx), 1);
                    endIdx++;
                    curLen++;
                }
                else
                {
                    if (curLen > maxLen)
                        maxLen = curLen;
                    
                    charKeeper.put(s.charAt(endIdx), 1);
                    
                    while (charKeeper.size() > k)
                    {
                        if (charKeeper.get(s.charAt(startIdx)) > 1)
                            charKeeper.put(s.charAt(startIdx), charKeeper.get(s.charAt(startIdx)) - 1);
                        else
                            charKeeper.remove(s.charAt(startIdx));

                        startIdx++;
                    }
                    
                    curLen = (endIdx - startIdx) + 1;
                    endIdx++;
                }
            }
            else
            {
                charKeeper.put(s.charAt(endIdx), charKeeper.get(s.charAt(endIdx)) + 1);
                endIdx++;
                curLen++;
            }
        }
        
        return curLen > maxLen ? curLen : maxLen;
    }
}