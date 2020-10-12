package D4;
import java.util.Scanner;
import java.util.Stack;

public class D4_계산기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			String str = sc.next();
			
			Stack<Character> stk = new Stack<>();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(Character.isDigit(c))
					sb.append(c);
					//System.out.print(c);
				else {
					if(c == '+' || c == '-') {
						while(!stk.isEmpty()) {
							sb.append(stk.pop());
							//System.out.print(stk.pop());
						}
						stk.push(c);
					}
					else if(c == '*' || c == '/') {
						while(!stk.isEmpty() && stk.peek() != '+' && stk.peek() != '-')
							sb.append(stk.pop());
							//System.out.print(stk.pop());
						stk.push(c);
					}
				}
			}
			
			while(!stk.isEmpty())
				sb.append(stk.pop());
			
			str = sb.toString();
			
			Stack <String> stk2 = new Stack<>();
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '*' || c == '+' || c == '/' || c =='-') {
					int a = Integer.parseInt(stk2.pop());
					int b = Integer.parseInt(stk2.pop());
					int result = -1;
					
					if(c == '*')
						result = a*b;
					if(c == '+')
						result = a+b;
					if(c == '-')
						result = a-b;
					if(c == '/')
						result = a/b;
					
					stk2.push(Integer.toString(result));
					
				} else {
					stk2.push(c+"");
				}
			}
			
			System.out.println("#"+tc+" " + stk2.pop());
			
		}

	}

}
