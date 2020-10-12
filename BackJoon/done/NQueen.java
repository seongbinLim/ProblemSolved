package done;
import java.util.Arrays;

public class NQueen {
    static int[][] map;
    public static void main(String[] args) {
        map = new int[8][8];
        backtrack(0);
        System.out.println(cnt);
    }
    static int cnt = 0;
    //idx��° �࿡ ���� ��ġ�ϴ� �Լ�
    static void backtrack(int idx) {
        //�� �ٰ�
        if( idx == map.length ) {
            cnt++;
            for(int i = 0; i < map.length; i++)
                System.out.println(Arrays.toString(map[i]));
            System.out.println();
            return;
        }
         
        //���� ������ŭ �ݺ��ϸ鼭( ���� ���� �� �ִ� �ĺ����� �˻� )
        for(int i = 0; i < map[idx].length; i++) {
            if( isPossible(idx, i) ) {
                map[idx][i] = 1;
                backtrack(idx + 1);
                map[idx][i] = 0;
            }
        }
    }
    static boolean isPossible(int r, int c) {
        //���� map�� ���¸� ������ r,c�� ���ο� ���� ���Ƶ� ���� ������?
         
        //�� ���� ���� �ִ��� �˻�, ������ return false;
        for(int i = r; i >= 0; i--) {
            if( map[i][c] == 1 )
                return false;
        }
        //�� ���� ���� ���� �ִ��� �˻�.
        for(int i = r, j = c; i >= 0 && j >=0; i--,j--) {
            if( map[i][j] == 1 )
                return false;
        }
        //�� �����U ���� ���� �ִ��� �˻�.
        for(int i = r, j = c; i >= 0 && j < map[i].length; i--, j++) {
            if( map[i][j] == 1 )
                return false;
        }
        return true;
    }
}