int cmp(const int* a, const int* b){
    return (*a - *b);
}

int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    
    *returnSize = 0;
    *returnColumnSizes = (int*)malloc(numsSize * numsSize * sizeof(int));
    int** result = (int**)malloc(numsSize * numsSize * sizeof(int*));
    if(numsSize < 3) return result;
    qsort(nums, numsSize, sizeof(int), cmp);

    for(int i=0; i<numsSize-2; i++){
        if(i>0 && nums[i-1] == nums[i]) continue;
        int left = i + 1;
        int right = numsSize - 1;
        while(left<right){
            if(nums[i] > 0) break;
            if(nums[i] + nums[left] + nums[right] < 0) left += 1;
            else if(nums[i] + nums[left] + nums[right] > 0) right -= 1;
            else{
                result[*returnSize] = (int*)malloc(3 * sizeof(int));
                (*returnColumnSizes)[*returnSize] = 3;
                result[*returnSize][0] = nums[i];
                result[*returnSize][1] = nums[left];
                result[*returnSize][2] = nums[right];
                *returnSize += 1;
                left += 1;
                while(left<numsSize && nums[left-1]==nums[left]) left += 1;
                right -= 1;
                while(right>i && nums[right+1]==nums[right]) right -= 1;
            }
        } 
    }
    return result;
}