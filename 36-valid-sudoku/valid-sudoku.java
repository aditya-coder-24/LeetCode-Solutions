import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                char value = board[i][j];
                
                if(value == '.'){
                    continue;
                }
                
                String row = "row" + i + value;
                String col = "col" + j + value;
                String box = "box" + (i/3) + (j/3) + value;
                
                if(set.contains(row) || 
                   set.contains(col) || 
                   set.contains(box)){
                    return false;
                }
                
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        
        return true;
    }
}