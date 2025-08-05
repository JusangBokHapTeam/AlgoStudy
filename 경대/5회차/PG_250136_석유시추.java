import java.util.*;
import java.awt.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/250136 )
 */
public class PG_250136_석유시추 {

    static int[][] map, visit;
    static int N, M, visitCnt;
    static int[] saveCnt;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static int solution(int[][] land) {
        int answer = 0;
        map = land;
        N = land.length;
        M = land[0].length;

        visitCnt = 1;
        visit = new int[N][M];
        saveCnt = new int[N * M]; // 덩어리 최대값 < N * M

        // 1. 일단 한번 bfs를 전체적으로 돌고 값을 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 1 || visit[i][j] > 0) continue;
                saveCnt[visitCnt] = bfs(i, j);
                visitCnt++;
            }
        }

        // 2. 시추하면서 값 저장
        for(int i = 0; i < M; i++) {
            int cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(map[j][i] != 1 || visit[j][i] == 0 || list.contains(visit[j][i])) continue;
                cnt += saveCnt[visit[j][i]];
                list.add(visit[j][i]);
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    private static int bfs(int n, int m) {
        int cnt = 1;
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(n, m));
        visit[n][m] = visitCnt;
        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int d = 0; d < 4; d++) {
                int ny = now.x + dy[d];
                int nx = now.y + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] > 0 || map[ny][nx] != 1) continue;
                q.add(new Point(ny, nx));
                visit[ny][nx] = visitCnt;
                cnt++;
            }

        }

        return cnt;
    }

}
