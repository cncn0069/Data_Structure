package assignment;

/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 * 
 */

public class train_실습1_3부분문자열검색 {

	public static void searchSubstring(String text, String pattern) {

		// 비교횟수
		int count = 0;

		int skip[] = new int[pattern.length()];

		int count_skip = 1;
		
		StringBuilder sb= new StringBuilder();

		//KMP
		// 맨 처음은 비교 x
		for (int i = 1; i < pattern.length(); i++) {

			for (int j = 0; j < pattern.length(); j++) {
				if (pattern.charAt(i) == pattern.charAt(j)) {
					skip[i] = skip[i] + count_skip++;
					;
					i = i + 1;

				} else {
					count_skip = 1;
					break;
				}
			}

		}

		System.out.print("[");

		// pattern 길이만큼 빼고 +1
		for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
			
			//KMP표에따라 스킵 정함
			for (int j = skip[count_skip]; j < pattern.length(); j++) {
				// System.out.println(text.charAt(j+i) + " "+pattern.charAt(j));

				if (text.charAt(j + i) != pattern.charAt(j)) {
					count_skip = count;
					count = 0;
					break;
				}

				if (count == pattern.length() - 1) {
					count = 0;

					sb.append(String.valueOf(i));
					sb.append(",");
				}
				count++;
			}
			
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
		System.out.println("]");


	}

	public static void easySubstring(String text, String pattern) {

		// 비슷했던 갯수
		int count = 0;
		
		StringBuilder sb= new StringBuilder();
		
		
		System.out.print("[");

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) != pattern.charAt(count)) {
				i = i - count+1;
				count = 0;
			}

			if (count == pattern.length() - 1) {
				count = 0;
				
				sb.append(String.valueOf(i - pattern.length() + 1));
				sb.append(",");
			}

			// 같으면 더하기
			count++;
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
		System.out.println("]");

	}

	public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";

		searchSubstring(text, pattern);
		text = "abxabcabcabyabcaby";
		pattern = "abcaby";
		searchSubstring(text, pattern);

		text = "ababcabcabababd";
		pattern = "ababd";
		easySubstring(text, pattern);

		text = "abxabcabcabyabcaby";
		pattern = "abcaby";
		easySubstring(text, pattern);
	}
}
