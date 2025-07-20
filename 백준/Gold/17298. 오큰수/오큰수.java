import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // counts 받아오고, counts만큼 숫자 받아오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counts = Integer.parseInt(br.readLine());

        int[] numbers = new int[counts];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < counts; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 정답 배열 -1로 초기화
        int[] result = new int[counts];
        Arrays.fill(result, -1);

        // 스택 쓰기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < counts; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
