
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int n, m;
    static int[] numbers, result;

    public static void main(String[] args) throws IOException {
        // n , m 입력 받고 길이가 n인 배열.sort() ( 1부터 시작 )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        result = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        dfs(0);
    }

    // dfs : 종료 조건 -> m 만큼 깊이 , 상태 -> numbers 배열, 방문 여부 -> visted 배열
    private static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.print(sb);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }
}
