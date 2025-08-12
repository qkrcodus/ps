class Solution {
    public int solution(int[][] sizes) {
        int[] maxRec=new int[2];
        for(int[] size : sizes){
            if(size[0]<size[1]){
                int temp=size[1];
                size[1]=size[0];
                size[0]=temp;
            }
            if(maxRec[0]<size[0]) maxRec[0]=size[0];
            if(maxRec[1]<size[1]) maxRec[1]=size[1];
        }
        int answer=maxRec[0]*maxRec[1];
        return answer;
    }
}