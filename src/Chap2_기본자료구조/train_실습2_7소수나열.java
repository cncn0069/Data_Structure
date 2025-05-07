//package Chap2_기본자료구조;
//
//
///*
// * 어떤 정수를 나누어 떨어지게 만드는 수를 약수(divisor)
// * N % d == 0을 만족하는 d를 N의 약수
// * 
// * 소수(prime number)는 1과 자기 자신만을 약수로 가지는 수
// * 약수가 1과 자기 자신 두 개뿐인 자연수를 소수(즉 약수가 2개일 것)
// * 
// * 0은 모든 수로 나누어지므로 소수가 아님.
// * 1은 약수가 하나뿐이라 소수가 될 수 없음.
// * 2는 약수가 두 개(1과 자기 자신)뿐이므로 소수이며, 유일한 짝수 소수
// */
//public class train_실습2_7소수나열 {
//    // 0 이상 n 이하의 소수 개수를 반환하는 함수
//    static int primeCount(int n, int []data) {
//    	int count = 0;
//    	
//    	for(int i = 0;i<=n;i++) {
//    		if(i==2 || i==3) {
//    			data[count] = i;
//    			count++;
//    			continue;
//    			}	
//    		for(int j = 2; j <= Math.sqrt(n);j++) {
//    			//소수가 아니면
//    			
//    			
//    			if(i%j == 0 || i == 1)
//    				break;
//    			//소수이면
//    			if(j == Math.floor(Math.sqrt(n)))
//    			{
//    				data[count] = i;
//    				count++;
//    			}
//    		}
//    		
//    	}
//    	return count;
//    }
//    
////    for(int j = 2; j <= Math.sqrt(n);j++) {
////		//소수가 아니면
////		if(i%j == 0 || i == 1)
////			break;
////		//소수이면
////		if(j == Math.floor(Math.sqrt(n)))
////		{
////			data[count] = i;
////			count++;
////		}
//
//    // 소수 판별 함수
//    static boolean isPrime(int num) {
//    	
//    	for(int j = 2; j < Math.sqrt(num);j++) {
//			//소수가 아니면
//			if(num%j == 0)
//				return false;
//			//소수이면
//			if(j == Math.floor(Math.sqrt(n)))
//			{
//				return true;
//			}
//		}
//    	
//    }
//    // 최대 공약수(GCD) 계산 함수 (유클리드 호제법 사용)
//    /*
//     * 두 수 a와 b(a > b)가 있을 때, 
//     * a를 b로 나눈 나머지를 이용하여 재귀적으로 GCD를 구할 수 있음.
//     * 나머지가 0이 될 때, 나누는 수가 최대 공약수(GCD).
//     * 
//     * 예제: GCD(56, 98) 구하기
//     * 98 % 56 = 42 → GCD(56, 42)
//     * 56 % 42 = 14 → GCD(42, 14)
//     * 42 % 14 = 0 → GCD(14, 0), 즉 최대 공약수는 14.
//     */
//    public static int gcd(int a, int b) {
//    	if(a<b) {
//    		int temp = a;
//    		a = b;
//    		b = temp;
//    	}
//    	if(a==0 || b==0)
//    	{
//    		return a==0?b:a;
//    	}
//    	
//    	int c = a%b;
//    	
//    	
//    	
//    	return gcd(b,c);
//    }
//    // 최소 공배수(LCM) 계산 함수
//    /*
//     * GCD(최대 공약수)와의 관계
//     * LCM(a, b) = (a × b) / GCD(a, b)
//     */
//    public static int lcm(int a, int b) {
//        return (a * b) / gcd(a, b); // LCM 공식: (a * b) / GCD(a, b)
//    }
//    public static void main(String[] args) {
//    	int[] primeArr = new int[100];
//        for (int i = 0; i <= 10; i++) {
//        	int num = primeCount(i, primeArr);
//            System.out.print("\n0부터 " + i + "까지의 소수 개수: " + num + ":: ");
//            if (num > 0)
//            	for (int j =0; j<num; j++)
//            		System.out.print(primeArr[j] + " ");
//        }
//        int num1 = 8, num2 = 22;
//        System.out.println("\n\n" + num1 + "와 " + num2 + "의 최대 공약수: " + gcd(num1, num2));
//        
//        int num3 = 12, num4 = 18;
//        System.out.println("\n\n" + num3 + "과 " + num4 + "의 최소 공배수: " + lcm(num3, num4));
//    }
//	
//}
