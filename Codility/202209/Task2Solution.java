package algo202209;

import java.io.*;
import java.util.*;
public class Task2Solution {
    public static void main(String[] args) throws Exception{
        int[] A = {};
        int k = 3;

        if(!Arrays.equals(A, new int [] {})) {
            for (int i = 0; i < k; i++) {

                int tmp = A[A.length - 1];

                for (int j = A.length - 1; j >= 1; j--) {
                    A[j] = A[j - 1];
                }
                A[0] = tmp;
            }
        }
        System.out.println(Arrays.toString(A));
    }
}
