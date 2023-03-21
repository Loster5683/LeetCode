package leetcode.editor.cn;

import java.util.*;

class MakingFileNamesUnique{
    public static void main(String[] args) {
       Solution solution = new MakingFileNamesUnique().new Solution();
       BaseTest.baseTest(solution, "getFolderNames", "[\"kaido\",\"kaido(1)\",\"kaido\",\"kaido(1)\",\"kaido(2)\"]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> res = new HashMap<>();
        for (int z = 0; z < names.length; z++) {
            String name = names[z];
            if (res.containsKey(name)) {
                int i = res.get(name);
                String rm = name + '(' + i + ')';
                while (res.containsKey(rm)) {
                    i++;
                    rm = name + '(' + i + ')';
                }
                res.put(name, i + 1);
                res.put(rm, 1);
                names[z] = rm;
            } else {
                res.put(name, 1);
            }
        }
        return names;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}