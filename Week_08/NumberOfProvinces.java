package bit;

public class NumberOfProvinces {
    /*
     * 题 目：省份数量
     * 链 接: https://leetcode-cn.com/problems/number-of-provinces/
     * 描 述：有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *       省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *       给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     *       返回矩阵中 省份 的数量。
     */
    public int findCircleNum(int[][] isConnected) {
        int len = 0;
        if (isConnected == null || (len = isConnected.length) == 0) return 0;
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; ++i) {
            for (int j = 0; j < isConnected.length; ++j) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }
}

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

}