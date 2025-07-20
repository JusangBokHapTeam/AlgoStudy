package boj;

import java.io.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/11727 )
 */
public class BJ_11727_2xN타일링2 {

	static int N, dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			// 2번째 전에서 〓, □ 를 추가한  두가지가 있고, 1번째 전에서 | 를 추가한 한가지를 더하면 됨
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}

		bw.write(dp[N] + "\n");

		bw.flush();
		bw.close();
	}

}
