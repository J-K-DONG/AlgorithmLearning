package datastructures;

public class array {

    public static int getMaxValue(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public static int getMinValue(int[] a){
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static int getAverage(int[] a){
        int N = a.length;
        int sum = 0;
        for (int i = 0; i < N; i++){
            sum += a[i];
        }
        int average = sum / N;
        return average;
    }

    public static int[] copyArray(int[] a){
        int N = a.length;
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        return b;
    }


    public static int[] overturnArray(int[] a){
        int N = a.length;
        int temp = 0;
        for (int i = 0; i < N / 2; i++){
            temp = a[i];
            a[i] = a[N - i - 1];
            a[N - i - 1] = temp;
        }
        return a;
    }

    // 矩阵相乘
    public static int[][] matrixMultiply(int[][] a, int[][] b){
        if (a.length != b[0].length || a[0].length != b.length){
            System.out.println("矩阵大小不匹配");
            return a;
        }
        int M = a.length; // 行
        int N = b[0].length;
        int[][] c = new int[M][N];
        for(int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                for (int p = 0; p < M; p++){
                    c[i][j] = a[i][p] * b[p][j];
                }
            }
        }
        return c;
    }


    public static void main(String args[]){

        int[][] a = {{1,1,1,1},{2,2,2,2},{3,3,3,3}};
        int[][] b = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
        int[][] c = matrixMultiply(a, b);

        System.out.println(a[0].length);
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[0].length; j++){
                System.out.println(c[i][j]);
            }
        }
        System.out.println("hello world!");
    }
}
