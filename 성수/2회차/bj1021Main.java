import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int queueSize = Integer.parseInt(st.nextToken());
        int pickSize = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pickSize; i++) {
            indexQueue.offer(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 1; i <= queueSize ; i++) {
            queue.offer(i);
        }


        int answer = 0;

        //10 3
        //2 9 5
        while (!indexQueue.isEmpty()) {

            //뽑아내야 하는 인덱스
            Integer currOut = indexQueue.poll();

            int size = queue.size();
            int index = 1;
            int searchIndex = 0;
            for (Integer element : queue) {
                if(Objects.equals(currOut, element)) {
                    searchIndex = index;
                }
                index += 1;
            }

            int divideTwoQueueSize = size / 2;
            //오른쪽으로 회전
            if(searchIndex > divideTwoQueueSize + 1) {

                while(queue.peek() != currOut) {
                    int last = queue.pollLast();
                    queue.offerFirst(last);
                    answer += 1;
                }
            } else { //왼쪽 회전
                while(queue.peek() != currOut) {
                    int first = queue.pollFirst();
                    queue.offerLast(first);
                    answer+= 1;
                }
            }

            if(!queue.isEmpty() && queue.peek() == currOut) {
                queue.poll();
            }

        }

        System.out.print(answer);
        //1 2 3 4 5
        //1 2 3 4
        

    }
}
