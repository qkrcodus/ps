import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA < rootB) {
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        List<Edge> edgeList = new ArrayList<>();
        long totalLength = 0;

        parent = new int[computerCount + 1];
        for (int i = 1; i < computerCount + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < computerCount; i++) {
            String line = br.readLine();
            for (int j = 0; j < computerCount; j++) {
                char a = line.charAt(j);
                int length = 0;
                if (a >= 'a' && a <= 'z') {
                    length = a - 'a' + 1;
                } else if (a >= 'A' && a <= 'Z') {
                    length = a - 'A' + 27;
                }
                totalLength += length;

                if (length != 0) {
                    edgeList.add(new Edge(i + 1, j + 1, length));
                }
            }
        }

        Collections.sort(edgeList);

        int mstLenght = 0;
        int edgeCount = 0;

        for (Edge edge : edgeList) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                mstLenght += edge.cost;
                edgeCount++;
            }
        }

          if (edgeCount == computerCount - 1) {
            System.out.println(totalLength - mstLenght );
        } else {
            System.out.println(-1);
        }

    }
}
