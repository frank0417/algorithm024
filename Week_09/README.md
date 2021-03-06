# 第9周学习笔记

## 布隆过滤器（一）

**布隆过滤器特点:**

- 1.它是由一个很长的二进制向量和一系列随机映射函数计算生成
- 2.它可以用于快速检索一个元素是否在一个集合中，空间效率和查询速度远远超过一般的算法。
- 3.它也不是完美的，缺点是有一定的错识率，如果一个元素查询不在集合中，那么它一定不在，
    如果查询某一元素在集合中，那它真不一定在，所以在一些过滤场景下要做二次确认。它还有
    一个缺点就是不能删除，效率非常低，如果有这种删除场景请参考Counting Bloom Filter。

**使用场景：** 
- 1. 白名单解决缓存穿透（redis）
- 2. 推送过滤的场景（短视频、商品、信息流、广告等等）

## LRU（二）

最近最少使用

- 1.它是一种缓存处理的策略，比较常用，没啥特别好介绍的了
- 2.实现方式双向链表+HashTable，工程上实现相对考虑的点比较多，比如要考虑线程安全等
- 3.自己写链表实现LRU最重要的就是删除和添加元素，添加和删除记得更新其位置


## 排序算法（三）

**分类** 

- 1.比较类排序

通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn),因此也成为非线性时间比较类排序，
例如：交换排序（冒泡排序、快速排序） 插入排序（简单插入排序、希尔排序）选择排序（简单选择排序、堆排序）
归并排序（二路归并排序，多路归并排序）

- 2.非比较类排序
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也成为线性
时间非比较类排序
例如：计数排序、桶排序、基数排序

- 3.各类排序的对比如下：

 ![](https://raw.githubusercontent.com/frank0417/algorithm024/main/Week_09/sort.png)

重点关注时间复杂度为nlogn的排序算法，快速排序、归并排序、堆排序

## 动态规划（四）

动态规划经过这一段时间的训练终于有了一定的成果，做题效率有较大的提升，动态规划的题只能靠多做题，多想。


