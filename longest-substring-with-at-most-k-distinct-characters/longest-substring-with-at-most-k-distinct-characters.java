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
                System.out.println("Character isn't there");
                
                if (charKeeper.size() < k)
                {
                    System.out.println("size is less than k: " + charKeeper.size());
                    
                    charKeeper.put(s.charAt(endIdx), 1);
                    endIdx++;
                    curLen++;
                }
                else
                {
                    System.out.println("size is exactly k: " + charKeeper.size());
                    
                    if (curLen > maxLen)
                        maxLen = curLen;
                    
                    charKeeper.put(s.charAt(endIdx), 1);
                    
                    System.out.println("size is more than k: " + charKeeper.size());
                    System.out.println(charKeeper.size() <= k);
                    
                    while (charKeeper.size() > k)
                    {
                        if (charKeeper.get(s.charAt(startIdx)) > 1)
                            charKeeper.put(s.charAt(startIdx), charKeeper.get(s.charAt(startIdx)) - 1);
                        else
                            charKeeper.remove(s.charAt(startIdx));

                        startIdx++;
                        System.out.println(charKeeper);
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
            
            System.out.println(charKeeper + "\n\n");
        }
        
        return curLen > maxLen ? curLen : maxLen;
    }
}