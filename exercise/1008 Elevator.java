import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int now = 0;
        int upCount = 0;
        int downCount = 0;
        int stayCount = 0;
        in.nextInt();
        while (in.hasNextInt()) {
            int temp = in.nextInt();
            if (temp > now) {
                upCount += temp -now;
            } else {
                downCount += now - temp;
            }
            now = temp;
            stayCount ++;
        }
        System.out.print(upCount * 6 + downCount * 4 + stayCount * 5);
    }
}