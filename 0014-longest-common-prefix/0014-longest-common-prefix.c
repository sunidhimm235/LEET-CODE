char * longestCommonPrefix(char ** strs, int strsSize){
    int window = 0;
    char lastChar = 0;
    char currChar = 0;
    int retLen = 0;
    
    int idx = 0;
/*
	This loop exits only if string has no chars to compare or prefix comparision fails
*/
    while(true)
    {
        currChar = 0;
        lastChar = 0;
		/*
			This Loop Traverse till the shortest String
		*/
        for(window = 0; window < strsSize && strs[window][idx] != NULL; window++)
        {
            currChar = strs[window][idx];
            if(lastChar != currChar && lastChar != 0)
            {   
                break;
            }   
            lastChar = currChar;
        }

        if(lastChar == currChar && window == strsSize)
        {
            retLen++;
        }
        else
        {
            break;
        }
        idx++;
    }
    
    strs[0][idx] = '\0';
    return strs[0];
}