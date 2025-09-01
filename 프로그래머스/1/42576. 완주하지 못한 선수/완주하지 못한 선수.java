import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map=new HashMap<>();
        
        for ( String eachParticipant : participant){
            map.put(eachParticipant, map.getOrDefault(eachParticipant,0)+1);
        }
        for ( String eachCompletion : completion ){
            map.put(eachCompletion, map.get(eachCompletion)-1);
        }
        
        for(String key:map.keySet()){
            if(map.get(key)!=0){
                answer=key;
                break;
            }
        }
       
        return answer;
    }
}