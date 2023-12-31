/*
풀이 참고 : https://st-lab.tistory.com/175
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /* BuffererdReader 문자열을 한 줄로 읽음.
         push() 같은 경우에는 문자, 숫자 단어 구분이 필요하기 때문에 공백을 기준으로 문자열을 분리해주어야한다.
        StringTokenizer 사용
        */

        StringTokenizer st;

        // 명령의 수
        int N = Integer.parseInt(br.readLine());

        // stack의 크기는 최대 N개
        stack = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
        }


    // 정수 X를 스택에 넣는 연산이다.
    public static void push(int item) {
        // 현재 배열에서 비어있는 가장 마지막 위치에 숫자를 넣어주고
        stack[size] = item;
        // size를 +1하며 마지막 위치를 갱신한다.
        size++;
    }

    /* 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
    만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    */
    public static int pop() {
        if (size == 0) {
            // size가 0이라면, 뺄 수가 없으므로 -1을 리턴한다.
            return -1;
        }
        else {
            // size가 0이 아니라면 배열에서 비어있지 않은 가장 마지막 숫자를 구하고
            int res = stack[size - 1];
            // 그 자리에 0을 넣어 비워준다.
            stack[size - 1] = 0;
            // 그리고 size -1을 하며 마지막 위치를 갱신한다.
            size--;
            return res;
        }
    }
    // 스택에 들어있는 정수의 개수를 출력한다.
    public static int size() {
        return size;
    }
    // 스택이 비어있으면 1, 아니면 0을 출력한다.
    public static int empty() {
        if(size == 0) {
            // size가 0이라면, 배열은 비어있으므로 1을 리턴하고
            return 1;
        }
        else {

            // 아니라면 0을 출력한다.
            return 0;
        }
    }
    /* 스택의 가장 위에 있는 정수를 출력한다.
    만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    */
    public static int top() {
        if(size == 0) {
            // size가 0이라면 배열은 비어있으므로 -1을 리턴하고
            return -1;
        }
        else {
            // 아니라면, 비어있지 않은 가장 마지막 숫자를 리턴한다.
            return stack[size - 1];
        }
    }

}
