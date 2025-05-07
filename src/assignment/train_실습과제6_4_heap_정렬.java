package assignment;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		n = 0;
MaxSize = sz;
		
		//1부터 쓸것이므로
		heap = new int [heapSize];
	}

	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		int i;
	
		for(i = 0; i < n;i++)
		 {
			 System.out.println(heap[i+1]);
		 }
	}
	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		
		//제일 마지막에 삽입
		n++;
		heap[n] = x;
		int i = n;
		
		
		while(i > 1)
		{	
			int parentIndex = i/2;
			//부모 노드보다 크면
			if(heap[parentIndex] < heap[i])
			{
				int temp = heap[parentIndex];
				heap[parentIndex] = heap[i];
				heap[i] = temp;
				
				i = parentIndex;
			}
			else {
				//크지않으면 교체하지 않음
				break;
			}
			
		}


	}
	@Override
	public int DeleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다. 
		int x = heap[1];
		int i, j;
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}
		//마지막 처음에 넣기
		heap[1] = heap[n];
		
		i = 1;
		
		while(i < heap.length) {
			
			
			//heap[i]가 자식 노드보다 작다면
			if(heap[i] < heap[(i*2)] || heap[i] < heap[(i*2)+1]) {
				
				//왼쪽이 더 크면
				if(heap[i*2] > heap[i*2 + 1]) {
					int temp = heap[i];
					heap[i] = heap[i*2];
					heap[i*2] = temp;
					
					//왼쪽으로가기
					i = i*2;
				}else {
					int temp = heap[i];
					heap[i] = heap[i*2 + 1];
					heap[i*2 + 1] = temp;
					
					//오른쪽으로가기
					i = i*2 + 1;
				}
				
			}else {
				//자식보다 크다면
				break;
			}
		}
		
		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class train_실습과제6_4_heap_정렬 {
	 static void showData(int[] d) {
		for(int n: d)
		{
			System.out.print(n + ", ");
		}
		System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    int []sorted = new int[count];//heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				int val = 0;
				for(int i = 0; i < count;i++)
				{
					val = rnd.nextInt(20);
					heap.Insert(val);
					System.out.println("(" + val + ")");
				}
			    //showData(x);
				
				
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 

				for(int i = 0; i < count;i++)
				{
					x[i] = heap.DeleteMax();
					
				}
				showData(x);
				break;
				
			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}

