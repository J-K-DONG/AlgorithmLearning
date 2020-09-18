package learning;

public class NumDividEqual {
    public char[] A;
    public char[] B;
    int n;
    /**
     * 将数组均分为两份，分别存入数组A和数组B中；
     * @param input
     */
    public NumDividEqual(char[] input){
        n = input.length/2;
        A = new char[n];
        B = new char[n];
        for(int i = 0; i<n;i++){
            A[i] = input[i];
        }
        for(int i = 0; i<n;i++){
            B[i] = input[i + n];
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
