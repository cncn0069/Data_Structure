package chap1_기본알고리즘;

/*
* 문자열이 palindrome(앞뒤로 동일하게 읽히는지)인지를 판별
*/
public class train_실습1_1palin문자열 {

    public static void main(String[] args) {
    	// 테스트 케이스로 사용할 예제 문자열들
        String[] testStrings = {
            "racecar", // 팰린드롬
            "level",   // 팰린드롬
            "tattarrattat",  // 팰린드롬, 12글자
            "detartrated",    // 팰린드롬, 11글자
            "redivider" ,      // 팰린드롬, 9글자
            "hello",   // 팰린드롬 아님
            "java"     // 팰린드롬 아님
        };

        // 각 문자열에 대해 팰린드롬 여부 출력
        for (String s : testStrings) {
            System.out.println(s + " -> " + (isPalindrome(s) ? "팰린드롬" : "팰린드롬 아님"));
        }

    }
    
    public static boolean isPalindrome(String data)
    {
    	for(int i = 0;i<data.length();i++)
    	{
    		if(data.charAt(i)!=data.charAt(data.length()-1-i))
    			return false;
    	}
    	return true;
    }
}
