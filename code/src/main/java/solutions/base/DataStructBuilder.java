package solutions.base;


import java.util.Arrays;
import java.util.List;
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
     * 初始化数组
     */
    public static int[] initIntArray(String value) {
        value = value.replace('[', ' ');
        value = value.replace(']', ' ');
        return Arrays.stream(value.trim().split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
