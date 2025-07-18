import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Meet {

        private int startHour;
        private int endHour;
        private int gap;

        @Override public String toString() {
            return "Meet{" +
                "startHour=" + startHour +
                ", endHour=" + endHour +
                ", gap=" + gap +
                '}';
        }

        public int getStartHour() {
            return startHour;
        }

        public int getGap() {
            return gap;
        }

        public int getEndHour() {
            return endHour;
        }

        public Meet(int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
            this.gap = endHour - startHour;
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         * 1순위 종료시간
         * 2순위 시작시간
         * 3순위 gap
         * */
        Comparator<Meet> comparator = new Comparator<Meet>() {
            @Override public int compare(Meet o1, Meet o2) {

                int endHourCompare = Integer.compare(o1.getEndHour(), o2.getEndHour());

                if (endHourCompare != 0) {
                    return endHourCompare;
                }

                int startHourCompare = Integer.compare(o1.getStartHour(), o2.getStartHour());

                if (startHourCompare != 0) {
                    return startHourCompare;
                }

                return Integer.compare(o1.getGap(), o2.getGap());

            }
        };

        PriorityQueue<Meet> queue = new PriorityQueue<>(comparator);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.offer(new Meet(start, end));

        }

        //pq는 poll을 하면 순서대로 나오지만 iter로 찍어보면 순서가 보장되지 않음!!

        int answer = 1;
        Meet currMeet = queue.poll();

        while(!queue.isEmpty()) {

            Meet nextMeet = queue.poll();
            //1. 시작시간이 끝나는시간보다 뒤
            if(currMeet.getEndHour() <= nextMeet.getStartHour()) {
                currMeet = nextMeet;
                //System.out.println(currMeet);
                answer += 1;
            }

        }
        System.out.print(answer);

    }
}
