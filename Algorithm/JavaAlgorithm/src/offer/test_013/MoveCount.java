package offer.test_013;

public class MoveCount {
    private int col;
    private int row;
    private int k;
    boolean[][] flag;

    public int moveCount(int col, int row, int k) {
        if (col <= 0 || row <= 0) {
            return 0;
        } else if (col > 100 || row > 100) {
            System.out.println("index out of range");
            return -1;
        }

        this.col = col;
        this.row = row;
        this.k = k;
        flag = new boolean[col][row];
        return countForStep(0, 0);
    }

    public int countForStep(int i, int j) {
        if (i < 0 || i > col - 1 || j < 0 || j > row - 1 || flag[i][j] || (i % 10 + i / 10 + j % 10 + j / 10) > k) {
            return 0;
        }
        flag[i][j] = true;
        return 1 + countForStep(i - 1, j) + countForStep(i, j + 1) + countForStep(i + 1, j) + countForStep(i, j - 1);
    }


    public static void main(String[] args) {
        MoveCount mc = new MoveCount();
        int count = mc.moveCount(3, 1, 3);
        System.out.println(count);
    }

}
