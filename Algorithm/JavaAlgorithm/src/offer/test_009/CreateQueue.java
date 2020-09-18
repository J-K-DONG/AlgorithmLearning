/*
面试题09. 用两个栈实现队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

*/

import java.util.Stack;

public class CreateQueue {

    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    public CreateQueue() {

    }

    public void appendTail(Integer i) {
        s1.add(i);
    }

    public int deleteHead() {
        if (s1 == null) {
            return -1;
        }
        while (s1.size() != 1) {
            s2.add(s1.pop());
        }


        int temp = s1.pop();
        while (s2.size() != 0) {
            s1.add(s2.pop());
        }
        return temp;
    }

    public static void main(String[] args) {
        CreateQueue cQueue = new CreateQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int head1 = cQueue.deleteHead();
        int head2 = cQueue.deleteHead();
        System.out.println(head2);

    }

}
