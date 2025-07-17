
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 카드 수 읽고 count에 저장하기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        
        // 큐 선언하기
        Queue<Integer> queue=new LinkedList<>();
        
        // 큐에 카드 저장하기
        for(int i=0;i<count;i++){
            queue.add(i+1);
        }
        
        // while ( 큐 크기가 1 초과일때 ) poll 한거 버리고, poll+add
        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }
        // 큐 출력하기
        System.out.print(queue.poll());
    }
}
