int reversedNum(int x, long rX) {

    rX = rX * 10 + x % 10;

    if(x < 10) {
        return rX;
    } else {
        return reversedNum(x/10, rX);
    }
    
}

bool isPalindrome(int x){
    if(x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }

    long rX = reversedNum(x, 0);
    
    if(x == rX) {
        return true;
    }

    return false;
}