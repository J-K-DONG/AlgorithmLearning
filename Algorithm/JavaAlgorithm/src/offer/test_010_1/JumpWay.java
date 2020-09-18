/*
面试题10- II. 青蛙跳台阶问题

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：

0 <= n <= 100
思路和代码：

简单的动态规划，跳到0或1级有1种方法，之后跳到i的方法数量=跳到i-1的方法数量+跳到i-2的方法数量（因为每次可以跳1或2级）。

由于每次结果要取模所以要mod1000000007。
*/



public class JumpWay {
    private int jumpDistance1;
    private int jumpDistance2;
    private int step;

    public JumpWay(int jumpDistance1, int jumpDistance2, int step) {
        this.jumpDistance1 = jumpDistance1;
        this.jumpDistance2 = jumpDistance2;
        this.step = step;
    }

    public int jumpWayCount() {
        int mod = 1000000007;
        int[] jump = new int[this.step + 1];
        jump[0] = 1;
        jump[1] = 1;  // 第一层 一种
        for (int i = 2; i < this.step + 1; i++) {
            jump[i] = (jump[i - 1] % mod + jump[i - 2] % mod) % mod;
        }
        return jump[this.step];
    }



    public static void main(String[] args) {
        JumpWay jump = new JumpWay(1, 2, 100);
        int way = jump.jumpWayCount();
        System.out.println(way);
    }
}
