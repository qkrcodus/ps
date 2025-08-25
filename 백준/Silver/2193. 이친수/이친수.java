import java.util.*;
import java.io.*;

public class Main {
    private static long[] dp = new long[91];
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        init();

        System.out.print(dp[N]);
    }

    private static void init() {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
