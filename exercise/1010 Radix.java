import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] n = new String[2];
        n[0] = in.next();
        n[1] = in.next();
        int tag = in.nextInt();
        int radixValue = in.nextInt();
        long value = calValue(n[tag -1], radixValue);

        int minRaxin = 1;
        for (int i = n[2 - tag].length() -1; i >= 0; i--) {
            char digit = n[2-tag].charAt(i);
            int digitValue = changeCharToInt(digit);
            if (digitValue > minRaxin) {
                minRaxin = digitValue;
            }
        }

        int highDigit = changeCharToInt(n[2 - tag].charAt(0));
        if (n[2 - tag].length() == 1) {
            if (highDigit != value) {
                System.out.print("Impossible");
                return;
            }
        }
        if (n[2 - tag].length() == 2) {
            if ((value - changeCharToInt(n[2 - tag].charAt(1))) <= 0 || (value - changeCharToInt(n[2 - tag].charAt(1))) % highDigit != 0) {
                System.out.print("Impossible");
                return;
            } else {
                System.out.print((value - changeCharToInt(n[2 - tag].charAt(1))) / highDigit);
                return;
            }
        }
        for (int i = minRaxin + 1;; i++) {
            int multi = 1;
            for (int j = n[2 - tag].length() - 2; j >= 0; j--) {
                multi *= i;
            }
            long highDigitValue = highDigit * multi;
            if (highDigitValue > value) {
                System.out.print("Impossible");
                return;
            }
            if (highDigitValue + multi > value) {
                if (calValue(n[2 -tag], i) == value) {
                    System.out.print(i);
                    return;
                }
            }
        }
    }

    private static long calValue(String n,int radix) {
        int multi = 1;
        long value =0;
        for (int i = n.length() -1; i >= 0; i--) {
            char digit = n.charAt(i);
            int digitValue;
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else {
                digitValue = digit - 'a' + 10;
            }
            if (i != n.length() -1) {
                multi *= radix;
            }
            value += digitValue * multi;
        }
        return value;
    }

    private static int  changeCharToInt(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else {
            return digit - 'a' + 10;
        }
    }
}