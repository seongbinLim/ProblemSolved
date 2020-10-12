package 모의기출;
import java.io.*;
import java.util.*;
 
/**
 * @author itsmeyjc
 * @since 2020. 9. 3
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class SwEx5654_prof {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
 
    static int T, N, M, K;
    // 세포 정보는 PQ에서 관리하고 map에는 세포가 있나 없나만..
    static boolean[][] map;
    // 살아있는 세포들을 관리하자.(활성화 + 비활성화)
    static PriorityQueue<Cell> liveCells;
    // 상태도 변수로 나타내볼까?
    static int ABLED = 1, DEAD = -1, DISABLED = 0;
 
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
 
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());
            // map은 초기 크기 N, M에서 K 만큼 확장한다.
            map = new boolean[N + K + 2][M + K + 2];
            liveCells = new PriorityQueue<>();
 
            for (int r = 0; r < N; r++) {
                tokens = new StringTokenizer(input.readLine());
                for (int c = 0; c < M; c++) {
                    int life = Integer.parseInt(tokens.nextToken());
                    if (life > 0) {
                        // 원점 이동
                        Cell cell = new Cell(r + K / 2, c + K / 2, life);
                        liveCells.offer(cell);
                        map[cell.r][cell.c] = true;
                    }
                }
            }
            /* for (boolean[] row : map) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println(liveCells);*/
            // 입력 완료
            incubate();
 
            output.append(String.format("#%d %d%n", t, liveCells.size()));
        }
        System.out.println(output);
    }
 
    static void incubate() {
        // 주어진 시간동안 성장한다.
        for (int k = 0; k < K; k++) {
            // 새롭게 관리할 cell들이 들어갈 곳
            PriorityQueue<Cell> nextPQ = new PriorityQueue<>();
 
            while (!liveCells.isEmpty()) {
                Cell cell = liveCells.poll();
                if (cell.status == DISABLED) {
                    cell.wait--;
                    if (cell.wait == 0) {
                        cell.status = ABLED;
                    }
                    nextPQ.offer(cell);
                } else if (cell.status == ABLED) {
                    for (int d = 0; d < deltas.length; d++) {
                        int nr = cell.r + deltas[d][0];
                        int nc = cell.c + deltas[d][1];
 
                        if (!map[nr][nc]) {
                            map[nr][nc] = true;
                            // 확장된 세포는 기존 세포의 생명령을 가져간다.
                            nextPQ.add(new Cell(nr, nc, cell.life));
                        }
                    } // 사방 확장 종료
                    cell.life--;
                    if (cell.life > 0) {
                        nextPQ.offer(cell);
                    }
                }
            }
            liveCells = nextPQ;
        }
    }
 
    // 세포 - P.Q --> 우선순위 비교
    static class Cell implements Comparable<Cell> {
        int r, c;
        int life;// 생명력
        int wait;// 활성화까지 남은 시간
        int status;// -1: 사망, 1: 활성, 0: 비활성(기본)
 
        public Cell(int r, int c, int life) {
            this.r = r;
            this.c = c;
            this.wait = this.life = life;
        }
 
        @Override
        // 생명력이 높은놈이 짱!!! -- 내림차순
        public int compareTo(Cell o) {
            return Integer.compare(o.life, this.life);
        }
 
        @Override
        public String toString() {
            return "[" + r + ", " + c + ", l=" + life + ", w=" + wait + ", s=" + status + "]";
        }
 
 
    }
 
    private static String src = "5\r\n" +
                                "2 2 10\r\n" +
                                "1 1\r\n" +
                                "0 2\r\n" +
                                "5 5 19\r\n" +
                                "3 2 0 3 0 \r\n" +
                                "0 3 0 0 0 \r\n" +
                                "0 0 0 0 0 \r\n" +
                                "0 0 1 0 0 \r\n" +
                                "0 0 0 0 2\r\n" +
                                "9 10 37\r\n" +
                                "0 0 0 0 0 0 0 0 3 0 \r\n" +
                                "0 0 0 0 0 0 0 0 5 3 \r\n" +
                                "0 0 2 0 0 0 0 4 0 0 \r\n" +
                                "3 0 0 0 0 0 4 0 0 0 \r\n" +
                                "0 0 0 0 0 3 5 0 0 2 \r\n" +
                                "0 0 0 0 0 0 0 0 0 5 \r\n" +
                                "0 0 0 0 0 0 0 0 2 3 \r\n" +
                                "0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 0 2 2 0 0 0 0 0 0 \r\n" +
                                "20 18 83\r\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 2 0 0 6 0 0 0 \r\n" +
                                "0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 0 0 6 0 0 0 0 0 0 0 0 0 0 2 0 3 0 \r\n" +
                                "4 0 2 0 0 0 0 0 0 0 0 0 5 0 0 0 0 3 \r\n" +
                                "0 0 0 0 0 5 4 4 6 0 0 0 0 0 0 0 0 0 \r\n" +
                                "5 0 0 0 0 0 2 0 2 6 0 0 0 0 0 4 0 0 \r\n" +
                                "4 0 0 3 0 0 0 0 0 0 0 3 0 0 0 5 0 0 \r\n" +
                                "0 0 0 0 0 0 0 2 2 0 0 0 0 3 0 0 0 0 \r\n" +
                                "0 0 0 0 5 0 0 0 3 0 3 0 0 4 0 0 0 0 \r\n" +
                                "0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 0 0 0 6 0 2 0 0 0 0 0 3 0 0 0 3 0 \r\n" +
                                "0 5 2 0 0 0 0 4 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "3 0 0 0 0 0 0 0 6 0 2 0 5 0 0 0 0 0 \r\n" +
                                "5 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 6 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n" +
                                "0 0 0 4 0 0 0 0 0 0 0 0 0 0 2 0 0 0 \r\n" +
                                "0 0 3 4 5 0 0 0 0 0 0 0 0 0 0 6 0 0 \r\n" +
                                "2 0 0 0 0 3 0 0 0 0 0 0 0 0 0 5 0 0 \r\n" +
                                "0 0 0 0 0 0 0 0 0 3 6 2 0 0 0 0 0 0 \r\n" +
                                "49 43 283\r\n" +
                                "0 6 0 0 0 10 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 4 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 0 0 \r\n"
                                +
                                "0 5 0 0 0 2 0 0 0 0 0 0 8 0 0 8 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 3 7 0 0 0 0 0 0 9 0 1 0 5 0 0 1 0 0 0 0 0 0 0 0 0 0 0 9 0 7 0 0 0 0 0 0 0 0 1 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 8 0 0 0 0 0 0 0 0 0 3 0 0 0 6 0 0 0 0 6 0 0 0 0 0 0 \r\n"
                                +
                                "7 0 0 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 0 0 8 0 0 0 0 0 0 0 0 1 0 0 \r\n"
                                +
                                "0 9 0 0 0 0 0 0 0 0 9 6 0 2 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 \r\n"
                                +
                                "0 0 0 0 1 0 0 0 0 0 0 3 0 0 0 0 0 0 5 0 10 0 0 0 0 0 0 0 0 0 9 4 0 0 0 0 0 0 9 0 9 0 8 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 7 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 3 2 0 1 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 7 0 0 0 2 0 0 0 0 0 0 8 0 0 0 0 10 0 0 1 7 0 8 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 2 0 0 9 0 0 0 0 0 8 0 0 0 0 0 4 0 6 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "1 0 0 0 0 0 0 6 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 6 0 5 0 0 0 0 0 0 7 0 0 0 \r\n"
                                +
                                "8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 5 8 \r\n"
                                +
                                "0 0 0 10 0 9 0 8 0 0 0 0 0 0 2 9 0 0 0 7 2 7 0 7 0 0 0 0 2 0 4 3 0 0 0 0 0 0 0 0 0 2 0 \r\n"
                                +
                                "1 0 0 0 0 0 0 4 9 1 0 0 0 0 0 0 0 0 0 5 0 0 0 0 6 0 0 5 0 0 0 0 0 0 0 0 0 0 0 3 3 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 0 1 0 3 1 10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 1 0 0 0 9 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 10 0 0 0 0 0 0 9 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 1 3 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 6 0 0 0 1 0 0 2 0 0 0 0 9 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 7 7 0 0 \r\n"
                                +
                                "0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 5 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 \r\n"
                                +
                                "0 0 0 0 9 0 8 0 0 0 0 0 0 4 0 0 0 10 8 0 0 0 0 0 0 10 0 0 0 5 0 0 0 0 0 0 0 1 0 0 10 4 7 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 0 4 0 7 0 0 0 0 0 3 0 \r\n"
                                +
                                "0 0 0 0 5 0 3 0 0 0 0 0 0 0 8 1 0 0 7 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 9 0 1 0 0 0 0 10 7 0 0 0 0 0 2 0 0 7 0 0 0 0 0 0 0 7 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 8 2 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 8 0 0 7 0 2 0 0 0 0 \r\n"
                                +
                                "0 8 0 0 0 0 0 0 0 0 3 0 0 1 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 5 0 9 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 3 5 0 0 1 0 4 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 5 0 0 4 0 0 0 0 10 8 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 4 0 0 7 10 0 10 0 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 0 8 3 9 6 7 0 0 0 0 2 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 0 0 8 7 10 0 0 0 0 0 0 6 0 0 0 5 0 0 0 0 0 0 0 0 0 0 10 0 \r\n"
                                +
                                "7 0 0 0 8 0 0 0 8 9 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 6 0 0 5 0 0 0 0 0 0 0 0 0 0 3 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 6 0 6 0 0 0 0 3 0 0 5 3 0 0 0 0 1 9 0 6 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 7 2 0 0 0 0 0 0 0 0 0 0 5 0 0 0 0 8 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 6 \r\n"
                                +
                                "0 9 0 0 0 0 0 0 0 0 0 3 0 9 2 0 0 0 4 0 2 9 2 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 0 0 \r\n"
                                +
                                "0 0 0 3 0 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 7 0 6 0 0 0 0 0 7 0 0 0 0 4 7 10 \r\n"
                                +
                                "1 0 0 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 8 0 0 0 0 0 0 0 0 3 9 2 \r\n"
                                +
                                "5 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 6 0 0 0 0 0 0 0 0 9 0 8 0 0 0 0 0 0 0 3 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 7 0 10 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 8 2 3 0 0 \r\n"
                                +
                                "0 0 0 0 0 5 0 0 6 0 0 3 0 0 0 0 0 8 0 0 6 0 0 0 8 0 0 5 0 0 0 0 8 0 0 0 0 0 0 0 5 0 1 \r\n"
                                +
                                "7 0 9 0 7 0 0 9 0 0 0 0 4 0 0 0 0 0 0 8 1 0 4 0 0 0 0 0 0 0 0 0 4 7 0 0 8 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 1 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 0 2 3 1 0 0 4 0 3 10 0 0 0 5 \r\n"
                                +
                                "0 0 4 0 0 0 0 0 0 4 4 0 0 0 8 0 4 0 2 0 8 0 0 0 0 0 0 0 9 0 0 0 0 5 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 8 0 7 0 0 0 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 6 0 0 0 0 1 0 0 0 0 4 3 \r\n"
                                +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 10 3 0 0 0 0 0 3 0 \r\n"
                                +
                                "0 0 2 0 0 0 0 0 8 5 0 0 0 0 0 0 0 0 0 0 0 0 4 8 0 0 0 0 0 1 0 5 0 0 0 0 2 3 9 0 0 0 0 \r\n"
                                +
                                "0 5 8 9 0 0 0 0 0 4 0 0 0 10 0 0 0 1 0 0 0 0 0 10 0 7 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "6 0 0 0 0 0 10 0 5 0 0 0 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 10 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
                                +
                                "0 0 0 0 0 0 9 0 0 0 0 0 0 2 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 2 4 0 \r\n"
                                +
                                "0 3 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 1 0 0 0 \r\n"
                                +
                                "0 0 0 9 0 0 0 0 4 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 0 5 0 0 0 9 2 0 \r\n"
                                +
                                "0 0 0 0 0 2 0 0 0 0 0 0 10 0 0 0 0 0 2 0 0 0 8 0 0 0 0 0 0 10 0 0 0 0 0 0 7 0 0 0 0 0 0 ";
 
 
}