import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //st.tokenizer의 활용 
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);

        ArrayDeque<String> initQueue = new ArrayDeque<>();
        ArrayDeque<String> processQueue = new ArrayDeque<>();

        while (st.hasMoreTokens()) {
            initQueue.offer(st.nextToken());
        }
  
        while (!initQueue.isEmpty()) {

            String currToken = initQueue.pollFirst();

            if ("+".equals(currToken)) {
                //prevInteger + rightInteger
                //String leftInteger = initQueue.pollFirst() + String rightInteger = processQueue.pollLast();
                String temp = String.valueOf(Integer.parseInt(initQueue.pollFirst()) + Integer.parseInt(processQueue.pollLast()));
                processQueue.add(temp);

            } else { //- 또는 숫자
                processQueue.offerLast(currToken);
            }

        }
        
        int result = Integer.parseInt(processQueue.pollFirst());

        while(!processQueue.isEmpty()) {

            String currToken = processQueue.pollFirst();

            if ("-".equals(currToken)) {
                String nextToken = processQueue.pollFirst();
                result -= Integer.parseInt(nextToken);
            }

        }

        System.out.print(result);


    }
}
