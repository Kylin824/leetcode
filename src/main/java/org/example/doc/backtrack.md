
## 1. 回溯算法通用模板（Java）

```java
void backtrack(选择列表, 路径, 结果集) {
    // 终止条件：到达决策树的底部
    if (满足结束条件) {
        结果集.add(new ArrayList<>(路径));  // 记录一个完整答案
        return;
    }

    // 遍历所有可选的选择
    for (选择 in 选择列表) {
        // 1. 剪枝（可选）：如果当前选择不合法，跳过
        if (!isValid(选择)) continue;

        // 2. 做选择：将当前选择加入路径
        路径.add(选择);

        // 3. 递归：进入下一层决策树
        backtrack(新的选择列表, 路径, 结果集);

        // 4. 撤销选择：回溯，恢复状态
        路径.remove(路径.size() - 1);
    }
}
```

**核心口诀**：
> **选 - 递归 - 撤**，三步走天下。  
> **终止条件**记心间，**剪枝**优化更潇洒。

---

## 2. 应用到 LC131（分割回文串）

```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, result);
        return result;
    }

    private void backtrack(String s, int start, 
                           List<String> path, 
                           List<List<String>> result) {
        // 【终止条件】已经切到末尾，找到一个完整方案
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 【遍历选择列表】从 start 到末尾，每个位置都可以是切割点
        for (int end = start; end < s.length(); end++) {
            // 【剪枝】如果不是回文，跳过这个选择
            if (!isPalindrome(s, start, end)) continue;

            // 【做选择】切出当前子串
            path.add(s.substring(start, end + 1));

            // 【递归】继续切剩余部分
            backtrack(s, end + 1, path, result);

            // 【撤销选择】回溯，尝试下一个 end
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
```

---

## 3. 模板中每个部分的含义（对照 LC131）

| 模板部分 | LC131 的具体含义 |
|---------|----------------|
| **选择列表** | 从当前 `start` 到末尾，每个 `end` 都代表一种切割方式 |
| **路径** | 当前已经切出来的回文子串列表 |
| **终止条件** | `start == s.length()`，所有字符都被切完 |
| **做选择** | 把 `s[start..end]` 加入路径 |
| **递归** | 从 `end+1` 开始继续切剩下的字符串 |
| **撤销选择** | 移除刚加入的子串，尝试下一个 `end` |
| **剪枝** | 只有回文子串才继续，否则直接跳过 |

---

## 4. 其他常见题目的模板变形

### ① 全排列（Permutations）
```java
void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
    if (path.size() == nums.length) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;  // 剪枝：已用过
        used[i] = true;
        path.add(nums[i]);
        backtrack(nums, path, used, res);
        path.remove(path.size() - 1);
        used[i] = false;
    }
}
```

### ② 组合（Combinations）
```java
void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
    if (path.size() == k) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int i = start; i <= n; i++) {
        path.add(i);
        backtrack(n, k, i + 1, path, res);  // 注意是 i+1，避免重复
        path.remove(path.size() - 1);
    }
}
```

### ③ 子集（Subsets）
```java
void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
    res.add(new ArrayList<>(path));  // 每个节点都记录
    for (int i = start; i < nums.length; i++) {
        path.add(nums[i]);
        backtrack(nums, i + 1, path, res);
        path.remove(path.size() - 1);
    }
}
```

---

## 5. 回溯算法要点总结

| 要点 | 说明 |
|-----|------|
| **本质** | 暴力穷举 + 剪枝，DFS 遍历决策树 |
| **时间复杂度** | 通常是指数级 O(2ⁿ) 或 O(n!)，但剪枝能优化 |
| **空间复杂度** | O(n)（递归深度 + 路径存储） |
| **关键三步骤** | ①做选择 → ②递归 → ③撤销选择 |
| **常见剪枝** | 去重（used数组）、合法性判断、排序后提前终止 |
| **结果保存** | 必须 `new ArrayList<>(path)` 复制，否则会被后续修改 |

---

## 6. 记忆口诀 🎯

> **回溯就是走迷宫，  
> 走一步，记一步，  
> 走到头，存结果，  
> 退一步，换条路。**

---

如果你想看更多模板变体（比如 **N皇后**、**括号生成**、**组合总和**），或者想让我把递归树画出来讲解，随时告诉我！😊