package chapter_1;
import javafx.scene.control.RadioMenuItem;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.sql.ClientInfoStatus;
import java.util.Random;

public class Num_1 {


    // 1.1.13
    // 矩阵转置
    public static int[][] arrayTranspose(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    // 1.1.14
    // 返回小于 log2(N) 的最大整数
    public static int lg(int N) {
        if (N <= 0) {
            return -1;
        }
        int k = 1;
        int count = 0;
        while (k <= N) {
            k *= 2;
            count++;
        }
        return count - 1;
    }

    // 1.1.15
    // 统计数组中每个数字的个数
    public static int[] histogram(int[] a, int M) {
        if (M <= 0) {
            return null;
        }
        int[] b = new int[M - 1];
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= M) {
                b[a[i]]++;
            }
        }
        return b;
    }

    // 1.1.20
    // 递归计算ln(N!)
    public static double ln(int N) {
        if (N == 1) {
            return 0;
        }
        return ln(N - 1) + Math.log(N);
    }

    // 1.1.28
    // 删除重复
    public static List<Integer> DeleteSameData(int[] a) {
        List<Integer> list = new ArrayList<Integer>();
        int temp = a[0];
        list.add(temp);
        for (int i = 0; i < a.length; i++) {
            if (temp != a[i]) {
                temp = a[i];
                list.add(a[i]);
            }
        }
        return list;
    }

    // 1.1.35
    // 计算骰子的概率
    public static double[] ProbMatrix() {
        double[] matrix = new double[13];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i + j + 2]++;
            }
        }
        for (int i = 0;i < matrix.length; i++) {
            matrix[i] /= 36;
        }
        return matrix;
    }
    public static double Probability(int N) {
        double[] matrix = ProbMatrix();
        double[] num = new double[matrix.length];
        double[] sub = new double[num.length];
        Random r = new Random();
        int count = N;
        int row, col;
        while (count > 0) {
            row = r.nextInt(6) + 1;
            col = r.nextInt(6) + 1;
            num[row + col] += 1;
            count--;
        }
        double max = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] /= N;
            sub[i] = Math.abs(num[i] - matrix[i]);
            if (sub[i] > max) {
                max = sub[i];
            }
//            System.out.println("骰子点数总和为 "+ i + " 时的概率为 : " + matrix[i] + " 模拟概率为 : " + num[i] + " 差值为 ：" + (sub[i]));
        }
        return max;
    }
    public static int getMax() {
        int maxM = 1;
        int count;
        double sub;
        System.out.println("--------------------");
        while (true) {
            count = 100;
            while (count > 0) {
                count--;
                System.out.println("  count : " + count + "   maxM : " + maxM);
                sub = Probability(maxM);
                if (sub > 0.001) {
                    maxM += 1000;
                    System.out.println("     sub : " + sub + "  maxM值为 : " + maxM);
                    break;
                }
            }
            if (count <= 0) {
                break;
            }
        }
        System.out.println("maxM 值为 ： " + maxM);
        return maxM;
    }




    public static void main(String[] args){

//        int[][] a = {{1,2,3},{2,3,4}};
//        int[][] b = arrayTranspose(a);
//        System.out.println(b[2][0]);


//        int N = 66;
//        int k = lg(N);
//        System.out.println(k);


//        int[] a = {1,3,5,7,5,3,4,2,3,5,6,3,32};
//        int[] b = histogram(a, 0);
//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }


//        int N = 10;
//        double x = ln(N);
//        System.out.println(x);


//        int[] a = {1,1,2,2,2,3,3,3,3,3,3,3,3};
//        List<Integer> list = DeleteSameData(a);
//        System.out.println(list);


        getMax();


    }
}
