## 1. 标准DFS模板（树形结构）

```java
// 模板1：遍历所有节点（无返回值）
void dfs(TreeNode node) {
    if (node == null) return;
    
    // 前序遍历：处理当前节点
    // ...
    
    dfs(node.left);   // 递归左子树
    dfs(node.right);  // 递归右子树
    
    // 后序遍历：处理子节点返回后
    // ...
}

// 模板2：带回溯（有返回值）
Result dfs(TreeNode node) {
    if (node == null) {
        return baseCase;  // 返回基础值
    }
    
    Result left = dfs(node.left);    // 处理左子树
    Result right = dfs(node.right);  // 处理右子树
    
    // 后序遍历：根据左右子树结果计算当前节点
    Result current = combine(node, left, right);
    
    return current;
}
```

## 2. 应用到"打家劫舍III"（完整版）

```java
class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    
    // 标准DFS模板（带回溯）
    private int[] dfs(TreeNode node) {
        // 1. 终止条件
        if (node == null) {
            return new int[]{0, 0};
        }
        
        // 2. 递归遍历左右子树
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // 3. 后序遍历：处理当前节点
        // dp[0]: 不偷当前节点
        // dp[1]: 偷当前节点
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = node.val + left[0] + right[0];
        
        // 4. 返回结果给父节点
        return new int[]{notRob, rob};
    }
}
```

## 3. 其他常见的DFS应用场景

### 场景1：求二叉树的最大深度
```java
int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;  // 后序遍历
}
```

### 场景2：判断平衡二叉树
```java
boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}

int height(TreeNode node) {
    if (node == null) return 0;
    int left = height(node.left);
    if (left == -1) return -1;  // 剪枝
    int right = height(node.right);
    if (right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
}
```

### 场景3：路径和问题
```java
int pathSum(TreeNode root, int target) {
    if (root == null) return 0;
    return dfs(root, target) + pathSum(root.left, target) + pathSum(root.right, target);
}

int dfs(TreeNode node, int target) {
    if (node == null) return 0;
    int count = (node.val == target) ? 1 : 0;
    count += dfs(node.left, target - node.val);
    count += dfs(node.right, target - node.val);
    return count;
}
```

## 4. DFS的关键要点

| 要素 | 说明 |
|------|------|
| **终止条件** | 通常是 node == null 或叶子节点 |
| **递归调用** | 先处理左右子树（后序遍历） |
| **状态组合** | 根据子问题结果计算当前问题 |
| **返回值** | 向上层传递计算结果 |

**核心思想**：把大问题分解为子问题，子问题解决后组合得到原问题的解（分治思想）。