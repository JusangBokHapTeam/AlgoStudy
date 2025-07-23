import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //블루레이 크기를 정하면 필요한 블루레이 개수를 계산 가능
        //블루레이의 최소값 : 가장 긴 레슨 길이 (한개 이상의 레슨이 무조건 포함되어야함)
        //블루레이의 최대값 : 모든 레슨의 합
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int maxLessonTime = 1;
        int totalLessonTime = 0;
        int[] lessons = new int[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            totalLessonTime += lessons[i];
            maxLessonTime = Math.max(maxLessonTime, lessons[i]);
        }

        //가능한 블루레이의 크기 중 최소
        int left = maxLessonTime;
        int right = totalLessonTime;
        int answer = right;

        while(left <= right) {

            int mid = (left+right)/2;
            int bluelayCount = getCountBluelay(lessons, mid);

            if(bluelayCount <= m) {
                //m 개이하로 만들 수 있으므로 -> 더 작은 크기로 줄일수 있는지 확인
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }

    public static int getCountBluelay(int[] lessons, int capacity) {
        int count = 1;
        int currentSum = 0;

        for (int lesson : lessons) {
            if(currentSum + lesson > capacity) {
                count ++;
                currentSum = lesson;
            } else {
                currentSum += lesson;
            }
        }
        return count;
    }
}
