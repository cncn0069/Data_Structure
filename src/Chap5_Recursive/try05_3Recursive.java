package Chap5_Recursive;

import java.util.Scanner;
import java.util.Stack;

public class try05_3Recursive {
static void recur(int n) {
	Stack<Integer> stk = new Stack<Integer>();
		
		while(true)
		{
			if(n>0)
			{
				stk.push(n);
				n = n - 1;
				continue;
			}
			
			if(!stk.isEmpty())
			{
				n = stk.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
		
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 처음에는 n = 2,3에 대하여 실행한다 다음에 5에 대하여
		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
