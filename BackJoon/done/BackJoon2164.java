package done;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BackJoon2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		int input = -1;
		while(true) {
			//System.out.println(q.toString());
			input = q.poll();
			if(q.size()==0)
				break;
			input = q.poll();
			q.add(input);
		}
		System.out.println(input);
	}

}
