package datastructures.linkedList.singleLinkedList;

public class Node<AnyType> {
    public Node<AnyType> next;
    public AnyType data;

    public Node() {
    }

    public Node(AnyType data) {
        this.data = data;
        this.next = null;
    }

    public Node(AnyType data, Node<AnyType> next) {
        this.data = data;
        this.next = next;
    }
}
