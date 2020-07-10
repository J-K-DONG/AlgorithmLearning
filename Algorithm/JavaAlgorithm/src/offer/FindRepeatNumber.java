/**
面试题03. 数组中重复的数字

找出数组中重复的数字。 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
**/


package offer;
import java.util.Arrays;

public class FindRepeatNumber {
    public static int findRepeatNumber(int[] array){
        for(int i = 0; i < array.length; i++){
            if (array[i] >= array.length) {
                return -2;
            }
            if(i != array[i]){ // 判断当前下标和元素是否相等
                int index = array[i];
                if(index == array[index]) //判断是否有两个元素相等
                    return index;
                // change two item
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array = {4, 6, 1, 0, 2, 5, 3};
        int res = findRepeatNumber(array);
        if (res == -2) {
            System.out.println("元素超出范围");
        }else if (res == -1) {
            System.out.println("没有相同的元素 ");
        }else if (res >= 0) {
            System.out.println(res);
        }
    }
}
