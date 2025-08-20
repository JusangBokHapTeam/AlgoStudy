import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int answer1 = 0, answer2 = 0;
    private static char[][] map;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public void dfs(int x, int y, int pinCnt, int moveCnt) {

        if (pinCnt <= answer1) {
            answer1 = pinCnt;
            answer2 = moveCnt;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && map[nx][ny] == 'o') {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                if (0 <= nnx && nnx < map.length && 0 <= nny && nny < map[0].length && map[nnx][nny] == '.') {
                    map[x][y] = '.';
                    map[nx][ny] = '.';
                    map[nnx][nny] = 'o';
                    for (int j = 0; j < map.length; j++) {
                        for (int k = 0; k < map[0].length; k++) {
                            if (map[j][k] == 'o') {
                                dfs(j, k, pinCnt - 1, moveCnt + 1);
                            }
                        }
                    }
                    map[x][y] = 'o';
                    map[nx][ny] = 'o';
                    map[nnx][nny] = '.';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            List<String> input = new ArrayList<>();
            String str = br.readLine();
            while (str != null && !str.isEmpty()) {
                input.add(str);
                str = br.readLine();
            }

            map = new char[input.size()][input.get(0).length()];

            int cnt = 0;
            for (int j = 0; j < input.size(); j++) {
                for (int k = 0; k < input.get(j).length(); k++) {
                    map[j][k] = input.get(j).charAt(k);
                    if (map[j][k] == 'o') {
                        cnt++;
                    }
                }
            }

            answer1 = cnt;
            answer2 = 0;
            for (int j = 0; j < input.size(); j++) {
                for (int k = 0; k < input.get(j).length(); k++) {
                    if (map[j][k] == 'o') {
                        main.dfs(j, k, cnt, 0);
                    }
                }
            }

            bw.write(answer1 + " " + answer2 + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
