int lengthOfLongestSubstring(char * s){
    int max = 1;
    int count = 1;
    int start = 0;
    int len = strlen(s);
    
    if (s[0] == '\0')
        return 0;

    for (int i = 1; i < len; i++) {
        for (int j = start; j < i; j++) {
            if (s[i] != s[j]) {
                count++;
            } else {
                start = j + 1;
                break;
            }
        }
        if (max < count)
            max = count;
        count = 1;
    }  
    return max;
}