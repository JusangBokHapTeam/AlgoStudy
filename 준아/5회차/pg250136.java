import java.util.*;

class Solution {
    
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    
    class Point {
        
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        
        int answer = 0;
        int xLen = land[0].length;
        int yLen = land.length;
        
        boolean[] check = new boolean[xLen * yLen];
        int[] oil = new int[xLen * yLen];
        int[][] arr = new int[land.length][];
        for(int i = 0; i < yLen; i++) {
            arr[i] = Arrays.copyOf(land[i], land[i].length);
        }
        
        int label = 1;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (land[j][i] == 1) {
                    int cnt = bfs(i, j, label, land, arr);
                    oil[label] = cnt;
                    label++;
                }
            }
        }
        
        for (int i = 0; i < xLen; i++) {
            
            for (int j = 0; j < xLen * yLen; j++) {
                check[j] = false;
            }
            
            int cnt = 0;
            for (int j = 0; j < yLen; j++) {
                if (arr[j][i] != 0 && !check[arr[j][i]]) {
                    check[arr[j][i]] = true;
                    cnt += oil[arr[j][i]];
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    private int bfs(int x, int y, int label, int[][] land, int[][] arr) {
        
        int xLen = arr[0].length;
        int yLen = arr.length;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        arr[y][x] = label;
        land[y][x] = 0;
        int cnt = 1;
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                if (0 <= nx && nx < xLen && 0 <= ny && ny < yLen && land[ny][nx] == 1) {
                    queue.offer(new Point(nx, ny));
                    arr[ny][nx] = label;
                    land[ny][nx] = 0;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
