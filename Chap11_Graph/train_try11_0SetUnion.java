package Chap11_Graph;

class Sets3 {
	
	int[] parent;
	private int n;
	
	
	public Sets3(int sz) {
		n = sz;
		parent = new int[n + 1]; // Don't want to use parent[0]
		for (int i = 1; i <= n; i++)
			parent[i] = -1; // 0 for Simple versions
	}

	public void display() {

		for (int i = 1; i <= n; i++)
			System.out.print(" " + i);
		System.out.println();
		for (int i = 1; i <= n; i++)
			System.out.print(" " + parent[i]);
		System.out.println();
	}

	public void SimpleUnion(int i, int j)
	// Replace the disjoint sets with roots i and j, i != j with their union
	{
		// i,j는 임의 노드
		//parent[j] = //find root
		//root -= 1
		
		int child = i;
		//루트를 골랐으면
		if(parent[i] == -1) {
			
			//루트 위치 저장
			parent[j] = i; 
		}else {
			//i를 가리킴
			parent[j] = i;
		}
		
		
	}

	public int SimpleFind(int i)
	// Find the root of the tree containing element i
	{
		
		while(true) {
			
			if(parent[i] <= -1)
			{
				return i;
			}else {
				i = parent[i];
				//루트가 아닐 때
			}	
		}			
	}

	public void WeightedUnion(int i, int j)
	// Union sets with roots i and j, i != j, using the weighting rule.
	// parent[i]=-count[i] and parent[i]=-count[i].
	{
		parent[j] = SimpleFind(i);
		
		//i가 루트라면
		if(parent[i] <= -1) {
			parent[i] = parent[i] - 1;
		}else {
		//i가 루트가 아니라면
			parent[parent[i]] = parent[parent[i]] - 1;
		}
		
	}

	public int Getter() {
		return n;
	}

}
public class train_try11_0SetUnion {
	static boolean IsCycle(Sets3 s, int i, int j) {
		if(s.parent[i] == s.parent[j]) {
			return true;
		}
		
		//부모랑 다른거를 비교한다면?
		
		return false;
	}
	static int HowManySets(Sets3 s) {
		int count = 0;
		
		for(int i = 1; i < s.Getter()+1;i++) {
			if(s.parent[i] <= -1) count++;
		}
		
		return count;
	}
	public static void main(String[] args) {

		Sets3 s1 = new Sets3(13);
		s1.SimpleUnion(1, 5);s1.SimpleUnion(12, 8);
		s1.SimpleUnion(7, 1);s1.SimpleUnion(12, 10);
		s1.SimpleUnion(2, 3);
		s1.SimpleUnion(4, 5);
		s1.SimpleUnion(6, 7);
		s1.SimpleUnion(4, 2);
		s1.SimpleUnion(5, 7);
		s1.SimpleUnion(9, 11);
		s1.SimpleUnion(13, 9);
		s1.display();
		int n1 = s1.SimpleFind(5);
		int n2 = s1.SimpleFind(7);
		System.out.println("5의 parent = " + n1 + "  7의 parent = " + n2);
		
		if (IsCycle(s1, 7,9))
			System.out.println("7과 9는 같은 집합이다");
		else
			System.out.println("7과 9는 다른 집합이다");	
		System.out.println("세트의 갯수는 " + HowManySets(s1));
		
		Sets3 s2 = new Sets3(13);
		s2.WeightedUnion(1, 2);
		s2.WeightedUnion(3, 4);
		s2.WeightedUnion(5, 6);
		s2.WeightedUnion(7, 8);
		s2.display();

	}
}