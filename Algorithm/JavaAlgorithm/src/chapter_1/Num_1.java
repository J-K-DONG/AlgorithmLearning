package chapter_1;

public class Num_1 {


    // 1.1.13
    public static int[][] arrayTranspose(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }



    public static void main(String[] args){

        int[][] a = {{1,2,3},{2,3,4}};

        int[][] b = arrayTranspose(a);
        System.out.println(b[2][0]);
    }
}
