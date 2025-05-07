package streamPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class IteratorPractice {
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("김푸름");
		names.add("김하늘");
		names.add("오정임");
		
		Stream<String> myStream = names.stream();
		
		Iterator<String> it = myStream.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
