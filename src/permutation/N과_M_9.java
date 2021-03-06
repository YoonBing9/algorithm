package permutation;

import java.util.*;

/**
 * 백준 15663
 * 순열
 */
public class N과_M_9 {
    private static int N;
    private static int[] array;
    private static boolean[] isUsed;
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        array = new int[N+1];
        isUsed = new boolean[N+1];
        String[] nums = sc.nextLine().split(" ");
        for(int i=1; i<=N; i++) {
            array[i] = Integer.parseInt(nums[i-1]);
        }
        Arrays.sort(array);
        printPermutation(M, "");
        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void printPermutation(int M, String str) {
        if(M == 0) {
            set.add(str.trim());
            return;
        }

        for(int i=1; i<array.length; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                printPermutation(M - 1, str + " " + array[i]);
                isUsed[i] = false;
            }
        }
    }
}
