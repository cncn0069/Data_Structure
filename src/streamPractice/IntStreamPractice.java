package streamPractice;

import java.util.Optional;
import java.util.stream.IntStream;

public class IntStreamPractice {
	public static void main(String[] args) {
		int [] score = { 50, 10, 80 ,70, 90, 60, 20};
		
		System.out.println("점수 목록");
		IntStream.of(score).forEach((n)->System.out.println(n));
		System.out.println();
		
		int minVal = IntStream.of(score).min().getAsInt();
		System.out.println("최저 점수 : " + minVal);
		
		int maxVal = IntStream.of(score).max().getAsInt();
		System.out.println("최고 점수 : " + maxVal);
		
		System.out.println("점수 정렬 : ");
		
//		IntStream stream = IntStream.of(score).sorted();
//		stream.forEach((n)->System.out.println(n));
//		밑에와 같음
		IntStream.of(score).sorted().forEach((n)->System.out.println(n));
		
		System.out.println("낙제 점수 : ");
		IntStream failScore = IntStream.of(score).filter((n) -> n < 60);
		failScore.forEach((n) -> System.out.println(n));
		System.out.println();
		
		//sum은 뭐 optional 아닌가..?
		int totalScore = IntStream.of(score).sum();
		System.out.println(totalScore);
		//max, Integer::compare 위에랑 차이 ... myList가 Integer 형 List
//		Optional<Integer> maxVal = myList.stream().max(Integer::compare);
//		System.out.println("최고 점수 : " + maxVal.get());
		
		System.out.println("5점 추가");
		IntStream.of(score).map((n)-> n+5).forEach((n)->System.out.println(n));
		
		long cnt = IntStream.of(score).count();
		System.out.println(cnt);
		
		
	}
}
