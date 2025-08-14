import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(node1, node2, weight));
        }

        parent = new int[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            parent[i] = i;
        }

        int result = 0;
        int usedEdge = 0;
        while (true) {
            if (usedEdge == nodeCount - 1) {
                break;
            }
            Edge e=pq.poll();
            if (find(e.node1)!=find(e.node2)) {
                union(e.node1, e.node2);
                usedEdge++;
                result+=e.weight;
            }
        }
        System.out.print(result);
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot > bRoot) {
            parent[aRoot] = bRoot;
        } else if (aRoot < bRoot) {
            parent[bRoot] = aRoot;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
