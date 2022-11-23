class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // declaring an array to convert two arrays into one
        int[] mergedArray = new int[nums1.length + nums2.length];
        int x = 0;

        // adding two arrays into one using for loop
        for(int j = 0; j < nums1.length; j++) {
            mergedArray[x] = nums1[j];
            x++;
        }

        for(int k = 0; k < nums2.length; k++) {
            mergedArray[x] = nums2[k];
            x++;
        }
        
        // Sorting arrays
        Arrays.sort(mergedArray);

        // calculating output
        if(mergedArray.length % 2 == 0) {
            int complement = mergedArray.length / 2;
            return (double)(mergedArray[complement - 1] + mergedArray[complement]) / 2;
        } else {
            int complement = mergedArray.length / 2;
            return mergedArray[complement];
        }
    }
}