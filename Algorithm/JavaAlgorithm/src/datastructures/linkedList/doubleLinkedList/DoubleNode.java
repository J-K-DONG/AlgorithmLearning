/**
node of double linked list
**/
package datastructures.linkedList.doubleLinkedList;

public class DoubleNode<AnyType> {
    public DoubleNode<AnyType> next;
    public DoubleNode<AnyType> pre;
    public AnyType data;

    public DoubleNode(AnyType data) {
        this.data = data;
        this.next = null;
        this.pre = null;
    }

    public DoubleNode(AnyType data, DoubleNode<AnyType> pre) {
        this.data = data;
        this.next = null;
        this.pre = pre;
    }

    public DoubleNode(AnyType data, DoubleNode<AnyType> pre, DoubleNode<AnyType> next) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }
}
