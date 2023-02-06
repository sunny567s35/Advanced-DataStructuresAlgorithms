class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected[0].length;
        int count=0;
        boolean[] visited = new boolean[v];
        for(int i =0 ; i < v;i++){
            if(!visited[i] ){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        int v = isConnected[0].length;
        visited[i] = true;
        for(int j =0 ; j < v;j++){
            if(!visited[j] && isConnected[i][j]==1){
            dfs(isConnected,visited,j);
            }
        }
            
    }
}