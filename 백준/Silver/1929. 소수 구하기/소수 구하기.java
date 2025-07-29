import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // start end 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i: primeNumbers(end)) {
            if(i>=start){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    // public static List<Integer> primeNumbers(int number) 정의
    public static List<Integer> primeNumbers(int number) {
        int[] numbers = new int[number + 1];
        List<Integer> primeNumbersList=new ArrayList<>();
        Arrays.fill(numbers, 1);
        for (int i = 2; i*i <= number; i++) {
            for (int j = 2; i * j <= number; j++) {
                numbers[i * j] = 0;
            }
        }
        for (int i = 2; i <= number; i++) {
            if (numbers[i] == 1) {
                primeNumbersList.add(i);
            }
        }
        return primeNumbersList;
    }
}
