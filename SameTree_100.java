package leetcode;

public class SameTree_100 {
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
	public boolean isSameTree(TreeNode p, TreeNode q) {
        String s1 = getSerial(p);
        String s2 = getSerial(q);
        return s1.equals(s2);
    }
    public static String getSerial(TreeNode root)
	{
		if(root == null) return "#";
		String serial = root.val + "," + getSerial(root.left) + "," + getSerial(root.right);
		return serial;
	}
}
