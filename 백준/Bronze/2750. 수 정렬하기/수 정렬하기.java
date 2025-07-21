
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 개수 counts 입력 받기
        // counts 만큼 반복하며 숫자 입력 받고 numbers배열에 담기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counts = Integer.parseInt(br.readLine());
        int[] numbers = new int[counts];
        for (int i = 0; i < counts; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 0, 10, 210, 3210...
        // 삽입 정렬 - 바깥 루프 : 삽입 대상
        for (int i = 1; i < counts; i++) {
            // 안쪽 루프 : 비교할 인덱스
            for (int j = 0; j < i; j++) {
                if (numbers[i - j] < numbers[i - j - 1]) {
                    int temp = numbers[i - j];
                    numbers[i - j] = numbers[i - j - 1];
                    numbers[i - j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        // 한 줄씩 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts; i++) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.print(sb);
    }
}
