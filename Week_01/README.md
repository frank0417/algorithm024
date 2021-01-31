**第一周学习总结**

1. ***先说说自己的学习方法***

    ```
    站在别人肩膀上的感觉真好，往期学员总结的方法真不错，我改了一下记录方式，我只记录每个题目最后一次提交成功的时间，
    并且天数和次数是一一对应的，如果某一天一个题目提交过多次，计数也只算一次。
    ```
    ![](https://raw.githubusercontent.com/frank0417/algorithm024/main/Week_01/resource/al1.png)
    ```
    ps：大家图片如果看不到的话，请在本地电脑将host设置一下：
    
    199.232.68.133 raw.githubusercontent.com
    
    199.232.68.133 githubusercontent.com
    ```
    
    
    ```
    五毒神掌: 一道题至少过遍数过五遍，理解题意、思考、看代码，写代码，看优秀代码，再写代码.
    
   ​	第一遍: 初次做，思考5~10分钟，如果有思路，写，如果没有思路，看题解，先广度再深度，理解后默写代码，没理解背代码。
    
   ​	以后的遍数: 不看题解, 自己思考实现，忘了的话，按第一遍步骤重新来过。
    ```
    ```
    切题四件套: 面试中具体解题时的步骤(我们平常练习也一样，不一定为了面试，而是养成一种习惯)
    
      1. 审题, 针对题目的细节和面试官进行沟通, 确保自己对题目理解没有歧义
    
      2. 列出所有可能的解法, 对每一个解法都和面试官进行简单的讲解(包括时间和空间复杂度，大概实现思路), 选出最优解
    
      3. coding
    
      4. test
    
    ```


2. ***改写deque的API代码***

   ```java
   public class TestDeque{
       public static void main(String[] args) {
               Deque dq=new LinkedList();
               dq.addFirst(0);
               dq.addFirst(1);
               dq.addLast(3);
       
               System.out.println(dq.getFirst());
               System.out.println(dq.getLast());
           }
   }
   ```


3. ***分析 JDK1.8 中Queue 和 Priority Queue 的源码***
   
   源码地址：https://github.com/frank0417/Java8-Source-Code

   Queue: 
   
    Queue在JDK中是一个接口，其实现类如下：
    
    ```java
       * @see java.util.concurrent.LinkedBlockingQueue
       * @see java.util.concurrent.BlockingQueue
       * @see java.util.concurrent.ArrayBlockingQueue
       * @see java.util.concurrent.LinkedBlockingQueue
       * @see java.util.concurrent.PriorityBlockingQueue
    
   ```
   接口中的方法为：
   
   ```java
   public interface Queue<E> extends Collection<E> {
       //向队列中添加对象，如果队列满抛出异常
       boolean add(E e);
       //同add，只不过队列满会返回false
       boolean offer(E e);
       //返回队列头部数据并删除，队列为空时抛异常
       E remove();
       //同remove，队列为空时返回null
       E poll();
       //返回对列头部数据，队列为空抛异常
       E element();
       //同element，队列为空返回null   
       E peek();
   }
   ```

   PriorityQueue:
   ```
   ​	PriorityQueue是AbstractQueue的子类, 也是Queue的实现类. PriorityQueue能够实现按照元素的优先级进行排序存储. 
   ​	Priority内部在添加元素和删除元素时都会对队列中的元素进行优先级排序. 如果相应对象实现了comparator方法, 则使用comparator方法对队列中的元素重新排序,
    否则按照自然顺序排序。
   ​	优先队列在扩容时有个特点，当队列size<64时, 会扩容一倍; size>64时, 会扩容50%。
    插入操作：O(1) 取出操作：O(logN)
    底层实现的数据结构多样：比如，heap、bst、treap
   ```
