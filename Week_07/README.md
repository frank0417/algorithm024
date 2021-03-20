# 第7周学习笔记

## 剪枝（一）

**关键点:**

- 1.处理过的不要再处理，也就是去重复，方法是用缓存
    例如：斐波那契，缓存已经处理过的
- 2.已知次优的分支不要再处理，跳过
    例如：括号生成，把一些非法的括号略过

**代码模版** 
* dfs模板
```java
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            travel(root, 0, result);
            return result;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, result);
        }
        if (root.right != null) {
            travel(root.right, level + 1, result);
        }
    }

```
* bfs模板
 ```java
   public List<List<Integer>> bfs(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       if (root == null) return result;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           int size = queue.size();
           List<Integer> list = new ArrayList<>();
           for (int i = 0; i < size; ++i) {
               TreeNode node = queue.poll();
               list.add(node.val);
               if (node.left != null) queue.add(node.left);
               if (node.right != null) queue.add(node.right);
           }
           result.add(list);
       }
       return result;
   }
```

## 双向 BFS

- 1.顾名思义，就是将传统的单向搜索转为双向搜索
   例如：单词接龙
* 双向bfs模板
```java
    Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    beginSet.add(begin);
    endSet.add(end);
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        if (beginSet.size() > endSet.size()) {
            Set<String> set = beginSet;
            beginSet = endSet;
            endSet = set;
        }
        Set<String> temp = new HashSet<>();
        for (String be : beginSet) {
            char[] chs = be.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
                if(XXX){
                    visited.add(XXXX);
                    temp.add(XXX);
                }
                chs[i] = old;
            }
        }
        beginSet = temp;
        count++;
    }

```
## 启发式搜索 || A* 


```java

```