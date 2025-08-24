import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] depthArray; // 깊이
    private static int[] parent; // 부모 노드
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int nodeCount=Integer.parseInt(br.readLine());

        graph=new ArrayList[nodeCount+1];
        for(int i=1;i<nodeCount+1;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<nodeCount;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 트리 초기화 완료

        visited=new boolean[nodeCount+1];
        depthArray=new int[nodeCount+1];
        parent=new int[nodeCount+1];
        dfs(1,0);
        // 루트 노드인 1부터 시작해서 각 노드의 깊이 구하기 완료

        // 다음 입력
        int qCount=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for ( int i=0;i<qCount;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int result=lca(a,b);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int x,int depth){
        visited[x]=true;
        depthArray[x]=depth;
        for ( int a : graph[x]){
            if (!visited[a]){
                parent[a]=x;
                dfs(a,depth+1);
            }
        }
    }

    private static int lca(int a,int b){
        while (depthArray[a]!=depthArray[b]){
            if(depthArray[a]>depthArray[b]) a=parent[a];
            else b=parent[b];
        }
        while (a!=b){
            a=parent[a];
            b=parent[b];
        }
        return a;
    }



}
