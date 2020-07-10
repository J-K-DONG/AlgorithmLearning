/**
面试题04. 二维数组中的查找

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

思路和代码：

我们分析该二维数组的特点，左到右递增，上到下递增，因此可以从右上角开始寻找。

如果比目标值大，就往左边找，如果比目标值小，就往下边找。
**/

package offer;

public class FindNumberIn2DArray{
    public static int findNumberIn2DArray(int[][] array, int num){
        if (array.length <= 0 || array[0].length <= 0) {
            return -1;
        }
        // 从右上角开始找
        int i = 0;
        int j = array[0].length - 1;
        while(i < array.length && j >= 0){
            if (num > array[i][j]) {
                i++;
            }else if (num < array[i][j]) {
                j--;
            }else {
                System.out.println("找到元素 " + num + " 位置为： " + i + " 行 " + j + " 列");
                return 1;
            }
        }
        System.out.println("未找到该数字");
        System.out.println("当前位置为： " + i + " 行 " + j + " 列");
        return 0;
    }

    public static void main(String[] args) {
        int[][] array = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}};
          int num = 25;
        int res = findNumberIn2DArray(array, num);
        //System.out.println(res);
    }
}
