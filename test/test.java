package test;

public class test {

	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];

	        int total = brown + yellow;
	        
	        String[] mark = new String[total/2];
	        
	        int top = 0;
	        
	        for(int i = 3; i < total;i++)
	        {
	            if(total % i == 0)
	            {
	                //가능수 스트링 배열로 저장
	                mark[top++] += String.valueOf(i); 
	            }
	        }
	        //짝수라면
	        if(mark.length % 2 == 0)
	        {
	            answer[0] = Integer.parseInt(mark[top/2]);
	            answer[1] = Integer.parseInt(mark[top/2+1]);
	        }else{
	            answer[0] = Integer.parseInt(mark[top/2+1]);
	            answer[1] = Integer.parseInt(mark[top/2+1]);
	        }
	      
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		test ts = new test();

		int[] t = ts.solution(8,1);
		
		for(int i = 0; i < 2;i++)
		{
			System.out.println(t[i]);
		}
	}

	private int[] solution(int brown, int yellow) {
		// TODO Auto-generated method stub
		int[] answer = new int[2];
        
        int total = brown + yellow;
        
        String[] mark = new String[total/2];
        
        for(int i = 0; i < mark.length;i++)
        {
        	mark[i] = "";
        }
        
        int top = 0;
        
        for(int i = 3; i < total;i++)
        {
            if(total % i == 0)
            {
                //가능수 스트링 배열로 저장
                mark[top++] += String.valueOf(i); 
            }
        }
        //짝수라면
        if(mark.length % 2 == 0)
        {
            answer[0] = Integer.parseInt(mark[top/2]);
            answer[1] = Integer.parseInt(mark[top/2+1]);
        }else{
            answer[0] = Integer.parseInt(mark[top/2+1]);
            answer[1] = Integer.parseInt(mark[top/2+1]);
        }
      
        return answer;
	}
}
