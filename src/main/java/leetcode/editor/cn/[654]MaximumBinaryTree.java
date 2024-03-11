package leetcode.editor.cn;

import base.ListNode;
import base.TreeNode;

import java.util.*;

class MaximumBinaryTree{
    public static void main(String[] args) {
       Solution solution = new MaximumBinaryTree().new Solution();
       BaseTest.baseTest(solution, "constructMaximumBinaryTree", "[3,2,1,6,0,5]", "[3,2,1]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums);
    }

    //递归做法(O(n2), O(n))
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = 0;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums, start, index - 1);
        node.right = constructMaximumBinaryTree(nums, index + 1, end);
        return node;
    }

    //单调栈
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!deque.isEmpty() && node.val > deque.peekFirst().val) {
                node.left = deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                deque.peek().right = node;
            }
            deque.push(node);
        }
        return deque.peekLast();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}