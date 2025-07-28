import java.util.*;
import java.io.*;

public class Main{
    // adjacentList, visited 전역으로
    public static List<Integer>[] adjacentList;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // nodeCount, edgeCount, startNode 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        // adjacentList 에 그래프 형태 저장하기
        adjacentList = new ArrayList[nodeCount + 1];
        visited= new boolean[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        // 양방향 엣지 저장하기 + 정렬
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacentList[from].add(to);
            adjacentList[to].add(from);
        }
        for (int i = 1; i < nodeCount + 1; i++) {
            Collections.sort(adjacentList[i]);
        }

        // dfs + 줄바꿈
        dfs(startNode);
        System.out.println();
        // visited 배열 초기화
        Arrays.fill(visited, false);
        // bfs
        bfs(startNode);
    }

    public static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : adjacentList[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    // 큐에 방문한 노드들 넣기 
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        // 처음엔 그냥 넣기
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int A = queue.poll();
            System.out.print(A + " ");
            for (int i : adjacentList[A]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
