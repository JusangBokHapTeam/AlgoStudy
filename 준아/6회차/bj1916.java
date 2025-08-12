import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {

        private int to;
        private int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static final List<List<Node>> map = new ArrayList<>();
    private static int[] dist;
    private static boolean[] visited;

    public void dijkstra(int v) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(v, 0));
        dist[v] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (visited[currentNode.to]) {
                continue;
            }
            visited[currentNode.to] = true;

            for (Node nextNode : map.get(currentNode.to)) {
                if (!visited[nextNode.to] && currentNode.cost + nextNode.cost < dist[nextNode.to]) {
                    dist[nextNode.to] = currentNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.to, dist[nextNode.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        main.dijkstra(x);

        bw.write(String.valueOf(dist[y]));
        bw.flush();

        br.close();
        bw.close();
    }
}
