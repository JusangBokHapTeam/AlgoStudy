import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int t, n, m, k;
    private static boolean[][] arr;
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

    public int solution() {

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    private void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        arr[x][y] = false;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int l = 0; l < 4; l++) {
                int nx = tmp.x + dx[l];
                int ny = tmp.y + dy[l];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    arr[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = true;
            }

            bw.write(main.solution() + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
