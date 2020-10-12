package D3;

import java.util.Scanner;

public class D3_안경이없어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int test=1; test<=tc; test++) {
			String str1 = sc.next();
			String str2 = sc.next();
			boolean isTrue = true;
			if(str1.length() != str2.length())
				isTrue = false;
			else {
				for(int i=0; i<str1.length(); i++) {
					int num1 = count(str1.charAt(i));
					int num2 = count(str2.charAt(i));
					
					if(num1 != num2) {
						isTrue = false;
						break;
					}
						
				}
			}
			
			if(isTrue)
				System.out.println("#"+test+" SAME");
			else
				System.out.println("#"+test+" DIFF");
		}
	}
	
	static int count(char input) {
		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		String two = "B";		
		int num = -1;
		
		if(zero.contains(input+""))
			num = 0;
		else if(one.contains(input+""))
			num = 1;
		else if(two.contains(input+""))
			num = 2;
		
		return num;
	}

}
