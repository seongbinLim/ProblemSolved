package newVersion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Backjoon11003 {
	//윈또 슬라이딩 !
	
	static class Number {
		int value, index;
		public Number(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] input= new int[N];

		ArrayDeque<Number> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());

			if(!dq.isEmpty() && dq.peekFirst().index <= i-K) {
				dq.pollFirst();
			}
			
			while(!dq.isEmpty() && dq.peekLast().value > input[i])
				dq.pollLast();
			
			dq.addLast(new Number(input[i], i));

			sb.append(dq.peekFirst().value+" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
