class Solution {
    public int romanToInt(String s)
    {
        int number = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (i < s.length() - 1 && isReverse(s.charAt(i), s.charAt(i + 1)))
            {
                number += (romanValue(s.charAt(i + 1)) - romanValue(s.charAt(i)));
                i++;
            }
            else
                number += romanValue(s.charAt(i));
        }
        
        return number;
    }
    
    public int romanValue(char c)
    {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        
        return 1000;
    }
    
    public boolean isReverse(char c1, char c2)
    {
        if (c1 == 'I')
            return (c2 == 'V' || c2 == 'X');
            
        if (c1 == 'X')
            return (c2 == 'L' || c2 == 'C');
        
        if (c1 == 'C')
            return (c2 == 'D' || c2 == 'M');
        
        return false;
    }
}