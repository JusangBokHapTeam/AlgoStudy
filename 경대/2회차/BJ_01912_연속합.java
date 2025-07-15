import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/1912 )
 */
public class BJ_01912_연속합 {

    static int N, input[], dp[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        dp = new int[N];
        dp[0] = input[0];
        ans = input[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + input[i], input[i]); // 연속된 합이 큰지, 현재 값이 큰지 확인
            ans = Math.max(ans, dp[i]);
        }
        bw.write(ans + "\n");

        bw.flush();

        br.close();
        bw.close();
    }
}
