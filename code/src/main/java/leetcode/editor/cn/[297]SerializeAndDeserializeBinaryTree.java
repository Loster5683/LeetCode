package leetcode.editor.cn;

import base.DataStructBuilder;
import base.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
       Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();
       String codeStr = codec.serialize3(DataStructBuilder.initNodeTree("[1,2,3,null,null,4,5]"));
       TreeNode treeNode = codec.deserialize3(codeStr);
        System.out.println(1);
    }
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
public class Codec {

    /**
     * dfs解法
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append('%').append(serialize(root.left)).append('%').append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("%")));
        return dfs(queue);
    }
    private TreeNode dfs(Queue<String> queue) {
        String nodeStr = queue.poll();
        if (nodeStr.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeStr));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }

    /**
     * bfs
     */
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        sb.append(root.val).append(',');
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                String left = tmp.left == null ? "null" : String.valueOf(tmp.left.val);
                String right = tmp.right == null ? "null" : String.valueOf(tmp.right.val);
                sb.append(left).append(',').append(right).append(',');
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data.equals("null")) {
            return null;
        }
        Queue<String> strings = new ArrayDeque<>(Arrays.stream(data.split(",")).filter(e -> e.trim().length() > 0).collect(Collectors.toList()));
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings.poll()));
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int len = treeNodes.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = treeNodes.poll();
                String l = strings.poll();
                String r = strings.poll();
                TreeNode nodeL = "null".equals(l) ? null : new TreeNode(Integer.parseInt(l));
                TreeNode nodeR = "null".equals(r) ? null : new TreeNode(Integer.parseInt(r));
                cur.left = nodeL;
                cur.right = nodeR;
                if (nodeL != null) {
                    treeNodes.add(nodeL);
                }
                if (nodeR != null) {
                    treeNodes.add(nodeR);
                }
            }
        }
        return root;
    }

    // 括号表示编码
    public String serialize3(TreeNode root) {
        if (root == null) {
            return "X";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(root.val).append(')')
                .append('(').append(serialize3(root.left)).append(')')
                .append('(').append(serialize3(root.right)).append(')');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        if (data.equals("X")) {
            return null;
        }
        int r = 0, l = r;
        int ttt = 0;
        while (true) {
            if (data.charAt(r) == ')') {
                ttt--;
                if (ttt == 0) {
                    break;
                }
            }
            if (data.charAt(r) == '(') {
                ttt++;
            }
            r++;
        }
        TreeNode res = new TreeNode(Integer.parseInt(data.substring(l + 1, r)));

        r = r + 1;
        l = r;
        while (true) {
            if (data.charAt(r) == ')') {
                ttt--;
                if (ttt == 0) {
                    break;
                }
            }
            if (data.charAt(r) == '(') {
                ttt++;
            }
            r++;
        }
        TreeNode left = deserialize3(data.substring(l + 1, r));

        r = r + 1;
        l = r;

        while (true) {
            if (data.charAt(r) == ')') {
                ttt--;
                if (ttt == 0) {
                    break;
                }
            }
            if (data.charAt(r) == '(') {
                ttt++;
            }
            r++;
        }
        TreeNode right = deserialize3(data.substring(l + 1, r));

        res.left = left;
        res.right = right;

        return res;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}