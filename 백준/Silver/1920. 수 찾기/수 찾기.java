
import java.util.*;
import java.io.*;

public class Main {
    public static int[] numbers;
    public static int[] targets;

    public static void main(String[] args) throws IOException {
        // 요쇼 개수 counts 받고, 개수만큼 numbers[]에 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counts = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        numbers = new int[counts];
        for (int i = 0; i < counts; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }
        // numbers 정렬
        Arrays.sort(numbers);

        // 찾을 숫자 개수 targetCounts 받고, 찾을 숫자들 targets[] 에 저장
        int targetCounts = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        targets = new int[targetCounts];
        int[] results = new int[targetCounts];
        for (int i = 0; i < targetCounts; i++) {
            targets[i] = Integer.parseInt(st2.nextToken());
            results[i] = binarySearch(targets[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetCounts; i++) {
            sb.append(results[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static int binarySearch(int key) {
        int start = 0;
        int end = numbers.length - 1;

        // while (start<=end)
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] > key) {
                end = mid - 1;

            } else if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
