import java.util.*;

class Solution {
    
    private static boolean[][] arr = new boolean[101][101];
    private static boolean[] check = new boolean[101];
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            arr[x][y] = true;
            arr[y][x] = true;
        }
        
        for (int i = 0; i < wires.length; i++) {
            
            int x = wires[i][0];
            int y = wires[i][1];
            
            arr[x][y] = false;
            arr[y][x] = false;
            
            dfs(1, n);
            
            int count = 0;
            for (int j = 0; j <= n; j++) {
                if (check[j]) {
                    count++;
                }
            }
            int difference = Math.abs((n - count) - count);
            
            answer = Math.min(difference, answer);
            
            arr[x][y] = true;
            arr[y][x] = true;
            
            for (int j = 0; j <= n; j++) {
                check[j] = false;
            }
        }
        
        return answer;
    }
    
    private void dfs(int v, int n) {
        
        if (check[v]) {
            return;
        }
        
        check[v] = true;
        
        for (int i = 1; i <= n; i++) {
            if (arr[v][i] && !check[i]) {
                dfs(i, n);
            }
        }
    }
}
