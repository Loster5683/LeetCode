package base;

public class Node {
    public Node next;
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(Node next, int val, Node left, Node right) {
        this.next = next;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
