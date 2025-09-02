package boj;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * 백준 G4 ( https://www.acmicpc.net/problem/2239 )
 */
public class BJ_02239_스도쿠 {

    static boolean flag = false;
    static int numCnt;
    static int[] row, col, square;
    static int[][] map = new int[9][9];
    static ArrayList<Point> points = new ArrayList<>();

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        row = new int[9];
        col = new int[9];
        square = new int[9]; // 0 1 2
                             // 3 4 5
                             // 6 7 8

        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                int now = str.charAt(j) - '0';
                map[i][j] = now;
                // 스도쿠 중복체크를 위해 비트마스킹
                if(now != 0) {
                    row[i] = row[i] | 1 << now;
                    col[j] = col[j] | 1 << now;
                    square[nSqaure(i, j)] = square[nSqaure(i, j)] | 1 << now;
                } else {
                    numCnt++;
                    points.add(new Point(j, i));
                }
            }
        }

        sudoku(0, 0);

        br.close();
        bw.close();
    }

    private static void sudoku(int idx, int cnt) throws IOException {

        // 출력초과 방지
        if(flag) return;

        // 정답일때 리턴
        if(cnt == numCnt) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    bw.write(map[i][j] + "");
                }
                bw.newLine();
            }
            bw.flush();
            flag = true;
            return;
        }
        
        int x = points.get(idx).x;
        int y = points.get(idx).y;

        // 1~9까지 넣어보기
        for(int n = 1; n <= 9; n++) {
            if((row[y] & 1 << n) != 0 || (col[x] & 1 << n) != 0 || (square[nSqaure(y, x)] & 1 << n) != 0 || flag) continue;

            row[y] |= 1 << n;
            col[x] |= 1 << n;
            square[nSqaure(y, x)] |= 1 << n;
            map[y][x] = n;

            // 다음 0으로 이동
            sudoku(idx + 1, cnt + 1);

            row[y] &= ~(1 << n);
            col[x] &= ~(1 << n);
            square[nSqaure(y, x)] &= ~(1 << n);
            map[y][x] = 0;
        }
    }

    private static int nSqaure(int i, int j) {
        if(i < 3 && j < 3) return 0;
        else if(i < 3 && j < 6) return 1;
        else if(i < 3 && j < 9) return 2;
        else if(i < 6 && j < 3) return 3;
        else if(i < 6 && j < 6) return 4;
        else if(i < 6 && j < 9) return 5;
        else if(i < 9 && j < 3) return 6;
        else if(i < 9 && j < 6) return 7;
        else/*(i < 9 && j < 9)*/return 8;
    }
}
