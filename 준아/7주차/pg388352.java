import java.util.*;

class Solution {
    
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        
        for (int i = 1; i <= n; i++) {
            set.add(i);
            dfs(i, n, q, ans);
            set.remove(i);
        }
        
        return answer;
    }
    
    private void dfs(int v, int n, int[][] q, int[] ans) {
        
        if (set.size() == 5) {
            if (isPossible(q, ans)) {
                answer++;
            }
            return;
        }
        
        for (int i = v + 1; i <= n; i++) {
            set.add(i);
            dfs(i, n, q, ans);
            set.remove(i);
        }
    }
    
    private boolean isPossible(int[][] q, int[] ans) {
        
        
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++) {
                if (set.contains(q[i][j])) {
                    cnt++;
                }
            }
            
            if (cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}
