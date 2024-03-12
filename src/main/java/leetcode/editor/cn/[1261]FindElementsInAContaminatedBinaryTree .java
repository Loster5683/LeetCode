package leetcode.editor.cn;

import base.DataStructBuilder;
import base.TreeNode;

import java.util.HashSet;
import java.util.Set;

class FindElementsInAContaminatedBinaryTree{
    public static void main(String[] args) {
        FindElements solution = new FindElementsInAContaminatedBinaryTree().new FindElements(DataStructBuilder.initNodeTree("[[-1,null,-1]]"));
        BaseTest.baseTest(solution, "find", "1");
        System.out.println(solution.find(1));
        System.out.println(solution.find(2));
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
    class FindElements {

        Set<Integer> values = new HashSet<>();
        public FindElements(TreeNode root) {
            cicle(0, root);
        }

        private void cicle(int value, TreeNode root) {
            if (root == null) {
                return;
            }
            root.val = value;
            values.add(value);
            cicle(value * 2 + 1, root.left);
            cicle(value * 2 + 2, root.right);
        }

        public boolean find(int target) {
            return values.contains(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}