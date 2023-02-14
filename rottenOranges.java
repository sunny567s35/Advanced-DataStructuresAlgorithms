class P{
        int x =0;
        int y =0;
        P(int x,int y ){
            this.x=x;
            this.y=y;

        }
    }
class Solution {
    
    public boolean valid(int[][] grid, int x , int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return false;
        }
        return true;
    }
    public boolean isdelim(P temp){
        return temp.x==-1 && temp.y ==-1;
    }
    public boolean checkall(int[][] grid){
        for (int i =0 ; i < grid.length;i++){
            for(int j =0 ; j < grid[0].length;j++){
                    if(grid[i][j]==1){
                        return true;
                    }
            }
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        Queue<P> q = new LinkedList<>();
        int ans = 0 ;
        int R = grid.length;
        int C = grid[0].length;
        for (int i =0 ; i < R;i++){
            for(int j =0 ; j < C;j++){
                    if(grid[i][j]==2){
                        q.add(new P(i,j));
                    }
            }
        }
        q.add(new P(-1,-1));
        
        while(!q.isEmpty()){
            boolean flag = false;
            while(!isdelim(q.peek())){
                P temp = q.peek();
                int x = temp.x;
                int y = temp.y;
                if(valid(grid,x+1,y) && grid[x+1][y]==1){
                        if(!flag){ans++;flag = true;}
                        grid[x+1][y]=2;
                        
                        q.add(new P(x+1,y));

                }
                if(valid(grid,x-1,y) && grid[x-1][y]==1){
                        if(!flag){ans++;flag = true;}
                        grid[x-1][y]=2;
                        
                        q.add(new P(x-1,y));

                }
                if(valid(grid,x,y-1) && grid[x][y-1]==1){
                        if(!flag){ans++;flag = true;}
                        grid[x][y-1]=2;
                        
                        q.add(new P(x,y-1));

                }
                if(valid(grid,x,y+1) && grid[x][y+1]==1){
                        if(!flag){ans++;flag = true;}
                        grid[x][y+1]=2;
                        
                        q.add(new P(x,y+1));

                }
                q.remove();
                

            }
            q.remove();
            if(!q.isEmpty()){
                q.add(new P(-1,-1));
            }

        }
        return checkall(grid) ? -1 : ans;
    }
}