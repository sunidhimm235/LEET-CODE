int strStr(char * haystack, char * needle){
    if(needle == NULL) {
        return 0;
    }
    
    int nI = 0;
    
    for(int hI = 0; hI < strlen(haystack); hI++) {
        
        if(haystack[hI] == needle[nI]) {
            nI++;
        } else if(nI > 0 && haystack[hI] != needle[nI]) {
            hI = (hI - nI);
            nI = 0;
        }
        
        if(nI == strlen(needle) && nI > 0) {
            return hI-(nI-1);
        }
            
    }
    
    return -1;
}