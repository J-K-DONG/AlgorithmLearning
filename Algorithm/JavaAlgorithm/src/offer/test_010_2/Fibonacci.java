/*
面试题10- I. 斐波那契数列

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
思路和代码：

和上一题类似，几乎没有变化，只需要修改n的初始值为0。

*/

public class Fibonacci {

    public int getValue(int n) {
        if (n < 0) {
            return -1;
        }
        int mod = 1000000007;
        int[] fi = new int[n];
        fi[0] = 0;
        fi[1] = 1;
        for (int i = 2; i < n; i++) {
            fi[i] = (fi[i - 1] % mod + fi[i - 2] % mod) % mod;
        }
        return fi[n - 1];
    }

    public static void main(String[] args) {
        Fibonacci fi = new Fibonacci();
        int res = fi.getValue(100);
        System.out.println(res);
    }
}
