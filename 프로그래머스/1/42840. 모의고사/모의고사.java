import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two={2,1,2,3,2,4,2,5};
        int[] three={3,3,1,1,2,2,4,4,5,5};
        int[] correctCount=new int[3];
        
        for ( int i=0;i<answers.length;i++){
            if(answers[i]==one[i%5]) correctCount[0]++;
            if(answers[i]==two[i%8]) correctCount[1]++;
            if(answers[i]==three[i%10]) correctCount[2]++;
        }
        
        int max=0;
        for(int correct: correctCount){
            if(max<=correct) max=correct;
        }
        
        List<Integer> winnerList = new ArrayList<>();
        if (max== correctCount[0]) winnerList.add(1);
        if (max== correctCount[1]) winnerList.add(2);
        if (max== correctCount[2]) winnerList.add(3);
        
        
        return winnerList.stream().mapToInt(i->i).toArray();
    }
}