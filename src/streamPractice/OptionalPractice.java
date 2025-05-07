package streamPractice;


import java.util.ArrayList;
import java.util.Optional;

public class OptionalPractice {
	
	
	public static void main(String[] args) {
		ArrayList<OptionalMember> members = new ArrayList<OptionalMember>();
		
		members.add(new OptionalMember("김푸름", 25, "010-123-4562","서울"));
		members.add(new OptionalMember("김하늘", 31, "010-803-4562","부산"));
		members.add(new OptionalMember("오정임", 29, "010-4488-4562","대전"));
		
		Optional<OptionalMember> mem1 = members.stream()
												.filter((m) -> m.getAge() > 20)
												.findFirst();
												
		if(mem1.isPresent())
			System.out.println(mem1.get());
		
		//위에서 if를 뒤에 더 붙이면 밑에가 됨
		members.stream()
				.filter((m) -> m.getAge() > 20)
				.findFirst()
				.ifPresent(System.out::println);
		
		//else 옵션값이 있으면 그대로 반환 없으면 람다식 실행한 결과값 반환
		OptionalMember mem2 = members.stream()
							.filter((m) -> m.getAge() > 30)
							.findFirst()
							.orElseGet(OptionalMember::new);
		
		System.out.println(mem2);
	}
}
