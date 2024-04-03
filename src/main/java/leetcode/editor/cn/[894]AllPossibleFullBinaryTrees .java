package leetcode.editor.cn;

import base.ListNode;
import base.TreeNode;

import java.util.*;

class AllPossibleFullBinaryTrees{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "allPossibleFBT", "7");
    }
static
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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }
        Map<Integer, List<TreeNode>> mem = new HashMap<>();
        mem.put(1, Collections.singletonList(new TreeNode(0)));
        for (int i = 3; i <= n; i = i + 2) {
            mem.putIfAbsent(i, new ArrayList<>());
            int z = (i - 1) / 2;
            for (int j = 1; j < 2 * z; j = j + 2) {
                if (mem.containsKey(j) && mem.containsKey(2 * z - j)) {
                    for (TreeNode left : mem.get(j)) {
                        for (TreeNode right : mem.get(2 * z - j)) {
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            mem.get(i).add(node);
                        }
                    }
                }
            }
        }
        return mem.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}