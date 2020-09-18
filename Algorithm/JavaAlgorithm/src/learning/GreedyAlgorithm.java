package learning;
import java.util.*;

public class GreedyAlgorithm {

    public static void starCraft(int farmers, int work, int initialRes, int days, int value){
        int initFarmer = farmers;
        int[] res = new int[days + 1];
        res[0] = initialRes;
        res[days - 1] = farmers * work * (days - 1) + initialRes;  // 不换取农民时 第九天的资源数
        System.out.println(res[days - 1]);
        int j = 0;  //天数
        int max = 0;
        int result;
        int boundary = 0;  // 计算临界天数
        while(boundary * work < value) {
            boundary++;
        }
//        while(res[days - 1] >= 50){  // 判断第9天的时候 资源数是否可以换取一个农民
        while(j <= (days - boundary)){
            if (res[j] >= value){
                res[j] -= value;
                farmers++;
//                res[days - 1] = (days - j - 1) * farmers * work + res[j];  // 算第九天的资源数
                result = res[days - 1] + farmers * work;  // 算第十天的资源数
                max = Math.max(result, max);
                System.out.println("在第 " + j + " 天中增加第 " + (farmers - initFarmer) + " 个农民的最终资源数为； " + result);
            }
            else {  // 当天的资源数不够换取农民 天数加一
                j++;
                res[j] = res[j - 1] + farmers * work; // 计算新的一天的资源数
            }
        }
        System.out.println("最终结果： " + max);
    }


    // 回文串
    public static int getResult(String str){
        StringBuilder sb  = new StringBuilder(str);
        String newStr = sb.reverse().toString();  // 求得翻转得字符串
        char[] c1 = str.toCharArray();
        char[] c2 = newStr.toCharArray();
        int n = str.length();
        int[][] dp = new int[n+1][n+1];  // 动态规划的备忘录
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){  // 遍历每一个字符
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;  // 如果字符相同 就在前面的基础上加上当前这一位
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);  // 不相同时 比较两个字符串都少一位时的情况
                }
            }
        }
        return dp[n][n];
    }
    public static void main(String[] args){

        starCraft(5, 8, 50, 10, 50);

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(str.length()-getResult(str));
        }
    }
}
