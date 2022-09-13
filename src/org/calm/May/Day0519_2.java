package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/19
 * @version: v1.0
 * ---------------------------
 */
public class Day0519_2 {
    public static void main(String[] args) {
        /**
         并查集，在一些有N个元素的集合应用问题中，我们通常是在开始时让每个元素构成一个单元素的集合，然后按一定顺序将属于同一组的元素所在的集合合并，其间要反复查找一个元素在哪个集合中。
         这一类问题近几年来反复出现在信息学的国际国内赛题中，其特点是看似并不复杂，但数据量极大，若用正常的数据结构来描述的话，往往在空间上过大，
         计算机无法承受；即使在空间上勉强通过，运行的时间复杂度也极高，根本就不可能在比赛规定的运行时间（1～3秒）内计算出试题需要的结果，只能用并查集来描述。

         并查集是一种树型的数据结构，用于处理一些不相交集合（DisjointDisjoint SetsSets）的合并及查询问题。常常在使用中以森林来表示。

         class UnionFindSet:
         def UnionFindSet(n):
         parents = [0,1...n] # 记录每个元素的parent即根节点 先将它们的父节点设为自己
         ranks =[0,0...0]    # 记录节点的rank值

         # 如下图 递归版本 路径压缩(Path Compression)
         # 如果当前的x不是其父节点，就找到当前x的父节点的根节点(find(parents[x])) 并将这个值赋值给x的父节点
         def find(x):
         if ( x !=parents[x]): # 注意这里的if
         parents[x] = find(parents[x])
         return parents[x]

         # 如下图 根据Rank来合并(Union by Rank)
         def union(x,y):
         rootX = find(x) # 找到x的根节点rootX
         rootY = find(y) # 找到y的根节点rootY
         #取rank值小的那个挂到大的那个节点下面，此时两个根节点的rank值并没有发生变化，还是原来的值
         if(ranks[rootX]>ranks[rootY]): parents[rootY] = rootX
         if(ranks[rootX]<ranks[rootY]): parents[rootX] = rootY
         # 当两个rank值相等时，随便选择一个根节点挂到另外一个跟节点上，但是被挂的那个根节点的rank值需要+1
         if(ranks[rootX] == ranks[rootY] ):
         parents[rootY] = rootX
         ranks[rootX]++


         作者：a-fei-8
         链接：https://leetcode.cn/problems/redundant-connection/solution/yi-wen-zhang-wo-bing-cha-ji-suan-fa-by-a-fei-8/
         来源：力扣（LeetCode）
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

         作者：a-fei-8
         链接：https://leetcode.cn/problems/redundant-connection/solution/yi-wen-zhang-wo-bing-cha-ji-suan-fa-by-a-fei-8/
         来源：力扣（LeetCode）
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

        /**
         * 集合树：所有节点以代表节点为父节点构成的多叉树
         * 2.节点的代表节点：可以理解为节点的父节点，从当前节点出发，可以向上找到的第一个节点
         * 3.集合的代表节点：可以理解为根节点，意味着该集合内所有节点向上走，最终都能到达的节点
         * 来个图帮助理解
         *
         *
         * 上图中是一棵集合树，树中有1-6总计6个节点
         * 整个集合的代表节点是1
         * 4节点的代表节点是3，6节点的代表节点是1
         * 无论沿着哪个节点向上走，最终都会达到集合代表节点的1节点
         *
         * 然后具体到这个题上：
         * 我们以这个边集合为例子[[1,2], [3,4], [3,2], [1,4], [1,5]]
         *
         * 一、首先，对于边集合edges的每个元素，我们将其看作两个节点集合
         * 比如边[2, 3],我们将其看作节点集合2，和节点集合3
         *
         * 二、在没有添加边的时候，各个节点集合独立，我们需要初始化各个节点集合的代表节点为其自身
         * 所以，我们先初始化一个容器vector，使得vector[i]=i
         * 这里两个i意思不同，作为索引的i是指当前节点，作为值的i是指当前节点所在集合的代表节点
         * 比如vector[2] = 2，意味着2这个节点所在集合的代表节点就是2，没有添加边的情况下，所有节点单独成集合，自身就是代表节点
         * 初始化后，集合图如下图所示：
         *
         *
         * 三、然后我们开始遍历边集合，将边转化为集合的关系
         * 这里有一点很重要：边[a,b]意味着a所在集合可以和b所在集合合并。
         * 合并方法很多，这里我们简单地将a集合的代表节点戳到b集合的代表节点上
         * 这意味着，将b集合代表节点作为合并后大集合的代表节点
         * 对于一个集合的代表节点s，一定有s->s，意思是s如果是代表节点，那么它本身不存在代表节点
         * 假设我们的读取顺序为[[1,2], [3,4], [3,2], [1,4], [1,5]]
         * 初始化vector[0, 1, 2, 3, 4, 5]
         * 对应的index [0, 1, 2, 3, 4, 5]
         * ##########################################################################
         *
         * 1.读取[1,2]：
         * 读取顺序为[[1,2], [3,4], [3,2], [1,4], [1,5]]
         * 当前vector[0, 1, 2, 3, 4, 5]
         * 当前index [0, 1, 2, 3, 4, 5]
         * 原本1->1，2->2，
         * 由1节点出发，vector[1]=1, 找到1所在集合的代表节点1
         * 由2节点出发，vector[2]=2, 找到2所在集合的代表节点2
         * 于是，将1的代表置为2，vector[1]=2, vector[2]=2
         * 对应的vector[0, 2, 2, 3, 4, 5]
         * 对应的index [0, 1, 2, 3, 4, 5]
         * 原集合变为下图：
         *
         *
         * ##########################################################################
         *
         * 2.读取[3, 4]
         * 读取顺序为[[1,2], [3,4], [3,2], [1,4], [1,5]]
         * 当前vector[0, 2, 2, 3, 4, 5]
         * 当前index [0, 1, 2, 3, 4, 5]
         * 同理，将3所在集合的的代表节点3的代表节点置为4
         * 对应的vector[0, 2, 2, 4, 4, 5]
         * 对应的index [0, 1, 2, 3, 4, 5]
         * 集合变化如下图：
         *
         *
         * ##########################################################################
         *
         * 3.读取[3, 2]
         * 读取顺序为[[1,2], [3,4], [3,2], [1,4], [1,5]]
         * 当前vector[0, 2, 2, 4, 4, 5]
         * 当前index [0, 1, 2, 3, 4, 5]
         * 从节点3出发，vector[3]=4, vector[4]=4,于是找到节点3所在集合的代表节点为4
         * 从节点2出发，vector[2]=2, 找到节点2所在集合的代表节点为2
         * 于是，将4的代表置为2，vector[4]=2, vector[2]=2
         * 对应的vector[0, 2, 2, 4, 2, 5]
         * 对应的index [0, 1, 2, 3, 4, 5]
         * 集合变化如下图：
         *
         *
         * ##########################################################################
         *
         * 4.读取[1, 4]
         * 读取顺序为[[1,2], [3,4], [3,2], [1,4], [1,5]]
         * 当前vector[0, 2, 2, 4, 2, 5]
         * 当前index [0, 1, 2, 3, 4, 5]
         * 从节点1出发，vector[1]=2, vector[2]=2, 找到节点1所在集合代表节点为2
         * 从节点4出发，vector[4]=2, vector[2]=2, 找到节点4所在集合代表节点为2
         * 由于1和4的代表节点相同，说明这两个节点本身就在同一个集合中
         * 由于原图是无向图，路径是双向可达的，1能够到达2,而且2能够到达4，再加上1能够到达4
         * 说明1能通过两条路径到达4，,这也意味着这条边出现的时候，原图中一定出现了环
         * 至于题中要求的，返回最后一条边，其实这就是返回添加过后会构成环的那一条边
         * 直白解释就是，在这条边出现之前，图中没有环
         * 这条边出现，图中也出现环。包括这条边在内，构成环的边都是满足破圈条件的边
         * 然而谁是最后一条出现在边集合里的？当然，就是这条构成环的最后一条边
         * ##########################################################################
         *
         * 到这里，对于此题的实现基本上说完了，直接上代码吧
         *
         *
         * class Solution {
         * public:
         *     vector<int> findRedundantConnection(vector<vector<int>>& edges) {
         *         vector<int> rp(1001);
         *         int sz = edges.size();
         *         // 初始化各元素为单独的集合，代表节点就是其本身
         *         for(int i=0;i<sz;i++)
         *             rp[i] = i;
         *         for(int j=0;j<sz;j++){
         *             // 找到边上两个节点所在集合的代表节点
         *             int set1 = find(edges[j][0], rp);
         *             int set2 = find(edges[j][1], rp);
         *             if(set1 == set2)  // 两个集合代表节点相同，说明出现环，返回答案
         *                 return edges[j];
         *             else    // 两个集合独立，合并集合。将前一个集合代表节点戳到后一个集合代表节点上
         *                 rp[set1] = set2;
         *         }
         *         return {0, 0};
         *     }
         *
         *     // 查找路径并返回代表节点，实际上就是给定当前节点，返回该节点所在集合的代表节点
         *     // 之前这里写的压缩路径，引起歧义，因为结果没更新到vector里，所以这里改成路径查找比较合适
         *     // 感谢各位老哥的提议
         *     int find(int n, vector<int> &rp){
         *         int num = n;
         *         while(rp[num] != num)
         *             num = rp[num];
         *         return num;
         *     }
         * };
         *
         *
         * 作者：Zhcode
         * 链接：https://leetcode.cn/problems/redundant-connection/solution/tong-su-jiang-jie-bing-cha-ji-bang-zhu-xiao-bai-ku/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
    }
}
