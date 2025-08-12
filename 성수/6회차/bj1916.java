import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, M;
    static List<Node>[] list;

    static int[] distance;

    static int START_NODE, END_NODE;

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
        }
        st = new StringTokenizer(br.readLine());
        START_NODE = Integer.parseInt(st.nextToken());
        END_NODE = Integer.parseInt(st.nextToken());

        dijkstra(START_NODE);

        System.out.print(distance[END_NODE]);

    }

    static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()) {

            Node curr = pq.poll();

            if(distance[curr.node] != curr.weight) continue;;

            List<Node> nodes = list[curr.node];

            for(Node nextNodes : nodes) {

                if(distance[nextNodes.node] > distance[curr.node] + nextNodes.weight) {
                    distance[nextNodes.node] = distance[curr.node] + nextNodes.weight;
                    pq.offer(new Node(nextNodes.node,distance[nextNodes.node]));
                }
            }


        }

    }
}
