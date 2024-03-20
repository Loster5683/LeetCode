package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

class ImplementStackUsingQueues{
    public static void main(String[] args) {
        MyStack stack = new ImplementStackUsingQueues.MyStack();
        BaseTest.baseTest(stack, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.offer(x);
    }
    
    public int pop() {
        int v = queue1.poll();
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            Queue<Integer> tmp = queue2;
            queue2 = queue1;
            queue1 = tmp;
        }
        return v;
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}