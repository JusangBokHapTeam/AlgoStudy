import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair{
        int x;
        int y;



        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] map;
    static boolean[][] visited;
    static int N, M;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //10
            N = Integer.parseInt(st.nextToken()); // 8
            map = new boolean[N][M];
            visited = new boolean[N][M];
            int batchu = Integer.parseInt(st.nextToken());
            for (int j = 0; j < batchu; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            //위에까지 맵세팅 끝

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[j][k] && !visited[j][k]) {
                        count += 1;
                        bfs(new Pair(j,k));
                    }
                }
            }
            System.out.println(count);
        }


    }

    static void bfs(Pair start) {

        Queue<Pair> queue = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        queue.offer(start);


        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                if(isOutOfRange(nextX,nextY) || visited[nextX][nextY]) continue;
                if(!map[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                queue.offer(new Pair(nextX, nextY));


            }

        }

    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }



}
