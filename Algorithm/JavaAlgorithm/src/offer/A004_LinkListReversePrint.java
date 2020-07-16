/**
面试题06. 从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
思路和代码：

利用ArrayList顺序保存链表，然后逆序保存到结果数组中返回即可。
**/

/**
int是java提供的8种原始数据类型之一。Java为每个原始类型提供了封装类，
Integer是java为int提供的封装类。int的默认值为0， 而Integer的默认值为null
**/

package offer;
import datastructures.linkedList.singleLinkedList.SingleLinkedList;
import datastructures.linkedList.singleLinkedList.Node;


public class A004_LinkListReversePrint<AnyType> extends SingleLinkedList<AnyType> {

    public A004_LinkListReversePrint() {

    };

    // 单链表 从旧链表的头部依次拆下  然后头插法组成新的链表 然后输出
    public boolean singleLinkListReversePrint(SingleLinkedList<AnyType> list) {
        if (list.isEmpty()) {
            return false;
        }
        Node<AnyType> head = list.removeGetNode(0);
        head.next = null;
        Node<AnyType> temp = head;
        while (!list.isEmpty()) {
            temp = list.removeGetNode(0);
            temp.next = head;
            head = temp;
        }
        SingleLinkedList<AnyType> reverseList = new SingleLinkedList<>(head);
        System.out.println(reverseList.toString());
        return true;
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e", "f"};
        SingleLinkedList<String> list = new SingleLinkedList<>(array);
        System.out.println(list.toString());
        A004_LinkListReversePrint<String> lrp = new A004_LinkListReversePrint<>();
        boolean flag = lrp.singleLinkListReversePrint(list);
        System.out.println(flag);

    }
}
