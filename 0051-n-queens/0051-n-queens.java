class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list= new ArrayList<>();
       boolean[][] grid= new boolean[n][n];
       boolean [][]arr = new boolean [n][n];

        solve(arr,0,0,n,list);

        return list;

    }
    void solve(boolean [][] board ,int c , int row , int n , List<List<String>>list){
        if(c==n){
            List<String> ll = new ArrayList<>();

            for(int i = 0 ; i < n;i++){
                StringBuilder sb = new StringBuilder();

                for(int j = 0 ; j < n ;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }

                ll.add(sb.toString());
            }

            list.add(ll);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(safe(board,row,i)){
                board[row][i]=true;
                solve(board,c+1,row+1,n,list);
                board[row][i]=false;
            }
        }
    }

    boolean safe(boolean[][] board , int r , int c){
        for(int i = 0 ; i < r ;i++){
            if(board[i][c]) return false;
        }

        int row = r;
        int col = c;

        while(row-1>=0 && col-1>=0){
            if(board[row-1][col-1]) return false;
            row--;
            col--;
        }

        row = r;
        col = c;

        while(row-1>=0 && col+1<board.length){
            if(board[row-1][col+1]) return false;
            row--;
            col++;
        }

        return true;
    }
}