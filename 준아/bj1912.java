import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public int solution(int n, int[] arr) {

        int answer = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] >= arr[i]) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(main.solution(n, arr)));
        bw.flush();

        br.close();
        bw.close();
    }
}
