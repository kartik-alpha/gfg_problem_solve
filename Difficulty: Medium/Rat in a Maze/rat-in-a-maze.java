class Solution {
    
    static boolean isSafeMove(int newX , int newY ,int[][] maze , boolean[][] visit ) {
        int n = maze.length;
        
         if (newX < 0 || newX >= n || newY < 0 || newY >= n) { 
            
            return false; 
        }
        else if (maze[newX][newY] == 0) {
             
             return false;
             
        }
        else if( visit[newX][newY] == true) {
            
            return false;
        }
        else 
        return true;
    }
    
    static void solve(int[][] maze , int srcX , int srcY , int distX ,int distY , boolean[][] visit , 
    ArrayList<String> ans , String path) {
        
        if(srcX == distX && srcY == distY )  {
            ans.add(path);
            return;
        }
        
        visit[srcX][srcY] = true;
        //UP
        int newX  = srcX - 1; 
        int newY  = srcY;
        if(isSafeMove(newX , newY , maze , visit)) {
            
            solve(maze , newX , newY ,distX , distY , visit , ans , path + "U");
        }
        
         newX = srcX + 1;
         newY = srcY;
        if(isSafeMove(newX , newY , maze , visit)) {
            
            solve(maze , newX , newY ,distX , distY , visit , ans , path + "D");
        }
        
          newX = srcX;
         newY = srcY - 1;
        if(isSafeMove(newX , newY , maze , visit)) {
            
            solve(maze , newX , newY ,distX , distY , visit , ans , path + "L");
        }
         newX = srcX;
        newY = srcY + 1;
         if(isSafeMove(newX , newY , maze , visit)) {
            
            solve(maze , newX , newY ,distX , distY , visit , ans , path + "R");
        }
         visit[srcX][srcY] = false; 
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int srcX = 0;
        int srcY = 0;
        
        int n = maze.length;
        
        int distX = n-1;
        int distY = n-1;
        
        boolean[][] visit = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        
        String path = "";
        
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0) {
            return ans;
        }
        
        solve(maze , srcX , srcY , distX ,distY , visit , ans , path);
        
        Collections.sort(ans);
        
        return ans;
    }
}