import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nodeLevel = new int[101];
        Map<Integer, List<Integer>> nodeTochildren = new HashMap<>();
        nodeLevel[1] = 1;
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int id = in.nextInt();
            int k = in.nextInt();
            List<Integer> childList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int idChild = in.nextInt();
                childList.add(idChild);
            }
            nodeTochildren.put(id, childList);
        }
        List<Integer> levelNodes = new ArrayList<>();
        levelNodes.add(1);
        boolean first = true;
        //注意！输入ID是乱序的，有时候ID的上级还没找到父节点，不能一级一级加.
        while (!levelNodes.isEmpty()) {
            List<Integer> childLevelNodes = new ArrayList<>();
            int leafLevelNum = 0;
            for (Integer node:levelNodes) {
                if (nodeTochildren.get(node) != null) {
                    childLevelNodes.addAll(nodeTochildren.get(node));
                } else {
                    leafLevelNum ++;
                }
            }
            levelNodes = childLevelNodes;
            if (first) {
                System.out.print(leafLevelNum);
                first = false;
            } else {
                System.out.print(" " + leafLevelNum);
            }
        }
    }
}