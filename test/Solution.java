package test;

import java.util.Map;
import java.util.HashMap;

//1 -> 2 -> 3 ->1
//마지막 문자로 시작하는 단어
//번호 , 차례
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        //몇바퀴 째인지
        int round = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < words.length;i++)
        {
            
            
           
            //이미 한번 나왔을 때
            if(map.get(words[i]) != null)
            {
                answer = new int[]{round, i%n};
                return answer;
            }else{
                  map.put(words[i],1);
            }
          
            if(i != 0)
            {
                char ar = words[i - 1].charAt(words[i - 1].length() - 1);
                char bf = words[i].charAt(0);

                //앞단어와 뒷단어의 첫글자가 다를 때
                if(ar != bf)
                {
                    answer = new int[]{round, i%n};
                    return answer;  
                } 
            }else{
                char ar = words[i].charAt(words[i].length() - 1);
                char bf = words[i+1].charAt(0);

                //앞단어와 뒷단어의 첫글자가 다를 때
                if(ar != bf)
                {
                    answer = new int[]{round, i%n};
                    return answer;  
                } 
            }
            
        }
        answer = new int[]{0,0};
        return answer;
    }
    
    public static void main(String[] args) {
		Solution te = new Solution();
		
		int [] test = te.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
		System.out.println(test[0] + " "+ test[1]);
	}
}