import java.io.*;

public class BJ_01541_잃어버린괄호 {

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A + B - C + D - E - F + G 의 값이 최소가 되려면 - 기준으로 다음 - 가 나타날때까지 괄호로 묶으면 된다
        // (A + B) - (C + D) - (E) - (F + G)
        String[] input = br.readLine().split("-");
        for(int i = 0; i < input.length; i++) {
            String[] input2 = input[i].split("\\+");
            for(int j = 0; j < input2.length; j++) {
                if(i == 0) ans += Integer.parseInt(input2[j]); // 첫번째 괄호만 더하기
                else ans -= Integer.parseInt(input2[j]); // 나머지 괄호는 빼주기
            }
        }
        bw.write(ans + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
