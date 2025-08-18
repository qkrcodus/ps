import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        int[][] dp=new int[15][15];

        for (int i=1;i<15;i++){
            dp[0][i]=i;
        }

        for(int n=1;n<15;n++){
            for(int k=1;k<15;k++){
                dp[n][k]=dp[n-1][k]+dp[n][k-1];
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<testCaseCount;i++){
            int n=Integer.parseInt(br.readLine());
            int k=Integer.parseInt(br.readLine());
            sb.append(dp[n][k]).append("\n");
        }

        System.out.print(sb);
    }
}
