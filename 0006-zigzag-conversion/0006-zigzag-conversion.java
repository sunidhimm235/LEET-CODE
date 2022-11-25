class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        String[][] matrix = new String[numRows][(s.length()/2) + 1];
        boolean goDown = true;
        
        for(int str_index = 0, x = 1; str_index < s.length();) {
            if(goDown) {
                for(int i = 0, j = x-1; i < numRows && str_index < s.length(); i++) {
                    matrix[i][j] = String.valueOf(s.charAt(str_index));
                    str_index++;
                }
                
                goDown = false;
            } else if(!goDown) {
                for(int i = numRows - 2, j = x; i != 0 && str_index < s.length(); i--, j++) {
                    matrix[i][j] = String.valueOf(s.charAt(str_index));
                    str_index++;
                }
                x+=(numRows - 1);
                goDown = true;
            }
        }
        
        String result = "";
        
        for(int i = 0, res_index = 0; res_index < s.length() && i < numRows; i++) {
            for(int j = 0; j < (s.length()/2) + 1 && res_index < s.length(); j++) {
                if(matrix[i][j] != null) {
                    result += matrix[i][j].charAt(0);
                    res_index++;
                }
            }
        }
        
        return result;
        
    }
}