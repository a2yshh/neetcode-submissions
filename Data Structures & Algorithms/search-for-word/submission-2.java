class Solution {
    private int ROWS,COLS;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited=new boolean[ROWS][COLS];
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(backtrack(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;

    }
    private boolean backtrack(char[][] board, String word, int r, int c, int i){
        if(i==word.length()){
            return true;
        }
        if(r<0||c<0||r>=ROWS||c>=COLS||board[r][c]!=word.charAt(i)||visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        boolean res = backtrack(board,word,r+1,c,i+1)||backtrack(board,word,r-1,c,i+1)||backtrack(board,word,r,c+1,i+1)||backtrack(board,word,r,c-1,i+1);
        visited[r][c]=false;
        return res;
    }
}
