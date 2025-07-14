import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        // 공백 기준 파싱 dataNum, questionNum
        String[] input1=br.readLine().split(" ");
        int dataNum=Integer.parseInt(input1[0]);
        int questionNum=Integer.parseInt(input1[1]);

        // 숫자들 data[ ]에 저장
        String[] input2=br.readLine().split(" ");
        int[] data=new int[dataNum];
        for (int i=0;i<dataNum;i++){
            data[i]=Integer.parseInt(input2[i]);
        }

        // 데이터 수만큼 sum 배열 0으로 초기화
        int[] sum=new int[dataNum];
        sum[0]=data[0];
        
        // sum[i]=sum[i-1]+data[i]
        for (int i=1;i<dataNum;i++){
            sum[i]=sum[i-1]+data[i];
        }

        // questionNum만큼 반복 공백 기준 숫자 파싱해서 a, b 로 저장
        for (int i=0;i<questionNum;i++) {
            String[] input3 = br.readLine().split(" ");
            int a = Integer.parseInt(input3[0])-1;
            int b = Integer.parseInt(input3[1])-1;

            if (a==0) {
                bw.write(sum[b] + "\n");
            } else bw.write(sum[b] - sum[a - 1]+ "\n");
        }

        br.close();
        bw.close();
    }
}
