import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public int solution(int n, int m, int[] arr) {

        int s = 0, e = 0;
        for (int i = 0; i < n; i++) {
            s = Math.max(s, arr[i]);
            e += arr[i];
        }

        int answer = e;
        while (s < e) {
            int mid = (s + e) / 2;
            int cnt = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                    cnt++;
                }
            }

            if (cnt > m) {
                s = mid + 1;
            } else {
                e = mid;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(main.solution(n, m, arr)));
        bw.flush();

        br.close();
        bw.close();
    }
}
