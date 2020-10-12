package 모의기출;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SwEx1824 {
	public static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			String t = br.readLine();

			int R = Character.getNumericValue(t.charAt(0));
			int C = Character.getNumericValue(t.charAt(2));
			
			board = new char[R][C];

			for(int x=0; x<R; x++) {
				String s = br.readLine();
				for(int y=0; y<C; y++) {
					board[x][y] = s.charAt(y);
				}
			}
			
			find(0, 0, 0, 0, 1);
			
		}
	}
	
	public static void find(int mem, int x, int y, int Xgo, int Ygo) {
		if(board[x][y] == '@') {
			//boolean true;
			System.out.println("FIN");
			return;
		}
		
		char doit = board[x][y];
		System.out.println(mem + "------------------------");
		System.out.println("B: " + doit + " (" +x +"," + y +")");
		
		if(doit == '<'| doit == '>'| doit == '^'| doit == 'v') {
			int [] data = dirc(doit, x, y);
			Xgo = data[0];
			Ygo = data[1];
		} else if('_' == doit) {
			if(mem == 0) {
				int [] data = dirc('>', x, y);
				Xgo = data[0];
				Ygo = data[1];
			} else {
				int [] data = dirc('<', x, y);
				Xgo = data[0];
				Ygo = data[1];
			}
		} else if('|' == doit) {
			if(mem == 0) {
				int [] data = dirc('v', x, y);
				Xgo = data[0];
				Ygo = data[1];
			} else {
				int [] data = dirc('^', x, y);
				Xgo = data[0];
				Ygo = data[1];
			}
		} else if('?' == doit) {
			
		} else if('.' == doit) {

		} else if('+' == doit) {
			if(mem == 15) mem = 0;
			else mem++;
		} else if('-' == doit) {
			if(mem == 0) mem = 15;
			else mem--;
		} else {
			mem = Character.getNumericValue(doit);
		}
		
		if('?' == doit) {
			int [] data = new int[2];
			for(int i=0; i<4; i++) {
				if(i == 0) {
					data = dirc('>', x, y);
				} else if(i == 1) {
					data = dirc('<', x, y);
				} else if(i == 2) {
					data = dirc('^', x, y);
				} else {
					data = dirc('v', x, y);
				}
				find(mem, x+data[0], y+data[1], data[0], data[1]);
			}
		} else {
			if(x+Xgo < 0) {
				find(mem, board.length-1, y+Ygo, Xgo, Ygo);
			} else if(x+Xgo >= board.length) {
				find(mem, 0, y+Ygo, Xgo, Ygo);
			} else if(y+Ygo < 0) {
				find(mem, x+Xgo, board[x].length-1, Xgo, Ygo);
			} else if(y+Ygo >= board[x].length) {
				find(mem, x+Xgo, 0, Xgo, Ygo);
			} else {
				find(mem, x+Xgo, y+Ygo, Xgo, Ygo);
			}
		}
	}
	public static int[] dirc(char input, int x, int y) {
		int [] xy = new int[2];
		int Xgo = -1, Ygo = -1;
		
		if('<' == input) {
			if(y == 0) {
				Ygo = board[x].length-1;
				Xgo = 0;
			}
			else {
				Ygo = -1;
				Xgo = 0;
			}
		} else if('>' == input) {
			if(y == board[x].length-1) {
				Ygo = board[x].length-1 * (-1);
				Xgo = 0;
			}
			else {
				Ygo = 1;
				Xgo = 0;
			}
		} else if('^' == input) {
			if(x == 0) {
				Xgo = board.length-1;
				Ygo = 0;
			}
			else {
				Xgo = -1;
				Ygo = 0;
			}
		} else if('v' == input) {
			if(x == board.length-1) {
				Xgo = board.length * (-1);
				Ygo = 0;
			}
			else {
				Xgo = 1;
				Ygo = 0;
			}
		} 
		
		xy[0] = Xgo;
		xy[1] = Ygo;
		
		return xy;
	}
}
