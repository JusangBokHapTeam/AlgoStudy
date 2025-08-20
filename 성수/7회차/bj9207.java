import java.io.*;

public class Main{

    static char[][] board;
    static int minPins;
    static int minMoves;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test ; i++) {

            board = new char[5][9];
            minPins = Integer.MAX_VALUE;
            minMoves = Integer.MAX_VALUE;

            for (int j = 0; j < 5; j++) {
                String line = br.readLine();
                board[j] = line.toCharArray();
            }

            // DFS 시작
            dfs(0);

            // 결과 출력
            sb.append(minPins).append(" ").append(minMoves).append("\n");
            br.readLine();

        }

        System.out.println(sb.toString());

    }


    static int getPinCount() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 'o') count++;
            }
        }
        return count;
    }


    static void dfs(int moves) {

        int currentPins = getPinCount();

        if (currentPins < minPins) {
            minPins = currentPins;
            minMoves = moves;
        } else if (currentPins == minPins) {
            minMoves = Math.min(minMoves, moves);
        }

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 9; y++) {

                //핀일때만
                if (board[x][y] != 'o') continue;

                for (int dir = 0; dir < 4; dir++) {

                    // 인접 핀
                    int nx1 = x + dx[dir];
                    int ny1 = y + dy[dir];
                    // 도착할 위치
                    int nx2 = nx1 + dx[dir];
                    int ny2 = ny1 + dy[dir];

                    if (isOutOfRange(nx1, ny1) || isOutOfRange(nx2, ny2)) continue;
                    if (board[nx1][ny1] != 'o' || board[nx2][ny2] != '.') continue;

                    //핀 이동 직접 그리기
                    board[x][y] = '.';
                    board[nx1][ny1] = '.';
                    board[nx2][ny2] = 'o';

                    dfs(moves + 1);

                    // 핀 이동 지우기
                    board[x][y] = 'o';
                    board[nx1][ny1] = 'o';
                    board[nx2][ny2] = '.';
                }
            }
        }
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || x >= 5 || y < 0 || y >= 9;
    }
}
