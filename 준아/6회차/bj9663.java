import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int N;
    private static int answer = 0;
    private static int[] board;

    public void nQueen(int depth) {

        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    private boolean isPossible(int col) {

        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]
                    || Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        main.nQueen(0);

        bw.write(String.valueOf(answer));

        bw.flush();

        br.close();
        bw.close();
    }
}
