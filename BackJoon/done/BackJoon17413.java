package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BackJoon17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> stk = new Stack<>();
		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') {
				boolean has = false;
				for (int j = 0; j < stk.size(); j++) {
					if (stk.get(j) == '<') {
						has = true;
						stk.push(c);
						break;
					}
				}
				if (!has) {
					while (!stk.isEmpty()) {
						System.out.print(stk.pop());
					}
					System.out.print(c);
				}
			} else if (c == '<') {
				while (!stk.isEmpty()) {
					System.out.print(stk.pop());
				}
				stk.push(c);
			} else if (c == '>') {
				for (int j = 0; j < stk.size(); j++) {
					System.out.print(stk.get(j));
				}
				System.out.print(c);
				stk.clear();
			} else {
				stk.push(c);
			}
		}
		
		while (!stk.isEmpty()) {
			System.out.print(stk.pop());
		}

	}

}
