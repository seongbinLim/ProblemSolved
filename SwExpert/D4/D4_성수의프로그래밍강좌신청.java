package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_성수의프로그래밍강좌신청 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] course = new int[N];
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int i=0; i<N; i++) {
				course[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(course);

			double sungsu = 0.0;
			int length = course.length;
			for(int i = length-K; i< length; i++) {
				sungsu = (sungsu + (double)course[i] ) / 2;
			}
			sb.append("#" + t + " " + sungsu+"\n");
		}
		System.out.println(sb.toString());
	}

}
