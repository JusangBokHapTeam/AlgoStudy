import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public int solution(int n) {

        int[] dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(main.solution(n)));
        bw.flush();

        br.close();
        bw.close();
    }
}
