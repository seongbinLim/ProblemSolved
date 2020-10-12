package 모의기출;
import java.util.ArrayList;
import java.util.Scanner;

public class 정올_종교 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
			list[i].add(i);
		}
			
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			boolean already = false;
			B : for(int m=1; m<list.length; m++) {
				for(int n=0; n <list[m].size(); n++) {
					if(list[m].get(n) == a) {
						already = true;
						list[m].add(b);
						break B;
					}
				}
			}
			if(!already) {
				list[a].add(b);
			}
		}
		
		int count = 0;
		for(int m=1; m<list.length; m++) {
			if(list[m].size() > 1) {
				count++;
			}
		}
		System.out.println(count);

	}

}
