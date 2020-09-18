package learning;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.Arrays;

        public class takeHomeQuestions {

            // 计算页数中 0-9 各个数字出现的个数
            public static int countingNumber1(int n){
                if (n <= 0){
                    System.out.println("error");
                    return 0;
                }
                if (n == 1) return 1;
                else return  10 * countingNumber1(n - 1) + (int)Math.pow(10, n - 1);
            }
            public static int countingNumber2(int n){
                if (n <= 0) return 0;
                else return  n * (int)Math.pow(10, n - 1);
            }

            public static void statistic(int num) {
                // 获取整数m的位数
                int[] result = new int[10];
                int length = String.valueOf(num).length();
                // 从高位向低位进行统计，再减去多余的0的个数
                for (int i = length; i > 0; i--) {
                    // 计算出第i位(从低位向高位)对应的数bitnum
                    int a = (int)Math.pow(10, i);
                    int b = (int)Math.pow(10, i - 1);
                    int bitnum = (num % a) / b;
                    int j;
                    // 计算比bitnum小的数字出现的次数
                    for (j = 0; j < bitnum; j++) {
                        // 计算比bitnum小的数字在第i位出现的次数
                        result[j] += b;
                        // 当第i位为比bitnum小的数字时，计算所有数字在后面i-1位中出现的次数
                        for (int k = 0; k <= 9; k++) {
                            // result[k] += countingNumber1(i - 1);
                            result[k] += countingNumber2(i - 1);
                        }
                    }
                    // 计算bitnum在第i位出现的次数
                    result[j] += num % b + 1;
                    // 最后对于数字0需减去多余的0的个数
                    result[0] -= b;
                }
                for (int k = 0;k < 10; k++){
                    System.out.println("数字 " + k + "出现的次数为 ：" + result[k]);
                }
            }


            public static void swap(String[] array, int i, int j){
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

            public static void stringProcess(String[] array){
                int i = array.length - 1;  // 从后向前遍历的位置
                int j = i;  // 遍历中🉑交换的位置
                while(i >= 0) {
                    if (array[j].equals("*")) {
                        if (!array[i].equals("*")) {
                            swap(array, i, j);
                            j--;
                        }
                    }
                    else {
                        j--;
                    }
                    i--;
                }
                for (int k = 0; k < array.length; k++){
                    System.out.print(array[k] + " ");
                }
                System.out.println('\n' +"字符串中包含" + (j + 1) + "个 * 字符");
            }

            //字符串中最长子串
            public static String longestDupSubstring(String S) {
                int len = S.length();
                String result = "";
                int maxLen = 0;
                if(len <= 1)
                    return "";
                String[] strs = new String[len];  // 存放S的后缀字符串
                for(int i = 0; i < len; i++){
                    strs[i] = S.substring(i, len);
                }
                Arrays.sort(strs);  // 排序
                for(int i = 0; i < len-1; i++){  // 两个相邻字符串的最长公共前缀
                    int tmp = lenTwoStr(strs[i], strs[i+1]);
                    if(tmp > maxLen){
                        maxLen = tmp;
                        result = strs[i].substring(0,maxLen);
                    }
                }
                return result;
            }
            // 两个后缀子串的前缀最长公共子串
            public static int lenTwoStr(String str1, String str2){
                if(str1.length() == 0 || str2.length() == 0)
                    return 0;
                int i = 0;
                while(i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i))
                    i++;
                return i;
            }



            public static void main(String[] args){
//                int pages = 10;
//                statistic(pages);

//                char[] array = {'a', 'b', '*', '*', 'c', 'd', '*', '*', 'e', '*', '1', '2'};
//                System.out.println("请输入字符串（不包含空格）：");
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
//                String[] array = str.split("");
//                stringProcess(array);

//                String res = longestDupSubstring("abcdefabcdef");
//                System.out.println(res);

                String[] strArray = new String[]{"Zbba", "a", "Zba"};
                Arrays.sort(strArray);
                System.out.println(Arrays.toString(strArray));

            }

}
