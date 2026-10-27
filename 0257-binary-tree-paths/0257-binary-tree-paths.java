
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPaths(root, "", result);
        return result;
    }

    private void findPaths(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        if (!path.isEmpty()) {
            path += "->";
        }
        path += node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        findPaths(node.left, path, result);
        findPaths(node.right, path, result);
    }
}
