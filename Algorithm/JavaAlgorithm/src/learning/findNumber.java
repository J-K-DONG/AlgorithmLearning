package learning;

public class findNumber {

    // G20198828-董晋坤
    public static int findNNumber(int[] a, int n) {
        int[] bin = new int[32];  // 申请 32 个存储空间
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 32; j++) {
                bin[j] += ((a[i] >> j) & 1);  // 对每个数的二进制上的每一位进行求和
            }
        }
        int result = 0;
        for (int k = 0; k < 32; k++)
            if (bin[k] % n != 0)  // 要找的数字在这一位上为 1
                result += (1 << k);
        return result;
    }

    public static int findNNumber_2(int[] array, int n, int m) {
        int[] times = new int[n];
        for (int k = 0; k < n; k++){
            times[k] = 0;
        }
        int sum = 0;
        int[] resId = new int[n];
        for(int i = 0; i < array.length; ++i) {
            boolean flag_1 = false, flag_2 = false;
            sum += array[i];
            for (int j = 0; j < n; j++){
                if (array[i] == resId[j]){
                    ++times[j];
                    flag_1 = true;
                    break;
                }
            }
            if (!flag_1) {
                for (int k = 0; k < n; k++) {
                    if (times[k] == 0) {
                        resId[k] = array[i];
                        ++times[k];
                        flag_2 = true;
                        break;
                    }
                }

                if (!flag_2) {
                    for (int k = 0; k < n; k++) {
                        --times[k];
                    }
                }
            }
        }
//        for (int )
//        int res = sum - n * ()

        return 0;
    }

    public static void main(String[] args){
        int[] a = {5, 11, 5, 2, 11, 5, 2, 11, 2, 3, 3, 3, 6};
        int n = 3, m = 1;
        int res = findNNumber(a, n);
//        int res = 10;
        System.out.println(res);
    }
}
