package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BackJoon1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		LinkedList<Integer> result = KMP(text, pattern);
		
		System.out.println(result.size());
		for(int temp : result) {
			System.out.println(temp);
		}
	}
	
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j=0;
		
		for(int i=1; i<pattern.length(); i++) {
			while(j>0 && pattern.charAt(j) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(j) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	static LinkedList<Integer> KMP(String text, String pattern) {
		int[] pi = getPi(pattern);
		int j=0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0; i<text.length(); i++) {
			while(j>0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					list.add(i-j+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		return list;
	}

}
