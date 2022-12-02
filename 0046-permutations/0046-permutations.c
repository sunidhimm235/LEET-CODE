int recursivePerm(int *nums, bool *visited, int *buf, int numsSize, int x, int y, int **ans)
{
    if (y == numsSize) {
        memcpy((void *)ans[x], (void *)buf, sizeof(int) * numsSize);
        return x + 1;
    }

    for (int i = 0; i < numsSize; i++) {
    
        if (visited[i] == false) {
            visited[i] = true;
            
            /* Pick unselected number */
            buf[y] = nums[i];
            
            /* Continue to pick next number */
            x = recursivePerm(nums, visited, buf, numsSize, x, y + 1, ans);
            
            visited[i] = false;
        }
    }
    
    return x;
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    /*
     * Input:
     *  nums, integer array containing distinct integers
     *  numsSize, number of elements in array
     */
     
    /*
     * Algorithm:
     *  nums = [1]              nums = [1,2]            nums = [1,2,3]
     *      ans = [                 ans = [                 ans = [
     *              [1]                     [1,2],                  [1,2,3],
     *            ]                         [2,1]                   [1,3,2],
     *  nums = [1,2]                                                [2,3,1],
     *      ans = [                                                 [2,1,3],
     *              [1,2],                                          [3,2,1],
     *              [2,1]                                           [3,1,2]
     *            ]                                               ]
     * 
     *  nums = [1,2,3]
     *
     *      select 1
     *          select 2
     *              select 3    => [1,2,3]
     *          select 3
     *              select 2    => [1,3,2]
     *      select 2
     *          select 1
     *              select 3    => [2,1,3]
     *          select 3
     *              select 1    => [2,3,1]
     *      select 3
     *          select 1
     *              select 2    => [3,1,2]
     *          select 2
     *              select 1    => [3,2,1]
     *
     *  Backtracking:
     *      (1) Pick an unselected integer
     *      (2) store this selected integer in buf  =>  [1,?,?]
     *      (3) continue to select next integer, put the new select number in buf   => [1,2,?]
     *          repeat (1) ~ (3) or exit from recursive after finding all the combinations.
     */
     
    int **ans;
    int buf[6];
    bool visited[6] = {false};

    *returnSize = 1;
     
    /* Calculate n! */
    for (int i = 2; i <= numsSize; i++) {
        (*returnSize) *= i;
    }
    
    ans = (int **)malloc(sizeof(int *) * (*returnSize));
    *returnColumnSizes = (int *)malloc(sizeof(int) * (*returnSize));
    
    for (int i = 0; i < (*returnSize); i++) {
        ans[i] = (int *)malloc(sizeof(int) * numsSize);
        (*returnColumnSizes)[i] = numsSize;
    }
    
    recursivePerm(nums, visited, buf, numsSize, 0, 0, ans);
     
    /*
     * Output:
     *  *returnSize, row number of returned array
     *  **returnColumnSizes, column number of returned array
     *  return all the possible permutations
     */
     
    return ans;
}