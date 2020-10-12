package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BackJoon1062 {
	static int max;
	static String[] words;
	static boolean[] alph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-5;
		words = new String[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			words[i] = st.nextToken();
		}
		max = 0;
		if(K>=0) {
			alph = new boolean[26];
		
			alph['a'-97] = true;
			alph['n'-97] = true;
			alph['t'-97] = true;
			alph['i'-97] = true;
			alph['c'-97] = true;
			
			nCr(0, K, 1);
		}
		
		System.out.println(max);
	}
	
	static void nCr(int cnt, int N, int idx) {
		if(cnt==N) {
			int readable = 0;
			for(int i=0; i<words.length; i++) {
				boolean canRead = true;
				for(int j=0; j<words[i].length(); j++) {
					if(!alph[words[i].charAt(j)-97]) {
						canRead = false;
						break;
					}
				}
				if(canRead) readable++;
				
			}
			
			max = Math.max(max, readable);
			return;
		}
		
		for(int i=idx; i<alph.length; i++) {
			if(!alph[i]) {
				alph[i] = true;
				nCr(cnt+1, N, i+1);
				alph[i] = false;
			}
		}
	}

}
