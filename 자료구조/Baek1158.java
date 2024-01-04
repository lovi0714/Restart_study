import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");

        String input[] = br.readLine().split(" ");
        // 사람 수
        int N = Integer.parseInt(input[0]);
        // K번째
        int K = Integer.parseInt(input[1]);

        Queue circle = new LinkedList<Integer>();

        // 원모양으로 가정하고 숫자 채워넣기
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        while(!circle.isEmpty()) {
            // K번째 숫자가 맨앞에 올때까지 반복
            for(int goToBackNumber = K - 1; goToBackNumber > 0; goToBackNumber--) {
                // K번째 숫자 전까지 맨 뒤로 보내기
                circle.add(circle.poll());
            }
            // K번째 숫자가 맨 앞에 왔을 때 제거하면서 StringBuilder에 추가
            sb.append(circle.poll());
            // queue가 비어있지 않다면 ", "를 추가하여 계속 이어가고, 비어있다면 추가하지않고 괄호로 닫기.
            if(!circle.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }
}