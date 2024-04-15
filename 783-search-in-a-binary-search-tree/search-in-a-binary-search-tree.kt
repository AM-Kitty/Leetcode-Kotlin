/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    // Keywords: DFS
    
    var node: TreeNode? = null

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
         dfs(root, `val`)
         return node
    }
    fun dfs(root: TreeNode?, `val`: Int){
        if(root != null){
            if(root.`val` == `val`){
                node = root
                return
            }

            dfs(root.left, `val`)
            dfs(root.right, `val`)
        }
    }
}