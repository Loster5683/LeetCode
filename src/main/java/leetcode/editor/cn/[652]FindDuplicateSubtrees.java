package leetcode.editor.cn;

import base.TreeNode;

import java.util.*;

class FindDuplicateSubtrees{
    public static void main(String[] args) {
       Solution solution = new FindDuplicateSubtrees().new Solution();
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

    public Map<String, TreeNode> map = new HashMap<>();
    public Map<String, TreeNode> res = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return new ArrayList<>(res.values());
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append('%').append(serialize(root.left)).append('%').append(serialize(root.right));
        if (!map.containsKey(sb.toString())) {
            map.put(sb.toString(), root);
        } else {
            res.put(sb.toString(), root);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}