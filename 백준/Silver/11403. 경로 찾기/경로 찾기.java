import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정점 개수 vertexCount, 이차원 배열 int[][] array= new int[vertexCount][vertexCount]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(br.readLine());
        int[][] array = new int[vertexCount][vertexCount];

        // array에 값 저장
        for (int i = 0; i < vertexCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < vertexCount; j++) {
                int a = Integer.parseInt(st.nextToken());
                array[i][j] = a;
            }
        }

        // 경유지 k 기준으로 i -> j 까지 연결되었는지 판단후 맞다면, array[i][j]=1
        for (int k = 0; k < vertexCount; k++) {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (array[i][k] == 1 && array[k][j] == 1) {
                        array[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                sb.append(array[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
