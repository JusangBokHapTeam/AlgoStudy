import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int answer = -1;
    private static int n, m, a, b;
    private static boolean[][] arr = new boolean[101][101];
    private static boolean[] check = new boolean[101];

    public void dfs(int v, int level) {

        if (v == b) {
            answer = level;
            return;
        }

        if (level == n) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] && !check[i]) {
                check[i] = true;
                dfs(i, level + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;
            arr[y][x] = true;
        }

        check[a] = true;
        main.dfs(a, 0);
        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
