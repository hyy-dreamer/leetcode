package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum_113 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
    List<ArrayList<Integer>> res = new ArrayList<>();
    Deque<Integer> q = new LinkedList<>();
    public List<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int sum)
    {
        if(root == null) return;
        q.offerLast(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) 
        {
            res.add(new ArrayList<Integer>(q));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        q.pollLast();
    }
}
