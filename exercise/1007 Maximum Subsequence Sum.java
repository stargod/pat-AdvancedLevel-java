import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = in.nextInt();
        }
        int startIndex = 0;
        int tempSum = 0;
        int maxSum = nums[0];
        int maxSumStartIndex = 0;
        int maxSumEndIndex = 0;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxSumStartIndex = startIndex;
                maxSumEndIndex = i;
            } else if (tempSum < 0){
                tempSum = 0;
                startIndex = i + 1;
            }
        }
        //对于最后一组数据跑的太慢个，刚刚好200ms
        if (maxSum < 0) {
            System.out.print(0 + " " + nums[0] + " " + nums[k-1]);
        } else {
            System.out.print(maxSum + " " + nums[maxSumStartIndex] + " " + nums[maxSumEndIndex]);
        }
    }
}