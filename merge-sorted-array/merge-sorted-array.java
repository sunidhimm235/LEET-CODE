import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0)
        {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            
            return;
        }
        
        if (n == 0)
            return;
        
        for(int i = m, j = 0; i < m + n; i++, j++)
        {
            nums1[i] = nums2[j];
        }
        
        Arrays.sort(nums1);
    }
}