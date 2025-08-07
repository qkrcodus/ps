import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int infoCount = Integer.parseInt(st.nextToken());
        parent = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infoCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                union(b, c);
            } else {
                sb.append(find(b) == find(c) ? "YES\n" : "NO\n");
            }
        }
        System.out.print(sb);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        // 작은 노드를 대표값으로
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }


}
