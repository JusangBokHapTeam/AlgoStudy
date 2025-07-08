import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int x, int y) {
            this.x += x;
            this.y += y;
        }
    }

    public int solution(String str) {

        int minX = 0, maxX = 0, minY = 0, maxY = 0, n = 0;
        Point point = new Point(0, 0);
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'F':
                    point.move(dx[n], dy[n]);
                    break;
                case 'B':
                    point.move(-dx[n], -dy[n]);
                    break;
                case 'L':
                    n = ((n - 1) + 4) % 4;
                    break;
                case 'R':
                    n = (n + 1) % 4;
                    break;
            }

            minX = Math.min(point.x, minX);
            maxX = Math.max(point.x, maxX);
            minY = Math.min(point.y, minY);
            maxY = Math.max(point.y, maxY);
        }

        return (maxX - minX) * (maxY - minY);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            bw.write(main.solution(str) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
