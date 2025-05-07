package test;

//거쳐가기
//이미 지나간길
//경계를 넘어가면 무시
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isSafe(int x, int y){
        return x >= 0 && x < 11 
                && y >= 0 && y < 11;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('D',1);
        map.put('L',2);
        map.put('U',3);
        
        //0 오른쪽 1 아래 2 왼쪽 3 위
        int[] x = {1,0,-1,0};
        int[] y = {0,-1,0,1};
         
        //좌표 평면 크기
        boolean [][] visited = new boolean[11][11];
        
        //시작 좌표는 5,5
        visited[5][5] = true;
        int curX = 5;
        int curY = 5;

        int count = 0;
        
        int moveX = 0;
        int moveY = 0;
        
        for(int i = 0; i < dirs.length();i++){
            //방문하지 않았다면
            moveX = curX + x[map.get(dirs.charAt(i))];
            moveY = curY + y[map.get(dirs.charAt(i))];
            
            //갈 수 있는지 체크
            if(isSafe(moveX, moveY)){
                //방문 안했으면
                if(!visited[moveX][moveY]){
                    count++;
                    visited[moveX][moveY] = true;
                }
                
                curX = moveX;
                curY = moveY;
            }
        }
        answer = count;
        return answer;
    }

    
    public static void main(String[] args) {
		Solution te = new Solution();
		
		int test = te.solution("ULURRDLLU");
		System.out.println(test);
	}
}