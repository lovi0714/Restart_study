import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch (S) {
                // 정수를 X를 덱의 앞에 넣는다.
                case "push_front" :
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                // 정수를 X를 덱의 뒤에 넣는다.
                case "push_back" :
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력. 덱에 정수가 들어있지 않으면 -1
                case "pop_front" :
                    if(deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.pollFirst()).append("\n");
                    break;
                // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력. 덱이 정수가 들어있지 않으면 -1
                case "pop_back" :
                    if(deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.pollLast()).append("\n");
                    break;
                // 덱에 들어있는 정수의 개수를 출력한다.
                case "size" :
                    sb.append(deq.size()).append("\n");
                    break;
                // 덱이 비어있으면 1을, 아니면 0을 출력한다.
                case "empty" :
                    if(deq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                // 덱의 가장 앞에 있는 정수를 출력한다. 덱에 들어있는 정수가 없으면 -1
                case "front" :
                    if(deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.peekFirst()).append("\n");
                    break;
                // 덱의 가장 뒤에 있는 정수를 출력한다. 덱에 들어있는 정수가 없으면 -1
                case "back" :
                    if(deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
