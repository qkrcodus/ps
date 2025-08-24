import java.util.*;
import java.io.*;

public class Main {
    private static int[][] dp;
    private static int N;
    private static int M;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        init();

        StringBuilder sb = new StringBuilder();
        if (dp[N + M][N] < K) {
            System.out.print(-1);
        } else {
            while (!(N == 0 && M == 0)) {
                if (N == 0) {
                    sb.append('z');
                    M--;
                    continue;
                }

                if (M == 0) {
                    sb.append('a');
                    N--;
                    continue;
                }

                if (dp[N + M - 1][N-1] >= K) {
                    sb.append("a");
                    N--;
                } else {
                    sb.append("z");
                    K = K - dp[N + M - 1][N-1];
                    M--;
                }
            }
        }
        System.out.print(sb);

    }

    private static void init() {
        dp = new int[201][201];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i-1][j-1];
                }
                if (dp[i][j] > 1000000000) {
                    dp[i][j] = 1000000001;
                }
            }
        }

    }
}
