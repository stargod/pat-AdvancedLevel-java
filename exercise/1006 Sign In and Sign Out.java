import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String[] name = new String[m];
        String[] inTime = new String[m];
        String[] outTime = new String[m];
        for (int i = 0;i < m; i++) {
            name[i] = in.next();
            inTime[i] = in.next();
            outTime[i] = in.next();
        }
        int first = 0;
        String firstTime = inTime[0];
        int last = 0;
        String lastTime = outTime[0];
        for (int i = 1;i < m; i++) {
            if (inTime[i].compareTo(firstTime) < 0) {
                firstTime = inTime[i];
                first = i;
            }
            if (outTime[i].compareTo(lastTime) > 0) {
                lastTime = outTime[i];
                last = i;
            }
        }
        System.out.print(name[first] +" " + name[last]);
    }
}