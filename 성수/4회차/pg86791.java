import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {


    static class Pair {
        int from;
        int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }



    static List<List<Integer>> linkedList = new ArrayList<>();
    static boolean[][] linkMap;


    

    public int solution(int n, int[][] wires) {
        int answer = 9999;

        /*1. 연결관계 set */
        setLink(n, wires);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {


                if(i == j) {
                    continue;
                }

                /*2. 연결 링크 하나씩 끊어보기*/
                if(linkMap[i][j]) {


                    //System.out.println("제거할 노드 : " + i + " " + j);
                    linkMap[i][j] = false;
                    linkMap[j][i] = false;



                    int a = bfs(n,i);
                    int b = bfs(n,j);

                    linkMap[i][j] = true;
                    linkMap[j][i] = true;


                    answer = Math.min(answer, Math.abs(a-b));
                    //System.out.println(a + " " + b);

                }

            }
        }



        return answer;
    }

    public static int bfs(int n, int startNode) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        visited[startNode] = true;
        queue.offer(startNode);

        int count = 0;
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            count += 1;

            for (int i = 0; i < n; i++) {

                if(linkMap[curr][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }

            }
        }

        return count;

    }

    private static void setLink(int n, int[][] wires) {

        linkMap = new boolean[n][n];
        for (int i = 0; i < wires.length; i++) {

            int from = wires[i][0]-1;
            int to = wires[i][1]-1;

            linkMap[from][to] = true;
            linkMap[to][from] = true;
        }
    }


}
