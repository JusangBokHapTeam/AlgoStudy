import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {


    static class Pair{

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n,m;
    static boolean[][] visited;
    static int[] collSumArr;

    public static int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        collSumArr = new int[m];


        visited = new boolean[n][m];

        //1. 가로로 한칸씩 이동
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //2.시추하지 않은 석유가 있는곳만 확인
                if(!visited[j][i] && land[j][i] == 1) {
                    bfs(new Pair(j, i), land);
                }

            }
        }

        //printMap(oilInfoMap);+

        for (int i = 0; i < collSumArr.length; i++) {
            answer = Math.max(collSumArr[i], answer);
        }

        return answer;
    }

    static void printMap(int[][] land) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(land[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int bfs(Pair start, int[][] land) {

        //해당 시추로 영향받는 모든 열
        Set<Integer> collSet = new HashSet<>();

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        //System.out.println("시작위치 = " + start);
        collSet.add(start.y);
        int oilQuantity = 0;

        while(!queue.isEmpty()) {

            Pair curr = queue.poll();
            collSet.add(curr.y);
            oilQuantity += 1;

            for (int i = 0; i < 4; i++) {

                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                if(isOutOfRange(nextX,nextY,n,m) || visited[nextX][nextY]) continue;
                if(land[nextX][nextY] == 0) continue;;

                queue.offer(new Pair(nextX,nextY));
                visited[nextX][nextY] = true;

            }

        }

        for (Integer i : collSet) {
            collSumArr[i] += oilQuantity;
        }

        //System.out.println("석유시추 1 회끝 : " + oilQuantity);
        return oilQuantity;
    }

    static boolean isOutOfRange(int x, int y, int n, int m) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}
