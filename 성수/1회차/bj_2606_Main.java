import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2606_Main {

    static List<ArrayList<Integer>> linkInfo = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(br.readLine());
        int linkCount = Integer.parseInt(br.readLine());

        visited = new boolean[computerCount+1];

        for (int i = 0; i <= computerCount ; i++) {
            linkInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < linkCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            linkInfo.get(from).add(to);
            linkInfo.get(to).add(from);
        }

        bfs(1);


        for (int i = 2; i <= computerCount ; i++) {
            if(visited[i]) {
                result ++;
            }
        }

        System.out.println(result);


    }

    static void bfs(int n) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()) {

            int curr = queue.poll();

            for (Integer i : linkInfo.get(curr)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }

    }
}
