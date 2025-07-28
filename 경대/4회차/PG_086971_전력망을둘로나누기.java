import java.util.LinkedList;
import java.util.Queue;

public class PG_086971_전력망을둘로나누기 {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        Solution s = new Solution();
        System.out.println(s.solution(n, wires));
    }

    private static class Solution {

        static int N;
        static boolean graph[][], visit[];

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            N = n;
            graph = new boolean[n + 1][n + 1];
            for(int i = 0; i < n - 1; i++) {
                graph[wires[i][0]][wires[i][1]] = true;
                graph[wires[i][1]][wires[i][0]] = true;
            }

            for(int i = 0; i < n - 1; i++) {
                answer = Math.min(answer, solve(i, wires));
            }

            return answer;
        }

        public int solve(int now, int[][] wires) {
            // now번째 전선 끊기
            graph[wires[now][0]][wires[now][1]] = false;
            graph[wires[now][1]][wires[now][0]] = false;

            int right = bfs(wires[now][0]); // 전력망1의 송전탑 개수
            int left = bfs(wires[now][1]); // 전력망2의 송전탑 개수

            // now번째 전선 연결
            graph[wires[now][0]][wires[now][1]] = true;
            graph[wires[now][1]][wires[now][0]] = true;

            return Math.abs(right - left);
        }

        public int bfs(int now) {
            Queue<Integer> queue = new LinkedList<>();
            visit = new boolean[N + 1];

            int cnt = 0;
            queue.add(now);
            visit[now] = true;
            while(!queue.isEmpty()) {
                int q = queue.poll();
                for(int i = 1; i <= N; i++) {
                    if(!visit[i] && graph[q][i]) {
                        cnt++;
                        queue.add(i);
                        visit[i] = true;
                    }
                }
            }

            return cnt;
        }
    }
}
