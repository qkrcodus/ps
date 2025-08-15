import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer>[] adjacentList;
    private static int[] indegree;
    private static int buildingNum;
    private static int[] buildingTime;
    private static int[] resultTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        buildingNum = Integer.parseInt(br.readLine());
        adjacentList = new ArrayList[buildingNum + 1];
        indegree = new int[buildingNum + 1];
        buildingTime = new int[buildingNum + 1];
        resultTime = new int[buildingNum + 1];

        for (int i = 1; i < buildingNum + 1; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < buildingNum + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildingTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                adjacentList[a].add(i);
                indegree[i]++;
            }
        }
        // 인접 리스트( i 공사가 끝나면 이어서 공사할 건물들 저장 ), 진입 차수 배열, 각 건물당 걸리는 시간 초기화 완료

        // buildingTime은 각 건물 짓는데만 걸린 시간
        // resultTime 은 갱신된 값 저장
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < buildingNum + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = buildingTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adjacentList[current]) {
                resultTime[next] = Math.max(resultTime[next], resultTime[current] + buildingTime[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < buildingNum + 1; i++) {
            sb.append(resultTime[i]).append("\n");
        }
        System.out.print(sb);
    }
}
