import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            char a = n.charAt(i);
            sum += a - '0';
        }
        Map<Integer,String> intToStringMap = new HashMap<>();
        intToStringMap.put(0, "zero");
        intToStringMap.put(1, "one");
        intToStringMap.put(2, "two");
        intToStringMap.put(3, "three");
        intToStringMap.put(4, "four");
        intToStringMap.put(5, "five");
        intToStringMap.put(6, "six");
        intToStringMap.put(7, "seven");
        intToStringMap.put(8, "eight");
        intToStringMap.put(9, "nine");
        List<Integer> numberList = new ArrayList<>();
        while (true) {
            int lastNumber = sum % 10;
            numberList.add(lastNumber);
            sum = sum / 10;
            if (sum == 0) {
                break;
            }
        }
        for (int i = numberList.size() -1; i >=0; i--) {
            if (i == numberList.size() -1) {
                System.out.print(intToStringMap.get(numberList.get(i)));
            } else {
                System.out.print(" " + intToStringMap.get(numberList.get(i)));
            }
        }
    }
}