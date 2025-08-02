import java.io.*;

/**
 * 백준 G5 ( https://www.acmicpc.net/problem/11729 )
 */
public class BJ_11729_하노이탑이동순서 {

    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, N) - 1 + "\n"); // 하노이의 탑 최소 이동 횟수
        hanoi(N, 1, 3, 2);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void hanoi(int n, int from, int to, int temp) throws IOException {
        if(n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }
        hanoi(n - 1, from, temp, to);
        bw.write(from + " " + to + "\n");
        hanoi(n - 1, temp, to, from);
    }

}
