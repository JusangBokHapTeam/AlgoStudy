import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void hanoi(int n, int from, int mid, int to) throws IOException {

        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        hanoi(n - 1, from, to, mid);
        bw.write(from + " " + to + "\n");
        hanoi(n - 1, mid, from, to);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        int n = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, n) - 1) + "\n");

        main.hanoi(n, 1, 2, 3);

        bw.flush();

        br.close();
        bw.close();
    }
}
