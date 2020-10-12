package 모의기출;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class D4_염라대왕의이름정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			 int N = sc.nextInt();sc.nextLine();
			 
			 TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
				 public int compare(String pre, String next) {
					 if(pre.length() != next.length()) {
						 return pre.length() - next.length();
					 } else {
						 return pre.compareTo(next);
					 }
				 }
			});
			
			for(int i=0; i<N; i++) {
				set.add(sc.nextLine());
			}
			
			System.out.println("#"+t);
			for(String str : set) {
				System.out.println(str);
			}
		}

	}

}
