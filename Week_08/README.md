# 第8周学习笔记

## 并查集
**关键点:**

- 1.并查集的实现相对比较简单，比较死，主要解决组团和配对的问题，快速的判断两个群组是否关联
    例如：群岛数量、朋友圈、省份数量
- 2.每个题目唯一的变化点就在于将一维数组或二维数组转换成一维数组进行处理
    例如：m*n的二维数组，在并查集里对应的一维表示方式为 i*n+j，i为遍历m的变量，j为n的遍历变量

**代码模版** 
* 模板
```java
class UnionFind {
    int count = 0;
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
```

## 前缀树 || trie || 字典树
**关键点:**

- 1.典型应用是用于统计和排序大量的字符串或搜索引擎用于文本词频统计，优点是最大
    限度地减少无谓的字符串比较，查询效率比哈希表高
    例如：单词搜索问题
    
 **特性:**
- 1.节点本身不存完成单词
- 2.从根节点到某一节点，路径上经过的字符串连接起来，为该节点对应的字符串
- 3.每个节点的所有子节点路径代表的字符都不相同

**代码模版** 
* 模板
```java
public class Trie {
    private Trie[] next;
    private boolean isEnd = false;

    public Trie() {
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Trie();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) return false;
            curr = curr.next[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) return false;
            curr = curr.next[c - 'a'];
        }
        return true;
    }
}
```

## 红黑树 & AVL树
**关键点:**

- 1.主要解决的是树的平衡问题
- 2.熟悉2-3 tree、AA tree、AVL tree、B-tree、Red-black tree的数据结构及特点
```
       AVL树是平衡二叉搜索树的鼻祖，它的平衡度也最好，左右高度差可以保证在「-1，0，1」，
    基于它的平衡性，它的查询时间复杂度可以保证是O（log n）。但每个节点要额外保存一个平衡值，
    或者说是高度差。
       红黑树一样也是平衡二叉搜索树，也是工业界最主要使用的二叉搜索平衡树。但平衡度红黑树没
    AVL那么好。也就是说，如果从高度差来说，红黑树是大于AVL的，其实也就代表着它的实际查询时
    间(最坏情况)略逊于AVL的。数学证明红黑树的最大深度是  , 其实最差情况它从根到叶子的最长路
    可以是最短路的两倍，但也不是很差，所以它的查询时间复杂度也是O（log n）。一般工业界把红黑
    树作为一种更通用的平衡搜索数来用，Java用它来实现TreeMap。
        B/B+ 树就是N叉（N-ary）平衡树了，每个节点可以有更多的孩子，新的值可以插在已有的节点里，
    而不需要改变树的高度，从而大量减少重新平衡和数据迁移的次数，这非常适合做数据库索引这种需要
    持久化在磁盘，同时需要大量查询和插入操作的应用。
        AA Tree是红黑树的变种，因而它也是一颗二叉排序树,但是比红黑树实现要简单。不同于红黑树
    采用颜色（红色或黑色）来纪录一个节点的状态以调整节点的位置来保持其平衡性，AA Tree采用level值
    来纪录当前节点的状态以保持它的平衡性，level值相当于红黑树中的黑节点高度，java Ehcache中就采
    用AA Tree来记录空闲的磁盘块。
        2-3树是一种绝对平衡的树，一颗2-3树种有二节点与三节点的树结构，2结点包含一个元素和两个孩
    子(或者没有孩子)，3结点包含一大一 小两个元素和三个孩子(或者没有孩子)，2 -3树所有叶子结点都在
    同一层次。
```

## 位运算 
**关键点:**

- 1.位运算其实在程序中使用的比较少，但是用到的地方你会觉得真甜，太好用了，这块没啥好说的，常用的位运算
技巧学会了即可，知道什么时候用能提升效率，但有个问题就是可读性不算太友好。

**常用的位运算公式：** 

```java
 1.将x最右边的n位清零：x&(~0<<n)
 2.获取x的第n位值（0 or 1）：(x>>n)&1
 3.获取x的第n位的幂值：x&(1<<n)
 4.仅将第n位置为1：x|(1<<n)
 5.仅将第n位置为0：x&(~(1<<n))
 6.将ｘ最高位至第ｎ位（含）清零：x&((1<<n)-1)
```

**位运算实战要点：** 

```java
 判断奇偶
 x%2==1 -> (x&1)==1
 x%2==0 -> (x&1)==0
 除2
 x/2 -> x>>1
 二分查找中：mid的计算  mid=(left+right)>>1;
 清零最低位的1
 x=x&(x-1)
 得到最低位的1
 x&-x
 清零
 x&~x
 
```

## 单词搜索2时间复杂度分析 
**关键点:**
m*n*wl^4,其中m为board的row，n为board的列，wl为words词典的单词平均长度