

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수의 개수 입력 받고 빈 배열 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] numbers = new int[count];

        // 수들 입력 받고 배열에 넣은 뒤 정렬하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        // result선언
        int result = 0;

        // 배열 시작 ~ 끝까지 반복문 돌리며 타깃 이동
        // while ( left < right )
        // 투포인터 사용, 만족하면 count ++, 조건별로 left -- 나 right ++
        for (int i = 0; i < count; i++) {
            int target = numbers[i];
            int left = 0;
            int right = count - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                if (sum == target) {
                    result++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        // result 출력
        System.out.print(result);
        br.close();

    }
}
