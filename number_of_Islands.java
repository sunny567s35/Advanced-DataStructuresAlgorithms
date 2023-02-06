class Solution {
    public boolean isSafe(char[][] grid ,int row, int col ,boolean[][] visited){
        int r=grid.length;
        int c=grid[0].length;
        return (row>=0) && (row<r) && (col <c )&& (col>=0) && ((grid[row][col]=='1') && !visited[row][col]);
        }
    public void dfs(char[][] grid,int row ,int col,boolean[][] visited){
        int[] nrow = new int[] {-1,0,0,1};
        int[] ncol = new int[] {0,-1,1,0}; 
        visited[row][col] = true;
        grid[row][col] = '0';
        
        for(int i=0 ;i < 4 ;++i){
            
            if(isSafe(grid , row+nrow[i],col+ncol[i], visited)){
                dfs(grid , row+nrow[i],col+ncol[i], visited);
            }

        }
    }
    public int numIslands(char[][] grid) {
    
    int COL = grid[0].length;
    int ROW = grid.length;
    int count=0;
    boolean[][] visited = new boolean[ROW][COL];
    for(int k =0 ; k < ROW;k++){
        for(int l =0 ;l<COL;l++ ){
            if(!visited[k][l] && (grid[k][l]=='1')){
                System.out.println(visited[k][l]);
                dfs(grid,k,l,visited);
                System.out.println(visited[k][l]);
                count++;
            }
        }
    }
    return count;
    }
}