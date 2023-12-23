class Solution {
    public int romanToInt(String s)
    {
        int number = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (i < s.length() - 1 && s.charAt(i) == 'I')
            {
                if (s.charAt(i + 1) == 'V')
                {
                    number += (romanValue('V') - romanValue('I'));
                    i++;
                }
                else if (s.charAt(i + 1) == 'X')
                {
                    number += (romanValue('X') - romanValue('I'));
                    i++;
                }
                else
                    number += romanValue(s.charAt(i));
                
            }
            else if (i < s.length() - 1 && s.charAt(i) == 'X')
            {
                if (s.charAt(i + 1) == 'L')
                {
                    number += (romanValue('L') - romanValue('X'));
                    i++;
                }
                else if (s.charAt(i + 1) == 'C')
                {
                    number += (romanValue('C') - romanValue('X'));
                    i++;
                }
                else
                    number += romanValue(s.charAt(i));
            }
            else if (i < s.length() - 1 && s.charAt(i) == 'C')
            {
                if (s.charAt(i + 1) == 'D')
                {
                    number += (romanValue('D') - romanValue('C'));
                    i++;
                }
                else if (s.charAt(i + 1) == 'M')
                {
                    number += (romanValue('M') - romanValue('C'));
                    i++;
                }
                else
                    number += romanValue(s.charAt(i));
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
}