package streamPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultiStream {
	
	public static void main(String[] args) {
		//마지막은 포함 안함
		IntStream is = IntStream.rangeClosed(1, 1000000);
		long start = System.currentTimeMillis();
		
		int total = is.sum();
		System.out.println(total);
		
		List<Double> myList = new ArrayList<>();
		
		//병렬 스트림 만드는 법 두가지..!
		//컬렌션이용
		Stream<Double> myStream = myList.parallelStream();
		int [] score = {10, 50 ,60, 30};
		
		//Stream 이용
		IntStream myStream2 = IntStream.of(score).parallel();
		
		
		
	}
	
}
