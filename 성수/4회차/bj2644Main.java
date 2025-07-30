import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{


    static class Pair {
        int number;
        int count;

        public Pair(int number,int count) {
            this.number = number;
            this.count = count;
        }
    }

    static int peopleCount;
    static int one, two;
    static int relationCount;

    static boolean[] visited;

    static boolean[][] relation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        peopleCount = Integer.parseInt(br.readLine());
        relation = new boolean[peopleCount][peopleCount];
        visited = new boolean[peopleCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());

        relationCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < relationCount; i++) {

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            relation[from][to] = true;
            relation[to][from] = true;

        }

        bfs(one-1, two-1);


    }

    static void bfs(int start, int goal) {

        int answer = 999999;

        Queue<Pair> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(new Pair(start,0));

        while(!queue.isEmpty()) {

            Pair curr = queue.poll();
            if(curr.number == goal) {
                answer = Math.min(answer, curr.count);
                //"정답 "
            }

            for (int i = 0; i < peopleCount; i++) {

                if(visited[i]) continue;
                if(relation[curr.number][i]) {
                    visited[i] = true;
                    queue.offer(new Pair(i, curr.count + 1));
                }

            }

        }

        if(answer == 999999) {
            answer = -1;
        }
        System.out.println(answer);

    }


}
