import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 카드 만들기
        Queue<Integer> cards = new LinkedList<>();
        // 카드 몇장인지, 카드 만들기
        int totalCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= totalCount; i++) cards.offer(i);

        // 첫번째 poll해서 제거하고 두번째 poll하면서 맨 뒤에 집어넣기.
        while (cards.size() > 1) {
            cards.poll();
            cards.offer(cards.poll());
        }

        System.out.println(cards.poll());

    }
}
