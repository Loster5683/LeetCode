package base;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataStructBuilder {

    /**
     * 初始化链表
     */
    public static ListNode initNodeList(String nodes) {

        nodes = nodes.replace('[', ' ');
        nodes = nodes.replace(']', ' ');
        List<Integer> nodeValue = Arrays.stream(nodes.trim().split(",")).map(Integer::parseInt).collect(Collectors.toList());

        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < nodeValue.size(); i++) {
            if (head == null) {
                head = new ListNode(nodeValue.get(0));
                tail = head;
            } else {
                tail.next = new ListNode(nodeValue.get(i), null);
                tail = tail.next;
            }
        }
        return head;
    }

    /**
     * 初始化二叉树
     */
    public static TreeNode initNodeTree(String nodes) {

        nodes = nodes.replace('[', ' ');
        nodes = nodes.replace(']', ' ');
        List<String> nodeValue = Arrays.stream(nodes.trim().split(",")).collect(Collectors.toList());
        return getTreeNodeByStr(1, nodeValue);
    }

    private static TreeNode getTreeNodeByStr(int i, List<String> nodeValues) {
        if (i > nodeValues.size() || nodeValues.get(i - 1).equals("null")) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(nodeValues.get(i - 1)));
            int leftIndex = i << 1;
            node.left = getTreeNodeByStr(leftIndex, nodeValues);
            node.right = getTreeNodeByStr(leftIndex + 1, nodeValues);
            return node;
        }
    }

    /**
     * 初始化数组
     */
    public static int[] initIntArray(String value) {
        value = value.replace("[", "").replace("]", "");
        if (value.length() == 0) {
            return new int[0];
        }
        return Arrays.stream(value.trim().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static String[] initStringArray(String nodes) {
        nodes = nodes.replace("[", "").replace("]", "").replace("\"", "");
        return nodes.trim().split(",");
    }

    public static List<?> initArray(String value, Function<String, ?> mapper) {
        return Arrays.stream(value.trim().split(",")).map(mapper).collect(Collectors.toList());
    }

    public static char[] initCharArray(String value) {
        value = value.replace("[", "").replace("]", "").replace("\"", "");
        List<Character> list = (List<Character>) initArray(value, e -> e.charAt(0));
        char[] result = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static char[][] init2DCharArray(String value) {
        value = value.replace("[[", "").replace("]]", "");
        String[] strings = value.split("],\\[");
        int rows = strings.length;
        int cols = strings[0].split(",").length;
        char[][] result = new char[rows][cols];
        for (int i = 0; i < strings.length; i++) {
            char[] t = initCharArray(strings[i]);
            result[i] = t;
        }
        return result;
    }

    public static int[][] init2DIntArray(String value) {

        value = value.substring(1, value.length() - 1);
        if (value.length() == 0) {
            return new int[0][0];
        }
        String[] strings = value.split("],\\[");
        int rows = strings.length;
        int cols = strings[0].split(",").length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < strings.length; i++) {
            int[] t = initIntArray(strings[i]);
            result[i] = t;
        }
        return result;
    }
}
