import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 웅덩이 수, 널판지 길이 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int puddleCount = Integer.parseInt(st.nextToken());
        int boardLength = Integer.parseInt(st.nextToken());

        // 웅덩이 시작과 끝 담을 배열 int [][] puddles 선언 후 정의
        int[][] puddles = new int[puddleCount][2];
        for (int i = 0; i < puddleCount; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }

        // 웅덩이 시작점 기준 정렬
        Arrays.sort(puddles, Comparator.comparingInt(o -> o[0]));

        int result = 0;
        int lastCovered = 0;
        for (int i = 0; i < puddleCount; i++) {
            int start = puddles[i][0];
            int end = puddles[i][1];

            // 이미 덮인 구간이면,
            if (start < lastCovered) {
                start = lastCovered;
            }

            // 전부 덮여있다면,
            if (start >= end) {
                continue;
            }

            int lengthToCover = end - start;
            int boardCount = lengthToCover / boardLength;
            int leftOver = lengthToCover % boardLength;
            if (leftOver != 0) {
                boardCount += 1;
            }
            result += boardCount;
            lastCovered = start + boardCount * boardLength;

        }
        System.out.print(result);

    }

}
