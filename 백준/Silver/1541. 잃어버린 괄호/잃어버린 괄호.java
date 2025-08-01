import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] plusNumbers = br.readLine().split("-");

        // + 우선 계산
        int result = 0;
        for (int i = 0; i < plusNumbers.length; i++) {
            int plusSum = Arrays.stream(plusNumbers[i].split("\\+")).mapToInt(Integer::parseInt).sum();
            if (i == 0) {
                result += plusSum;
                continue;
            }
            result -= plusSum;
        }
           System.out.print(result);
    }
}
