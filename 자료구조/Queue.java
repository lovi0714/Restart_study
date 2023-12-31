/*
풀이 참고 : https://st-lab.tistory.com/186
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue {
    // 첫째 줄에 주어지는 명령의 수 N은 (1 <= N <= 2,000,000)이다.
    static int[] q = new int[2000000];

    static int size = 0;
    static int front = 0;
    static int back = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        System.out.println(sb);
    }

        //push X : 정수 X를 큐에 넣는 연산이다.
        static void push(int n) {
            // 큐에서 현재 맨 뒤 위치를 확인하고 n을 넣는다.
            q[back] = n;
            // 마지막 위치 : n을 넣은 위치 +1
            back++;
            // n이 한 개 들어갔으니 size + 1
            size++;
        }

        // pop : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우 -1 출력
        static void pop() {
            if(size == 0) {
                // 사이즈가 0이면 아무것도 없는 것이니 -1 출력
                sb.append(-1).append('\n');
            }
            else {
                sb.append(q[front]).append('\n');	// 맨 앞의 원소를 출력
                size--; // 원소 하나 뺐으니 size -1
                front++;	// front가 가리키는 위치 1 증가
            }
        }

        // size : 큐에 들어있는 정수의 개수를 출력한다.
        static void size() {
            // 현재 size 출력
            sb.append(size).append('\n');
        }

        // empty : 큐가 비어있으면 1, 아니면 0을 출력한다.
        static void empty() {
            if(size == 0) {
                // size가 0이면 큐가 비어있는 것이니 1 출력
                sb.append(1).append('\n');
            }
            // 아니라면 비어있지 않은 것이니 0 출력
            else {
                sb.append(0).append('\n');
            }
        }

        // 큐의 가장 앞에 있는 정수를 출력한다. 큐에 들어있는 정수가 없는 경우 -1 출력
        static void front() {
            if(size == 0) {
                // 사이즈가 0이면 비어있는 것이니 -1 출력
                sb.append(-1).append('\n');
            }
            else {
                sb.append(q[front]).append('\n');	 // 맨 앞의 원소 출력
            }
        }

        // 큐의 가장 뒤에 있는 정수를 출력한다. 큐에 들어있는 정수가 없는 경우에 -1 출력
        static void back() {
            if(size == 0) {
                // 사이즈가 0이면 비어있는 것이니 -1 출력
                sb.append(-1).append('\n');
            }
            else {
                sb.append(q[back - 1]).append('\n');	// 맨 뒤의 원소 출력
            }
        }


    }
}
