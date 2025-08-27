class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int start=triangle.length -2;
        while(start>=0){
            for( int j=0;j<=start;j++){
                triangle[start][j]=triangle[start][j]+ Math.max(triangle[start+1][j],triangle[start+1][j+1]);
            }
             start--;
        }
        answer=triangle[0][0];
        return answer;
    }
}