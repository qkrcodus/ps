import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int computerCount = Integer.parseInt(st.nextToken());
        int infoCount = Integer.parseInt(st.nextToken());

        // 그래프 인접리스트로 표현하기
        graph = new ArrayList[computerCount + 1];
        for (int i = 1; i < computerCount + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < infoCount; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        // 모든 컴퓨터 bfs 돌며, count, visited 갱신
        // int max=0; if(count> max)
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < computerCount + 1; i++) {
            // visited,count 초기화하기
            visited = new boolean[computerCount + 1];
            count = 0;

            bfs(i);
            if (max < count) {
                max = count;
                result.clear();
                result.add(i);
            } else if (count == max) {
                result.add(i);
            }
        }

        // result 정렬후 출력하기
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int b : graph[a]) {
                if (!visited[b]) {
                    visited[b] = true;
                    queue.add(b);
                    count++;
                }
            }
        }
    }
}
