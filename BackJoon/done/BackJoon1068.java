package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon1068 {
	static int del;
	static int count;
	static int[] node;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		node = new int[N];
		cnt = new int[N];
		for(int i=0; i<N; i++) {
			node[i] = sc.nextInt();
		}
		
		del = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			if(find(i)==-1) {
				cnt[i] = -1;
			}
		}
		cnt[del] = -1;
		//System.out.println(Arrays.toString(node));
		
		for(int i=0; i<N; i++) {
			parent(i);
		}
		
		for(int i=0; i<N; i++) {
			if(cnt[i] == 0) count++;
		}
		//System.out.println(Arrays.toString(cnt));
		System.out.println(count);
	}
	static void parent(int idx) {
		if(node[idx] == -1) return;
		if(cnt[idx] == -1) return;
		cnt[node[idx]]++;
		
		parent(node[idx]);
		
	}
	static int find(int idx) {
		if(node[idx] == del || node[del] == -1)  {	
			return -1;
		}
		if(node[idx] == -1) return 1;
		
		return find(node[idx]);
		
	}
	
}
