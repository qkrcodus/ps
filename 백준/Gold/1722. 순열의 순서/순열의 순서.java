import java.util.*;
import java.io.*;

public class Main {
    private static long[] factorialBucket;
    private static int num;
    private static long orderNum;
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine()); // 1~20
        StringTokenizer st = new StringTokenizer(br.readLine());
        int opt = Integer.parseInt(st.nextToken()); // 1 또는 2

        init();

        if (opt == 1) {
            orderNum = Long.parseLong(st.nextToken()); // orderNum 번째엔 어떤 수가 올까?
            orderNum--;

            StringBuilder sb = new StringBuilder();
            for (int i = num - 1; i >= 0; i--) {
                int groupNum = (int) (orderNum / factorialBucket[i]);
                sb.append(numbers.get(groupNum)).append(" ");
                numbers.remove(groupNum);
                orderNum %= factorialBucket[i];
            }

            System.out.print(sb);

        } else {
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = Integer.parseInt(st.nextToken()); // array는 몇 번째 일까?
            }

            long order=1;

            for (int i = 0; i < num; i++) {
                int index=numbers.indexOf(array[i]);
                order +=index*factorialBucket[num-1-i];
                numbers.remove(index);
            }
            System.out.print(order);
        }


    }

    private static void init() {
        factorialBucket = new long[21];
        Arrays.fill(factorialBucket, 1);

        for (int i = 1; i < 21; i++) {
            factorialBucket[i] = factorialBucket[i - 1] * i;
        }
        for (int i = 1; i <= num; i++) {
            numbers.add(i); // [1,2,3,... ]
        }
    }


}
