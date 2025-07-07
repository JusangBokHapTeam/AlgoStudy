import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, answer;
    private static boolean[][] graph;
    private static boolean[] check;

    public void dfs(int v) {

        check[v] = true;
        for (int i=1;i<=n;i++) {
            if (graph[v][i] && !check[i]) {
                dfs(i);
                answer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        n = Integer.parseInt(br.readLine());
        graph = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        main.dfs(1);
        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
