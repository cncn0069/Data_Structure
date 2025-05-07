package Chap6_Sorting;

import java.util.Scanner;

public class HeapSort {
	static void swap(int[] a,int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t; 
	}
	
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left];
		int child;
		int parent;
		
		for (parent = left; parent < (right + 1)/2; parent = child) {
			int cl = parent * 2 + 1;
			int cr = cl + 1;
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
			if(temp >= a[child])
				break;
			
			//부모가 자식보다 작다면
			a[parent] = a[child];
		}
		a[parent] = temp;
	}
	
	static void heapsort(int[] a, int n) {
		for(int i = (n - 1) / 2;i >= 0; i--) {
			downHeap(a, i, n - 1);
		}
		for(int i = n - 1; i > 0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("힙 정렬");
		int [] x = { 6,4,3,7,1,9,8 };
		for(int i = 0; i < 7; i++)
		{
			System.out.print(", x[" + i + "]=" + x[i]);
		}
		System.out.println();
		heapsort(x, 7);
		
		System.out.println("오름차순으로 정렬");
		
		for(int i = 0; i < 7; i++)
		{
			System.out.print(", x[" + i + "]=" + x[i]);
		}
		System.out.println();
		
	}
}
