package chap5;

public class RecurMemo {
	static String[] memo = new String[100];
	
	
	
	public static void main(String[] args) {
		recur(4);
	}
	
	static void recur(int n)
	{
		if(memo[n+1] != null) {
			System.out.println(memo[n + 1]);
		}else {
			if(n>0)
			{
				recur(n-1);
				System.out.println(n);
				recur(n-2);
				memo[n+1] = memo[n] + n + "\n" + memo[n-1];
			}
			else {
				//if 조건에서 벗어난 친구들은 출력이 안되기 때문에...
				memo[n+1] = "";
			}
		}
	}
}
