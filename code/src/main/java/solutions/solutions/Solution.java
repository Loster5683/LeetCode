package solutions.solutions;

import solutions.base.ListNode;
import solutions.base.TreeNode;

import java.util.*;

public class Solution {

    //1. Two Sum    use hashmap
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer, Integer>  m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(target - nums[i])){
                return new int [] {m.get(target - nums[i]), i};
            }
            else{
                m.put(nums[i], i);
            }
        }
        return result;
    }

    //1. Two Sum    use double pointer if array sorted
    public int[] twoSum2(int[] nums, int target) {
        int [] result = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] {i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }


    //322. Coin Change  use dp with memo
    public int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return -1;
        }

        if(memo[amount] != -2) {
            return memo[amount];
        }

        int value = Integer.MAX_VALUE;
        for(int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            value = Math.min(value, sub + 1);
        }
        memo[amount] = (value == Integer.MAX_VALUE) ? -1 : value;
        return memo[amount];
    }

    //300. Longest Increasing Subsequence  dp O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    //300. Longest Increasing Subsequence  二分查找算法 O(nlogn)，list最长递增序列每个位置的最小值
    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {

            //binarySearch 查找不到的时候返回-(left + 1)
            int index = Arrays.binarySearch(list.toArray(), 0, list.size(), nums[i]);
            if (index >= 0) {
            } else if (-index - 1 < list.size()){
                list.set(-index - 1, nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.size();
    }

    //300. Longest Increasing Subsequence  二分查找 O(nlogn)
    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int len = 0;
        for(int num : nums) {

            int index = Arrays.binarySearch(dp, 0, len, num);

            if(index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if(index == len) {
                len++;
            }
        }

        return len;
    }

    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp0 = nums[0];
        int dp1 = 0;
        int res = dp0;
        for (int i = 1; i < nums.length; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        return res;
    }

    //46. Permutations 回溯全排列(无重复元素) O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new LinkedList<>();
        int[] visited = new int[nums.length];
        pullback(result, nums, new LinkedList<>(), visited);
        return result;
    }

    public void pullback(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int node = nums[i];
            if (visited[i] == 1) {
                continue;
            }
            path.add(node);
            visited[i] = 1;
            pullback(result, nums, path, visited);
            visited[i] = 0;
            path.removeLast();
        }
    }

    //46. Permutations 基于邻里互换的全排列(无重复元素),  O(n!)。
    // 比回溯稍微快点, 回溯如果原数组有序的话生成的是字典序，交换是乱序
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result= new LinkedList<>();
        pullback(result, nums, 0, nums.length - 1);
        return result;
    }

    public void pullback(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
        }

        for (int i = start; i <= end; i++) {
            if (nums[i] == nums[start]) {
                continue;
            }
            swap(nums, start, i);
            pullback(result, nums, start+1, end);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int start, int i) {
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;
    }

    //47. Permutations II  有重复数字的全排列 回溯剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        return new LinkedList<>();//todo
    }

    //51. N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueensCycle(result, n, new ArrayList<Integer>(), -2);
        return result;
    }

    private void solveNQueensCycle(List<List<String>> result, int n, ArrayList<Integer> fillCols, int lastRowCol) {
        if (fillCols.size() == n) {
            result.add(solveNQueensResult(fillCols));
        }
        for (int i = 0; i < n; i++) {
            if (fillCols.contains(i)) {
                continue;
            } else {
                 if (!isValid(i, fillCols, n)) {
                     continue;
                 }

            }
            fillCols.add(i);
            solveNQueensCycle(result, n, fillCols, i);
            fillCols.remove(fillCols.size() - 1);
        }
    }

    private boolean isValid(int i, ArrayList<Integer> fillCols, int n) {
        int col = i, row = fillCols.size();
        for (int s = col - 1, k = row - 1; k >= 0 && s >= 0; s--, k--) {
            if (fillCols.get(k) == s) {
                return false;
            }
        }
        for (int s = col + 1, k = row - 1; k >= 0 && s <=n; s++, k--) {
            if (fillCols.get(k) == s) {
                return false;
            }
        }
        return true;
    }

    private List<String> solveNQueensResult(ArrayList<Integer> fillCols) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < fillCols.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < fillCols.size(); j++) {
                if (j == fillCols.get(i)) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            strings.add(stringBuilder.toString());
        }
        return strings;
    }

    //111. Minimum Depth of Binary Tree  BFS
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int depth = 1;
        while (queue.size() > 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode s = queue.poll();
                if (s.left == null && s.right == null) {
                    return depth;
                }
                if (s.left != null) {
                    queue.offer(s.left);
                }
                if (s.right != null) {
                    queue.offer(s.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //752. Open the Lock BFS
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        String init = "0000";
        if (visited.contains(init)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(init);
        visited.add(init);
        int len = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(target)) {
                    return len;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = roundInt(s, j, true);
                    if (!visited.contains(plus)) {
                        visited.add(plus);
                        queue.add(plus);
                    }

                    String sub = roundInt(s, j, false);
                    if (!visited.contains(sub)) {
                        visited.add(sub);
                        queue.add(sub);
                    }
                }
            }
            len++;
        }
        return -1;
    }

    private String roundInt(String s, int j, boolean plus) {
        char[] chars = s.toCharArray();
        char oldChar = chars[j];
        char newChar;
        if (plus) {
            newChar = (char) ((oldChar - '0' + 1) % 10 + '0');
        } else {
            newChar = (char) ((oldChar - '0' + 9) % 10 + '0');
        }
        chars[j] = newChar;
        return new String(chars);
    }

    //543. Diameter of Binary Tree
    int maxlen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxlen;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxlen = Math.max(maxlen, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //23. Merge k Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        while (!priorityQueue.isEmpty()) {
            ListNode min = priorityQueue.poll();
            if (min.next != null) {
                priorityQueue.offer(min.next);
            }
            p.next = min;
            p = p.next;
        }
        return dummy.next;
    }

    //141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    //142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                while(p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    //200. Number of Islands
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if(i - 1 >= 0) {
            dfs(grid, i -1, j);
        }
        if(i + 1 < grid.length) {
            dfs(grid, i + 1, j);
        }
        if(j - 1 >= 0) {
            dfs(grid, i, j - 1);
        }
        if(j + 1 < grid[0].length) {
            dfs(grid, i, j + 1);
        }
    }

    //1254. Number of Closed Islands
    public int closedIsland(int[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    if (dfs2(grid, i, j)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public boolean dfs2(int[][] grid, int i, int j) {
        boolean notNear = true;
        if(grid[i][j] == 1) {
            return true;
        }
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            notNear = false;
        }
        grid[i][j] = 1;

        if(i - 1 >= 0) {
            notNear &= dfs2(grid, i -1, j);
        }
        if(i + 1 < grid.length) {
            notNear &= dfs2(grid, i + 1, j);
        }
        if(j - 1 >= 0) {
            notNear &= dfs2(grid, i, j - 1);
        }
        if(j + 1 < grid[0].length) {
            notNear &= dfs2(grid, i, j + 1);
        }
        return notNear;
    }

    //1020. Number of Enclaves 与1254类似，不过是求封闭岛屿面积和，而不是岛屿个数
    //从所有边出发能通过1连通的点都置0，剩下的就是孤立岛屿
    public int numEnclaves(int[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    dfs3(grid, i, j);
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                num += grid[i][j];
            }
        }

        return num;
    }

    public void dfs3(int[][] grid, int i, int j) {
        if(i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1 && grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs3(grid, i -1, j);
            dfs3(grid, i + 1, j);
            dfs3(grid, i, j - 1);
            dfs3(grid, i, j + 1);
        }
    }

    //695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int s = dfs4(grid, i, j);
                    if (s > 0) {
                        num = Math.max(s, num);
                    }
                }
            }
        }
        return num;
    }

    public int dfs4(int[][] grid, int i, int j) {
        if(grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int t = 0;
        if(i - 1 >= 0) {
            t += dfs4(grid, i -1, j);
        }
        if(i + 1 < grid.length) {
            t += dfs4(grid, i + 1, j);
        }
        if(j - 1 >= 0) {
            t += dfs4(grid, i, j - 1);
        }
        if(j + 1 < grid[0].length) {
            t += dfs4(grid, i, j + 1);
        }
        return 1 + t;
    }

    //1905. Count Sub Islands
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int num = 0;
        for(int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs5(grid2, grid1, i, j)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public boolean dfs5(int[][] grid2, int[][] grid1, int i, int j) {
        if (i < 0 || j < 0 || i > grid2.length - 1 || j > grid2[0].length - 1) {
            return true;
        }
        boolean result = false;
        if (grid2[i][j] == 0) {
            result = true;
        } else if (grid1[i][j] >= grid2[i][j]) {
            result = true;
            grid1[i][j] = 0;
            grid2[i][j] = 0;
            result &= dfs5(grid2, grid1, i - 1, j);
            result &= dfs5(grid2, grid1, i + 1, j);
            result &= dfs5(grid2, grid1, i, j - 1);
            result &= dfs5(grid2, grid1, i, j + 1);
        }
        return result;
    }

    //76. Minimum Window Substring
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        if (t.length() > s.length() || s.length() == 0) {
            return "";
        }
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }
        char[] all = s.toCharArray();
        int i = 0, j = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (j < s.length()) {
            char c = all[j];
            j++;
            if (need.containsKey(c)) {
                current.merge(c, 1, Integer::sum);
                if (current.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                char c2 = all[i];
                if (len > j - i) {
                    len = j - i;
                    start = i;
                }

                if (need.containsKey(c2)) {
                    if (current.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    current.merge(c2, -1, Integer::sum);
                }
                i++;
            }
        }
        return (len > s.length()) ? "" : s.substring(start, start + len);
    }

    //567. Permutation in String
    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }
        char[] all = s.toCharArray();
        int i = 0, j = 0;
        int valid = 0;
        while (j < s.length()) {
            char c = all[j];
            j++;
            if (need.containsKey(c)) {
                current.merge(c, 1, Integer::sum);
                if (current.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (j -i >= t.length()) {

                if (valid == need.size()) {
                    return true;
                }
                char c2 = s.charAt(i);
                if (need.containsKey(c2)) {
                    if (current.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    current.merge(c2, -1, Integer::sum);
                }
                i++;
            }
        }
        return false;
    }

    //438. Find All Anagrams in a String
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> index = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }
        char[] all = s.toCharArray();
        int i = 0, j = 0;
        int valid = 0;
        while (j < s.length()) {
            char c = all[j];
            j++;
            if (need.containsKey(c)) {
                current.merge(c, 1, Integer::sum);
                if (current.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (j -i >= t.length()) {

                if (j - i == t.length() && valid == need.size()) {
                    index.add(i);
                }
                char c2 = s.charAt(i);
                if (need.containsKey(c2)) {
                    if (current.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    current.merge(c2, -1, Integer::sum);
                }
                i++;
            }
        }
        return index;
    }

    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Set<Character> current = new HashSet<>();
        char[] all = s.toCharArray();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            char c = all[j];
            if (current.contains(c)) {
                while (true) {
                    char cc = all[i];
                    current.remove(cc);
                    i++;
                    if (cc == c) {
                        break;
                    }
                }
            }
            current.add(c);
            int len = j - i + 1;
            maxLen = Math.max(len, maxLen);
            j++;
        }
        return maxLen;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            ListNode prev = dummy;

            // find the position to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            // insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            // moving on to the next iteration
            curr = next;
        }

        return dummy.next;
    }
}