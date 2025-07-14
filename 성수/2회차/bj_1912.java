import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            int currNumber = Integer.parseInt(st.nextToken());
            arr[i] = Math.max(arr[i-1] + currNumber, currNumber);

            result = Math.max(result, arr[i]);
        }

        System.out.print(result);

    }
}
