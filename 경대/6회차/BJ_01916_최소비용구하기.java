package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 G5 ( https://www.acmicpc.net/problem/1916 )
 */
public class BJ_01916_최소비용구하기 {

    static int N, M, A, B, dist[];
    static boolean visit[];
    static ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    static PriorityQueue<Vertex> pq = new PriorityQueue<>();
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Vertex(e, d));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(dist[B] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dijkstra() {
        dist[A] = 0;
        pq.offer(new Vertex(A, 0));

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            if (visit[v.n]) {
                continue;
            }
            visit[v.n] = true;

            // ne 의 비용 체크
            for (Vertex ne : graph.get(v.n)) {
                if (!visit[ne.n] && dist[ne.n] >= ne.d + dist[v.n]) {
                    dist[ne.n] = ne.d + dist[v.n];
                    pq.offer(new Vertex(ne.n, dist[ne.n]));
                }
            }
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int n;
        int d;

        public Vertex(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.d - o.d;
        }
    }

}
