package leetcode.editor.cn;

import java.util.*;

class ThroneInheritanceTmp{
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy"); // �̳�˳��king > andy
        t.birth("king", "bob"); // �̳�˳��king > andy > bob
        t.birth("king", "catherine"); // �̳�˳��king > andy > bob > catherine
        t.birth("andy", "matthew"); // �̳�˳��king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // �̳�˳��king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // �̳�˳��king > andy > matthew > bob > alex > asha > catherine
        t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // �̳�˳��king > andy > matthew > bob���Ѿ�ȥ����> alex > asha > catherine
        t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "alex", "asha", "catherine"]
//        BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class ThroneInheritance {

    private final String king;
    Map<String, List<String>> father2Son = new HashMap<>();
    Set<String> deadMan = new HashSet<>();
    public ThroneInheritance(String kingName) {
        father2Son.put(kingName, new ArrayList<>());
        this.king = kingName;
    }
    
    public void birth(String parentName, String childName) {
        father2Son.get(parentName).add(childName);
        father2Son.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        deadMan.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        cycle(king, res);
        return new ArrayList<>(res);
    }

    public void cycle(String s, List<String> ps) {
        if (!deadMan.contains(s)) {
            ps.add(s);
        }
        for (String string : father2Son.get(s)) {
            cycle(string, ps);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
//leetcode submit region end(Prohibit modification and deletion)

}