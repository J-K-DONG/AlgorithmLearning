package com.search;
import java.util.Arrays;

public class Search {

    public static int Rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (true)
        {
            if (lo > hi) {
                break;
            }
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                hi = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whilelist = {3,8,6,1,1,8,6,3,8};

        Arrays.sort(whilelist);
        int data = Rank(6, whilelist);
        System.out.println(data);
    }
}
