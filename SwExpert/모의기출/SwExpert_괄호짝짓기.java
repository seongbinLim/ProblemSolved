package 모의기출;
import java.util.Scanner;
import java.util.Stack;

public class SwExpert_괄호짝짓기 {

	public static void main(String[] args) {
		int tc = 10;
		int[] ans = new int[tc];
		Scanner sc = new Scanner(System.in);
		
		for(int test=0; test<tc; test++) {
			boolean flag = true;
			int length = sc.nextInt();
			String input = sc.next();
			Stack<Character> stack1 = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			Stack<Character> stack3 = new Stack<>();
			Stack<Character> stack4 = new Stack<>();
			
			
			for(int i=0; i<length; i++) {
				char c = input.charAt(i);
				if(c == '{') {
					stack1.push(c);
				}
				if(c == '[') {
					stack2.push(c);
				}
				if(c == '(') {
					stack3.push(c);
				}
				if(c == '<') {
					stack4.push(c);
				}
				
				if(c == '}') {
					if(!stack1.isEmpty())
						stack1.pop();
					else {
						flag = false;
						break;
					}
				}
				if(c == ']') {
					if(!stack2.isEmpty())
						stack2.pop();
					else {
						flag = false;
						break;
					}
				}
				if(c == ')') {
					if(!stack3.isEmpty())
						stack3.pop();
					else {
						flag = false;
						break;
					}
				}
				if(c == '>') {
					if(!stack4.isEmpty())
						stack4.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			
			if(flag && stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty())
				ans[test] = 1;
			else
				ans[test] = 0;
			
		}
		
		for(int test=1; test<=tc; test++) {
			System.out.println("#" + test + " " + ans[test-1]);
		}

	}

}
