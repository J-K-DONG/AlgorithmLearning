package offer.test_012;
/*
面试题12. 矩阵中的路径

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，、
每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"], ["s","f","c","s"], ["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
思路和代码：

使用深度优先搜索回溯，从全部字符以头开始遍历，如果寻找到了就直接返回true，否则继续以下一个字符为头重新开始。

k代表已经成功匹配的字符数量，初始为0，每匹配一个加1，当达到目标长度时返回true。

每次进行下一层搜索时将当前字符设为一个非字母值，这样可以防止重复遍历。

*/



public class FindWordPath{

    private int[][] flag;
    private String[][] matrix;
    private int high;
    private int width;
    private int pathCount;

    public FindWordPath(String[][] matrix) {
        this.matrix = matrix;
        this.high = this.matrix.length;
        this.width = this.matrix[0].length;
        this.flag = new int[this.high][this.width];
        for (int i = 0; i < this.high; i++) {
            for (int j = 0; j < this.width; j++) {
                this.flag[i][j] = 0;
            }
        }
        this.pathCount = 0;
    }

    public void printMatrix() {
        for (int i = 0; i < this.high; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void printFlag() {
        for (int i = 0; i < this.high; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.flag[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void findWordPath(String str) {

        for (int i = 0; i < this.high; i++) {
            for (int j = 0; j < this.width; j++) {
                if (matrix[i][j].equals(String.valueOf(str.charAt(0)))) {
                    findNextWord(str, 1, i, j, 0);
                }
            }
        }
        if (this.pathCount == 0) {
            System.out.println("null");
        }else {
            System.out.println("总共找到 " + this.pathCount + " 路径");
        }
    }

    public boolean findNextWord(String str, int num, int row, int col, int pre) {

        this.flag[row][col] = num;
        if (num == str.length()) {
            // 找到一条路径
            System.out.println("找到第 " + ++this.pathCount + " 条路径 ：");
            printFlag();
            this.flag[row][col] = 0;
            System.out.println();
            return true;
        }

        String currentStr = String.valueOf(str.charAt(num++));
        // 找下一个
        // 顺时针从上开始 如果有标记 说明 此格不通 上1 右2 下3 左4
        boolean flag = false;
        if (pre != 1 && row - 1 >= 0 && this.matrix[row - 1][col].equals(currentStr)) {  // 来的方向不是上
            flag &= findNextWord(str, num, row - 1, col, 3);
        }
        if (pre != 2 && col + 1 < this.width && this.matrix[row][col + 1].equals(currentStr)) {  // 来的方向不是右
            flag &= findNextWord(str, num, row, col + 1, 4);
        }
        if (pre != 3 && row + 1 < this.high && this.matrix[row + 1][col].equals(currentStr)) {  // 来的方向不是下
            flag &= findNextWord(str, num, row + 1, col, 1);
        }
        if (pre != 4 && col - 1 >= 0 && this.matrix[row][col - 1].equals(currentStr)) {  // 来的方向不是左
            flag &= findNextWord(str, num, row, col - 1, 2);
        }
        this.flag[row][col] = 0;
        if (flag) {
            return true;
        } else {
            // 没找到
            return false;
        }

    }

    public static void main(String[] args) {
        String[][] matrix = new String[][]{{"A", "B", "C", "C"},
                                            {"S", "A", "C", "E"},
                                            {"A", "D", "E", "D"}};
        String str = "ABCCE";
        System.out.println("str : " + str);
        FindWordPath fi = new FindWordPath(matrix);
        fi.printMatrix();
        System.out.println();
        fi.findWordPath(str);

    }

}
