package boj;

import java.io.*;

/**
 * 백준 G4 ( https://www.acmicpc.net/problem/9663 )
 */
public class BJ_09663_NQueen {

    static int N, ans;
    // 팔방탐색
    static int[] dy = {-1, 0, 1, 0, -1, 1, -1, 1};
    static int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

//        nQueen1(new boolean[N][N], 0);
        nQueen2();

        bw.write(ans + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    // 메모리: 12408KB	시간: 17164ms
    private static void nQueen1(boolean[][] map, int row) {
        // 모두 놓았다면 답 증가시키고 리턴
        if(row == N) {
            ans++;
            return;
        }
        // 놓을 곳 찾아보기 - 놓지 못했다면 리턴
        for (int i = 0; i < N; i++) {
            if(isCheck(map, row, i)) {
                // 놓고나서 놓지 말아야 할 곳 체크하고 다음행으로 진행
                map[row][i] = true;
                nQueen1(map, row + 1);
                map[row][i] = false;
            }
        }
    }

    private static boolean isCheck(boolean[][] map, int row, int col) {
        // 팔방 탐색하며 퀸이 놓여져 있는지 확인
        for(int d = 0; d < 8; d++) {
            int nRow = row + dy[d];
            int nCol = col + dx[d];
            while(nRow >= 0 && nRow < N && nCol >= 0 && nCol < N) {
                if(map[nRow][nCol]) return false;
                nRow += dy[d];
                nCol += dx[d];
            }
        }
        return true;
    }

    // =====================================================

    // 메모리: 12456KB	시간: 2884ms
    static boolean[] col, row, side1, side2;

    private static void nQueen2() {
        col = new boolean[N];
        row = new boolean[N];
        side1 = new boolean[2*N - 1];
        side2 = new boolean[2*N - 1];
        ans = 0;
        set(0);
    }

    private static void set(int i) {
        for(int j = 0; j < N; j++) {
            if(!col[j] && !row[i] && !side1[i + j] && !side2[i - j + (N - 1)]) {
                if(i == N - 1) ans++;
                else {
                    col[j] = row[i] = side1[i + j] = side2[i - j + (N - 1)] = true;
                    set(i + 1);
                    col[j] = row[i] = side1[i + j] = side2[i - j + (N - 1)] = false;
                }
            }
        }
    }


}
