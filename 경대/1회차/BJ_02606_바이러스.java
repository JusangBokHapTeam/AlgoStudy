import java.util.*;
import java.io.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/2606 )
 */
public class BJ_02606_바이러스 {

    static int N, M, graph[][], ans;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        virus();

        bw.write(ans+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void virus() {
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 1; i <= N; i++) {
                if(i == now || visited[i] || graph[now][i] != 1) continue;
                visited[i] = true;
                ans++;
                q.offer(i);
            }
        }

    }
}
