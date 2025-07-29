package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/1012 )
 */
public class BJ_01012_유기농배추 {

    static int T, M, N, K;
    static boolean map[][], visit[][];

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new boolean[M][N];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = true;
            }

            visit = new boolean[M][N];
            bw.write(solve() + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solve() {
        int cnt = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!map[i][j] || visit[i][j]) continue;
                dfs(i, j);
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N || !map[nx][ny] || visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

}
