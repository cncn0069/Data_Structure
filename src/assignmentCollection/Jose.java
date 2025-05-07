package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Jose {
	
	
	public int solution(int n , int k){
		Queue<Integer> que = new LinkedList<Integer>();
		
		
		for(int i = 0; i < n;i++) {
			que.offer(i);
		}
		
		int result = 0;

		
		while(!que.isEmpty()) {
			for(int i = 0; i < k-1;i++) {
				que.offer(que.poll());
			}
			result = que.poll();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		char[] a = {'A','B','C','D','E'};
		Jose jo = new Jose();
		
		int n = 5;
		int k = 3;
		System.out.println(n + "번째 사람중 \n" + k +"번째 사람이 계속 나가면 남는 사람은" + a[jo.solution(n,k)]);
		
	}
}


//list가 다 빌때까지
//while(!(list.size() == 1)){
//	//k번째 사람이 나간다
//	//1 2 3 4 5 6 7
//	//4
//	//1 2 3 5 6 7
//	
//	//n-1번까지 하고
//	for(int i = 0; i < k-1;i++) {
//		list.add(list.remove());
//	}
//	//n제거
//	result = list.remove(0);
//}