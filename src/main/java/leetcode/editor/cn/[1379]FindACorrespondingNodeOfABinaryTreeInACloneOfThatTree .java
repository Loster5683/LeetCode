package leetcode.editor.cn;

import base.TreeNode;

class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }

        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null) {
            return right;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}