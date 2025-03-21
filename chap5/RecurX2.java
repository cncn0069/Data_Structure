package chap5;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecurX2 {

	
	public static void main(String[] args) {
		recur(4);
	}
	
	static void recur(int n) {
		Stack<Integer> s = new Stack<Integer>();
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			
			break;
		}
	}
}
