class Solution {
    public boolean isAnagram(String s, String t)
    {    
        if (s.length() != t.length())
            return false;
        
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++)
        {
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        
        for (int i = 0; i < map.length; i++)
        {
            if (map[i] != 0)
                return false;
        }
        
        return true;
    }
}