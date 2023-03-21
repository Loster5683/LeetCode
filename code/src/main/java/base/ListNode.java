package base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toListString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        ListNode nextNode = this.next;
        stringBuilder.append(this.val);

        while (nextNode != null) {
            stringBuilder.append(',');
            stringBuilder.append(nextNode.val);
            nextNode = nextNode.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "solutions.base.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
