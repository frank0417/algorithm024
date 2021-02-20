***第三周学习总结***

**1.递归**
  
   ```
   本周的算法都是围绕递归，包括特殊的递归的方法分治、回溯等，需要熟练掌握几种递归的模板，
这个相对容易些，最难有两点，一是如何找到可重复的规律；二是如何确定drill down的参数。觉
得这些都不是通过几天的训练就能搞定的，需要大量的练习和一定的逻辑抽象能力，大家需要坚持啊，
找规律的事本身就不是容易的事，这个和算法、coding的能力没啥关系。
  ```
  **做递归题目的一些方法**
  ```
  画图：画图帮助分析是非常重要的解题方法，画图不是为了人肉递归，而是为了更好的归纳和总结
  优化：分析搜索起点的上界进行剪枝
  ```
**2.需要练到手抽筋的魔法模板**

*  说到模板的事，大家其实记住即可，就像你写代码或看一些开源项目都会用到设计模式一样，一看到
这个代码模块或结构与XXX设计模式模板一样啊，那你再看这块代码的时候就知道它要解决哪类问题，
你要是不了解这个设计模式模板的话，看那些代码会很难理解，会浪费很多时间，大家都这么写，这
就是固定的模式，理解记忆就好，学会了就行了。


*递归*
```java
public void recur(int level, int param) { 
        //terminator
        if (level > MAX_LEVEL){
            // process result
            return;
        }
        //process current logic
        process(level,param);
        //drill down
        recur(level+1,newParam);
        //restore current status
    }
```
*分治*
```java
public int divide_conquer(Problem problem){
        if(problem ==null){
            int res=process_last_result();
            return res;
        }
        subProblems=split_problem(problem);
        res0=divide_conquer(subProblems[0]);
        res1=divide_conquer(subProblems[1]);
        return result;
    }
```
 *回溯*
```
private void backtrace(State state, Data data) {
    if (state.isComplete()) {
        addStateToResult(state);
        return;
    }

    // loop all choice
    while (condition) {
        Data curentData = processData(data);
        state.changeState();
        backtrace(state, data);
        state.rollbackState();
    }
}
```

*迭代*
* 做子集的题迭代算法是非常巧妙的，下边是一个牛顿迭代算法的实现，这个更牛，
不愧是“牛顿”。
```java
pubic int mysqrt(int x){
	double tmpx = x;
	double k = 1.0;
	double k0 = 0.0;
	while(abs(k0-k) >= 1){
		k0 = k;
		k = (k + tmpx/k)/2;
	}
	return (int)k;
}
```
 
**3.最重要的事情重复说**
```
    做过的题要抽空回溯，否则人的记忆是会随着时间的推移丢掉的，每天学习新的课程和练习新题目
 的时候不要忘记做过的题目啊，技术的事不能喜新厌旧哦。
```
 