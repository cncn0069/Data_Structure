package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamPractice {
	
	public static void main(String[] args) {
		int[] values = {1,2,3,4,5};
		ArrayList<Integer> arr  = new ArrayList<Integer>();
		
		for(int i = 0; i <100;i++) {
			arr.add(i);
		}
		
		// Arrays로 부터 stream을 받을 때
		int sum = Arrays.stream(values).filter((n)-> n %2 == 1).sum();
		// Collection들은 stream(), prallelStrean()을 모두 가지고 있음 
		// 
		int sum2 = arr.stream()
				.filter((n)-> n %2 == 1)
				.mapToInt(n->n)
				.sum();
		
		System.out.println(sum + ":" + sum2);
		
		int [] score = {50, 10, 80, 70, 90, 60, 20};
		//이걸 어디다 쓰는데..?
		IntStream is = Arrays.stream(score);
		
		System.out.println();
		
		//IntStream IntStream.range(int,int); 
		//rangeClosed는 마지막 값 포함 할지 않할지
		//1 2 3
		is = IntStream.range(1,3);
		//1 2 3 4
		is = IntStream.rangeClosed(1,3);
		
		//Stream<T> IntStream LongStream DoubleStream들의 of 이하동일
		String[] str = {"one","two","three"};
		Stream<String> myStream1 = Stream.of(str);
		Stream<String> myStream2 = Stream.of("four","five","six","seven");
		
		//BaseStream 인터페이스
		
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(50);
		myList.add(10);
		myList.add(80);
		myList.add(70);
		myList.add(90);
		myList.add(60);
		myList.add(20);
		
		
		System.out.println("점수 목록 : ");
		Stream<Integer> myStream = myList.stream();
		//forEach
		myStream.forEach((n)->System.out.println(n + " "));
		System.out.println();
		
		Optional<Integer> minVal = myList.stream().min(Integer::compare);
		System.out.println("최저 점수 : " + minVal.get());
		
		//max, Integer::compare
		Optional<Integer> maxVal = myList.stream().max(Integer::compare);
		System.out.println("최고 점수 : " + maxVal.get());
		
		System.out.println("점수 정렬 : ");
		Stream<Integer> myStream21 = myList.stream().sorted();
		myStream21.forEach((n)->System.out.println(n));
		System.out.println();
		
		System.out.println("낙제 점수 : ");
		Stream<Integer> failScore = myList.stream().filter((n) -> n < 60);
		failScore.forEach((n)-> System.out.println(n));
		
		System.out.println("점수 합계 : ");
		//b가 0부터 시작함
		Optional<Integer> totalScore = myList.stream().reduce((a,b) -> a + b);
		//초기값을 쓰고 싶을 때
		Integer totalScore2 = myList.stream().reduce(0, (a,b) -> a + b);
		System.out.println(totalScore.get());
		
		System.out.println("5점 추가 : ");
		Stream<Integer> addScore = myList.stream().map((n) -> n + 5);
		addScore.forEach((n) -> System.out.println(n));
		System.out.println();
		
		long cnt = myList.stream().count();
		System.out.println("점수 갯수 : " + cnt);
		
	}
}
