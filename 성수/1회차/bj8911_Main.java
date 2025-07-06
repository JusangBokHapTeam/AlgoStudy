
import java.io.*;


public class Main {


    static class Point {

        int x;
        int y;

        int maxX = -999;
        int maxY = -999;
        int minX = 999;
        int minY = 999;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        void updateMaxMinPoint() {
            this.maxX = Math.max(this.x, this.maxX);
            this.maxY = Math.max(this.y, this.maxY);
            this.minX = Math.min(this.x, this.minX);
            this.minY = Math.min(this.y, this.minY);
        }
    }

    //상좌하우
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    //0, 1, 2, 3 상, 좌, 하, 우
    static int currDirection = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {

            String line = br.readLine();
            getRectangle(line.toCharArray());

        }
    }

    private static void getRectangle(char[] charArray) {

        Point currPoint = new Point(0, 0);
        currPoint.updateMaxMinPoint();

        for (char c : charArray) {
            if(c == 'F') {
                currPoint.x += dx[currDirection];
                currPoint.y += dy[currDirection];
            } else if(c == 'B') {
                //currDirection = (currDirection + 2) % 4;
                int backDirection = (currDirection+2) % 4;
                currPoint.x += dx[backDirection];
                currPoint.y += dy[backDirection];
            } else if(c == 'L') {
                currDirection = (currDirection + 1) % 4;
            } else if(c == 'R') {
                currDirection = (currDirection + 3) % 4;
            }
            currPoint.updateMaxMinPoint();
        }

        int result = (currPoint.maxX - currPoint.minX) * (currPoint.maxY - currPoint.minY);
        System.out.println(result);
    }
}
