import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 인접 리스트로 그래프 표현하기
        graph = new ArrayList[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode].add(endNode);
        }

        // visited, dist 배열 초기화하기
        visited = new boolean[nodeCount + 1];
        dist = new int[nodeCount + 1];
        Arrays.fill(dist, 0);

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodeCount + 1; i++) {
            if (dist[i] == length) {
                sb.append(i).append("\n");
            }
        }
        if (sb.length()==0) {
            System.out.print(-1);
        } else {
            System.out.print(sb);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int i : graph[a]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[a] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
