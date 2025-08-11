import java.util.*;
import java.io.*;

class Solution {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n-1;
        // 양방향 그래프,visited[]
        graph=new ArrayList[n+1];
        for (int i=1;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        for (int[] wire : wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
      
        // 간선별로 제거된 상황에서 count 몇개인지 세기 count0, count1에 저장
        // int diff = (count1>count0) ? count1-count0 : count0-count1
        // answer>diff answer=diff;
        
        for (int[] wire : wires){
            int count0,count1=0;
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            visited=new boolean[n+1];
            count0=dfs(wire[0]);
            count1=n-count0;
            int diff = (count1>count0) ? count1-count0 : count0-count1;
            if(answer>diff) answer=diff; 
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }        
        return answer;
    }
   
    private int dfs(int a){
        visited[a]=true;
        int count=1;
        for ( int i : graph[a]){
            if(!visited[i]){
                count+=dfs(i);
            }
        }
        return count;
    }
}