package solutions.solutions;

import org.junit.jupiter.api.Test;
import solutions.base.DataStructBuilder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTestTest extends Solution {

    @Test
    void testTwoSum2() {
        System.out.println(Arrays.equals(twoSum2(DataStructBuilder.initIntArray("[2,3,4]"), 6), new int[]{0, 2}));
    }

    @Test
    void testCoinChange() {
        System.out.println(coinChange(DataStructBuilder.initIntArray("[186,419,83,408]"), 6249) == 20);
    }

    @Test
    void testLengthOfLIS2() {
        System.out.println(lengthOfLIS2(DataStructBuilder.initIntArray("[3,5,6,2,5,4,19,5,6,7,12]")) == 4);
    }

    @Test
    void testLengthOfLIS31() {
        System.out.println(lengthOfLIS3(DataStructBuilder.initIntArray("[10,9,2,5,3,7,101,18]")) == 4);
    }

    @Test
    void testPermute() {
        System.out.println(permute(DataStructBuilder.initIntArray("[1,2,3]")));
    }

    @Test
    void testSolveNQueens() {
        System.out.println(solveNQueens(5).size() == 10);
    }

    @Test
    void testMinDepth() {
        System.out.println(minDepth(DataStructBuilder.initNodeTree("[3,9,20,null,null,15,7]")));
    }

    @Test
    void testOpenLock() {
        System.out.println(openLock(DataStructBuilder.initStringArray("[\"8888\"]"), "0009"));
    }

    @Test
    void testDiameterOfBinaryTree() {
        System.out.println(diameterOfBinaryTree(DataStructBuilder.initNodeTree("[1,2,3,4,5]")));
    }


    @Test
    void testNumIslands() {
        System.out.println(numIslands(DataStructBuilder.init2DCharArray("[[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"1\",\"1\"]]")));
    }

    @Test
    void testNumEnclaves() {
        System.out.println(numEnclaves(DataStructBuilder.init2DIntArray("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]")));
    }

    @Test
    void testCountSubIslands() {
        System.out.println(countSubIslands(DataStructBuilder.init2DIntArray("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]"), DataStructBuilder.init2DIntArray("[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]")));
    }

    @Test
    void testMinWindow() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testLengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}