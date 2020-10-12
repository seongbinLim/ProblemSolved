package 모의기출;
import java.util.Scanner;

public class 쇠막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] result = new int[tc];
		
		for(int testcase = 0; testcase<tc; testcase++) {
			String input = sc.next();
			char[] stk = new char[input.length()];
			
			int idx = -1;
			int count = 0;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(') {
					if(i < input.length()-1 && input.charAt(i+1) == ')') { //�젅�씠�� �옄由�
						count += (idx+1);
						i++;
					} else {
						stk[++idx] = '(';
					}
					
				} else {
					count++;
					stk[idx--] = ' ';
				}
			}
			
			result[testcase] = count;			
		}
		
		for(int i=0; i<tc; i++) {
			System.out.println("#" + (i+1) + " " + result[i]);
		}

	}

}
