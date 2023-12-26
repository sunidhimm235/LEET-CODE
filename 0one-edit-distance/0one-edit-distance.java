class Solution {
    public boolean isOneEditDistance(String s, String t)
    {   
        int m = s.length(); // Determines s length
        int n = t.length(); // Determines t length
        
        // Makes the difference between two lengths is one
        if (Math.abs(m - n) > 1)
             // If not, then we have make more than one change
            return false;
        
        // i pointer for s string and j pointer for t string
        int i = 0, j = 0;
        // Determines number of changes
        int changes = 0;
        
        // Loops through the two string to determine how many changes it requires
        while (i < m && j < n)
        {
            // If the characters are not same, then we need a change
            if (s.charAt(i) != t.charAt(j))
            {
                changes++; // Increment change
                
                // If m > n, then increment i pointer
                if (m > n)
                    i++;
                // If m > n, then increment j pointer
                else if (m < n)
                    j++;
                // Else increment both pointers
                else
                {
                    i++;
                    j++;
                }
            }
            // If the both of the characters are same, increment both pointers
            else
            {
                i++;
                j++;   
            }
            
            System.out.println(changes);
        }
        
        if (i < m || j < n)
        {
            changes++;
        }
        
        // Returns true if the change is only one
        return changes == 1;
    }
}