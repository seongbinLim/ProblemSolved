package 모의기출;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SwEx6731 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			int N = Integer.parseInt(br.readLine());
			char [][] board = new char[N][N];
			int [] rows = new int[N];
			int [] cols = new int[N];
			
			for(int row=0; row<N; row++) {
				String t = br.readLine();
				for(int col=0; col<N; col++) {
					board[row][col] = t.charAt(col);
					//System.out.print(board[row][col]);
					
					if(board[row][col] == 'B') {
						rows[row]++;
						cols[col]++;
					}
				}
			}
			
			int result = 0;
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					int blackstone = rows[row] + cols[col];
					if(board[row][col] == 'B') {
						blackstone--;
					}
					
					if(blackstone%2 != 0)
						result++;
				}
			}
			bw.write("#"+i+" "+result+"\n");
		}
		bw.flush();
	}
}
