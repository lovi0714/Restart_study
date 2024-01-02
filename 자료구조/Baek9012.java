// 참고 블로그 https://st-lab.tistory.com/178
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9012 {


    /*
    괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
    그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
    한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
    만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
    그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
    예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

    여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
     */

    /*
    입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
    각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
    하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
     */

    /*
    출력은 표준 출력을 사용한다.
    만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // T개의 테스트 데이터 주어짐.
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }

        System.out.println(sb);

    }

    // 다른 풀이
    static String yesOrNo(String question) {
        while (true) {
            if (!question.contains("()")) break;
            if(question.contains("()")) question = question.replace("()", "");
        }

        if(question.isBlank()) return "YES";
        return "NO";

    }

    public static String solve(String s) {

        // 스택을 활용하여 해결하는 문제.
        Stack<Character> stack = new Stack<>();

        // 괄호 문자열 하나씩 검사.
        for (int i = 0; i < s.length(); i++) {

            // 하나씩 검사
            char c = s.charAt(i);


            // 여는 괄호일 경우 ------------------------------
            // 여는 괄호로 시작할 경우, 스택에 push하여 집어 넣기
            if (c == '(') {
                stack.push(c);

            // 닫는 괄호일 경우 ------------------------------

            // 닫는 괄호를 입력 받았으나 pop할 원소가 없을 때, 이 문자열은 PVS가 아니다.
            } else if (stack.empty()) {
                // 만약
                return "NO";
            // 그 외의 경우 stack 원소를 pop한다. () 짝 맞춰 소거해버리기.
            } else {
                stack.pop();
            }
        }


        // 괄호 문자열 검사가 끝나고 스택이 비어있다면 PVS 이므로 YES
        // 잔여 스택이 남아있다면 NO
        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
