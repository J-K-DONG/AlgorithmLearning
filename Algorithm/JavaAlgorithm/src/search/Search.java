package search;
import java.util.Arrays;

public class Search {

    public static int BinarySearch_1(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int count = 0;
        while (true) {
            count++;
            if (lo > hi) {
                break;
            }
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                System.out.println("循环了 " + count + " 次");
                return mid;
            }
        }
        return -1;
    }

    // 二分查找的递归方法
    public static int BinarySearch_2(int key, int[] a) {
        int index = BinarySearchRank(key, a, 0, a.length - 1);
        return index;
    }

    public static int BinarySearchRank(int key, int[] a, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        int index = -1;
        if (key < a[mid]) {
            index = BinarySearchRank(key, a, begin, mid - 1);
        }
        else if (key > a[mid]) {
            index = BinarySearchRank(key, a, mid + 1, end);
        }
        else {
            index = mid;
        }
        return index;
    }



    public static void main(String[] args) {
        int[] whilelist = {2,5,8,13,16,17,21,34,66};

        Arrays.sort(whilelist);
        int data = BinarySearch_2(17, whilelist);
        System.out.println(data);
    }
}
