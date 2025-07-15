import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // scanner 대신 BufferedReader
        // split 대신 StringTokenizer
        final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        // 공백 기준 파싱해서 dataNum, questionNum에 저장
        final int dataNum=Integer.parseInt(st.nextToken());
        final int questionNum=Integer.parseInt(st.nextToken());

        // sum[ ] 생성 , 인덱스 일치를 위해 더미 0 추가
        // StringTokenizer는 한 줄에 대한 파서 객체, BufferedReader는 계속 재사용 가능한 스트림
        st=new StringTokenizer(br.readLine());
        int sum[]=new int[dataNum+1];
        for (int i=1;i<=dataNum;i++){
            sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
        }

        // questionNum만큼 반복 공백 기준 숫자 파싱해서 startIndex, endIndex 로 저장
        // bw.write(someValue)을 반복문 돌리면 출력 횟수가 많아진다. 출력은 StringBuilder
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<questionNum;i++){
            st=new StringTokenizer(br.readLine());
            final int startIndex=Integer.parseInt(st.nextToken());
            final int endIndex=Integer.parseInt(st.nextToken());
            sb.append(sum[endIndex]-sum[startIndex-1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

