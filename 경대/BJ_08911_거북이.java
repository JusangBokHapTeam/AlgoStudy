import java.io.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/8911 )
 */
public class BJ_08911_거북이 {

    static int t;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String moves = br.readLine();
            solve(moves);
        }

        bw.flush();

        br.close();
        bw.close();
    }

    // 시계방향으로 거북이가 바라보는 측면의 좌표 이동값 저장
    static int[] dy = { 1, 0, -1, 0 }; // 북 동 남 서
    static int[] dx = { 0, 1, 0, -1 };
    // 계산할 좌표값
    static int sy, sx, ly, lx, ny, nx;

    private static void solve(String moves) throws IOException {

        sy = 0; // 거북이가 이동한 좌표중 가장 작은 좌표
        sx = 0;
        ly = 0; // 거북이가 이동한 좌표중 가장 큰 좌표
        lx = 0;
        ny = 0; // 현재 거북이의 좌표
        nx = 0;
        int d = 0; // 거북이의 방향

        char[] move = moves.toCharArray();
        for(int i = 0; i < move.length; i++) {
            switch(move[i]) {
                case 'F': // 한 눈금 앞으로
                    if(d == 0 || d == 2) {
                        ny += dy[d];
                        calcXY();
                    } else {
                        nx += dx[d];
                        calcXY();
                    }
                    break;
                case 'B': // 한 눈금 뒤로
                    if(d == 0 || d == 2) {
                        ny -= dy[d];
                        calcXY();
                    } else {
                        nx -= dx[d];
                        calcXY();
                    }
                    break;
                case 'L': // 왼쪽으로 90도 회전
                    d = (d - 1 + 4) % 4;
                    break;
                case 'R': // 오른쪽으로 90도 회전
                    d = (d + 1) % 4;
                    break;
            }
        }

        // 직사각형의 넓이 구하기
        bw.write(Math.abs((ly - sy) * (lx - sx)) + "\n");
    }

    private static void calcXY() {
        ly = Math.max(ly, ny);
        sy = Math.min(sy, ny);
        lx = Math.max(lx, nx);
        sx = Math.min(sx, nx);
    }

}
