package solutions.base;


import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
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
        return Arrays.stream(value.trim().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static String[] initStringArray(String nodes) {
        nodes = nodes.replace("[", "").replace("]", "").replace("\"", "");
        nodes = nodes.replace(']', ' ');
        nodes = nodes.replace('\"', ' ');
        return nodes.trim().split(",");
    }
}
