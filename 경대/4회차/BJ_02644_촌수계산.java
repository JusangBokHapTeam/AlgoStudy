import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/2644 )
 */
public class BJ_02644_촌수계산 {

    static int N, P1, P2, M, ans;
    static boolean map[][], visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        P1 = Integer.parseInt(st.nextToken());  // 촌수 계산 사람 번호1
        P2 = Integer.parseInt(st.nextToken());  // 촌수 계산 사람 번호2
        M = Integer.parseInt(br.readLine());    // 관계 개수

        map = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        ans = -1;
        visit = new boolean[N + 1];
        visit[P1] = true;
        dfs(P1, 0);

        bw.write(ans + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int p, int cnt) {
        if(p == P2) {
            ans = cnt;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(map[p][i] && !visit[i]) {
                visit[i] = true;
                dfs(i, cnt + 1);
            }
        }
    }
}
