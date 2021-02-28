***第四周学习总结***

**1.本周问题**

   ```
   客观原因，本周日常工作及其他直播课程耽误了练习，很多算法题没有做，并且没有达到自己的预期效果，需要赶紧补回来，在这记录一下。
  ```

**2.深度优先和广度优先遍历**
  
   ```
   经过上周的递归相关学习，再学DFS的时候比较容易了，BFS存粹是模板，只要套用模板比较容易，这两类题只要
   做有心人，问题相对比较容易了。
  ```
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

**3.贪心算法**

```
  贪心算法没什么太多的技巧，没有可抽象的逻辑或模板，这个就是根据实际的题目，每一步选择最优，希望最后是最优的。
  贪心算法一般会和其他算法共同使用，目前还没有做过类似的题目，等后面遇到后再总结。
  贪心算法最主要的是要与动态规划区别开,贪心不会回溯，不能回退只能向前。动态规划则需要保存之前的计算结果，并根据结果
进行回溯，回退或分支处理。
``` 

**4.二分查找**

```
  二分查找是比较常用的算法，大学学数据结构这门课已经讲过了，对于这个算法比之前学的算法要容易的太多了，因为本身你就
学过，而且最主要的是人脑不用递归了，非常容易理解，但是容易理解归容易理解，难点就是你要形成肌肉记忆，写这个代码的时候
不用经过大脑，直接输入，否则容易写错哈。这个是咱们目前的课程里最简单的了。
  能用二分查找的基本条件：
  1.单调性
  2.存在上下界
  3.能通过索引访问
``` 

* 二分查找模板
 ```java
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid = 0;
        while (left <= right) {
            mid = (right - left + 1) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
```

**5.期中答疑总结**
```
    本周其中答疑的过程中发现自己对时间和空间复杂度的理解还差一些，还有关于题目的想法互动等环节需要加强练习。
```
 