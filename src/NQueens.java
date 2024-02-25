public class NQueens {
    private int[] queens;

    public NQueens(int N) {
        queens = new int[N];
    }

    public boolean canPlaceQueen(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (queens[i] == c || queens[i] - i == c - r || queens[i] + i == c + r) {
                return false;
            }
        }
        return true;
    }

    public void placeQueens(int r, int N) {
        for (int c = 0; c < N; c++) {
            if (canPlaceQueen(r, c)) {
                queens[r] = c;
                if (r == N - 1) {
                    printQueens(N);
                } else {
                    placeQueens(r + 1, N);
                }
            }
        }
    }

    public void printQueens(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    sb.append(" Q ");
                } else {
                    sb.append(" * ");
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int N = 4;
        NQueens nQueens = new NQueens(N);
        nQueens.placeQueens(0, N);
    }
}
