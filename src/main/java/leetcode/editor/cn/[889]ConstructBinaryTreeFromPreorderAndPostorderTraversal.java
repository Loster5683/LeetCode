package leetcode.editor.cn;

import base.TreeNode;

class ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
       BaseTest.baseTest(solution, "");
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePostTmp(preorder, postorder, 0, preorder.length, 0, postorder.length);
    }

    private TreeNode constructFromPrePostTmp(int[] preorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1) {
            return null;
        }
        int head = preorder[s1];
        TreeNode res = new TreeNode(head);
        if (e1 - s1 == 1) {
            return res;
        }

        int i = s2;
        for (; i < e2; i++) {
            if (postorder[i] == preorder[s1 + 1]) {
                break;
            }
        }
        int len = i - s2 + 1;
        res.left = constructFromPrePostTmp(preorder,postorder, s1 + 1, s1 + 1 + len, s2, s2 + len);
        res.right = constructFromPrePostTmp(preorder,postorder, s1 + len + 1, e1, s2 + len, e2 - 1);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}