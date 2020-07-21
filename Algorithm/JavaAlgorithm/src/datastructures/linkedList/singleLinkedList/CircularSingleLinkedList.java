/**
circular single linked list with head node and rear point
**/


package datastructures.linkedList.singleLinkedList;
import datastructures.linkedList.ILinkedList;

public class CircularSingleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected Node<AnyType> head;
    protected Node<AnyType> rear;

    public CircularSingleLinkedList() {
        this.head = new Node<AnyType>(null);
        this.head.next = this.head;
        this.rear = this.head;
    }

    public CircularSingleLinkedList(Node<AnyType> node) {
        this();
        if (node != null) {
            this.head.next = node;
            this.rear = this.rear.next;
            this.rear.next = this.head;
        }
    }

    public CircularSingleLinkedList(AnyType[] array) {
        this();
        if (array.length > 0 && array != null) {
            this.head.next = new Node<AnyType>(array[0], this.head);
            this.rear = this.rear.next;
            int i = 1;
            while (i < array.length) {
                this.rear.next = new Node<AnyType>(array[i++], this.head);
                this.rear = this.rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int length() {
        if (this.head.next != null) {
            int len = 0;
            Node<AnyType> temp = this.head.next;
            while (temp != this.head) {
                len++;
                temp = temp.next;
            }
            return len;
        }
        return 0;
    }

    public AnyType get(int index) {
        if (this.head.next != null && index >= 0) {
            int i = 0;
            Node<AnyType> temp = this.head.next;
            while (i < index && temp != this.head) {
                i++;
                temp = temp.next;
            }
            if (i == index && temp != this.head) {
                return temp.data;
            }
        }
        return null;
    }

    public AnyType set(int index, AnyType data) {
        if (this.head.next != null && index >= 0 && data != null) {
            int i = 0;
            Node<AnyType> temp = this.head.next;
            while (i < index && temp != this.head) {
                i++;
                temp = temp.next;
            }
            if (index == i && temp != this.head) {
                AnyType oldData = temp.data;
                temp.data = data;
                return oldData;
            }
        }
        return null;
    }

    // index : 0 ~ list.length()  可在末尾添加
    public boolean add(int index, AnyType data) {
        if (this.head.next != null && index >= 0 && data != null) {
            Node<AnyType> preNode = this.head;
            int i = 0;
            while (i < index && preNode.next != this.head) {
                i++;
                preNode = preNode.next;
            }
            if (i == index && preNode != this.head) {
                preNode.next = new Node<AnyType>(data, preNode.next);
                if (preNode == this.rear) {
                    this.rear = this.rear.next;
                }
                return true;
            }
        }
        return false;
    }


    // 在尾部添加节点 直接使用尾部指针
    public boolean add(AnyType data) {
        if (this.head.next != null && data != null) {
            this.rear.next = new Node<AnyType>(data, this.head);
            this.rear = this.rear.next;
            return true;
        }
        return false;
    }

    public AnyType remove(int index) {
        if (this.head.next != null && index >= 0) {
            int i = 0;
            Node<AnyType> preNode = this.head;
            while (i < index && preNode.next != this.head) {
                i++;
                preNode = preNode.next;
            }
            if (i == index && preNode.next != this.head) {
                AnyType oldData = preNode.next.data;
                preNode.next = preNode.next.next;
                if (preNode.next == this.head) {
                    this.rear = preNode;
                }
                return oldData;
            }
        }
        return null;
    }

    public boolean removeAll(AnyType data) {
        if (this.head.next != null && data != null) {
            Node<AnyType> preNode = this.head;
            int count = 0;
            while (preNode != this.rear) {
                if (preNode.next.data == data) {
                    count++;
                    if (preNode.next == this.rear) {
                        this.rear = preNode;
                    }
                    preNode.next = preNode.next.next;
                }
                preNode = preNode.next;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.head.next = null;
    }

    public boolean contains(AnyType data) {
        if (this.head.next != null && data != null) {
            Node<AnyType> temp = this.head.next;
            int count = 0;
            while (temp != head) {
                if (temp.data == data) {
                    count++;
                }
                temp = temp.next;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.head.next != null) {
            String str = "(";
            Node<AnyType> temp = this.head.next;
            while (temp != this.rear) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            if (temp == this.rear) {
                str += this.rear.data + ")";
            }
            return str;
        }
        return null;
    }


    public static void main(String[] args) {

        //testing
        String[] str = {"a", "b", "c", "d", "e"};
        //String[] str = {};
        //Node<String> str = new Node<>("head");
        CircularSingleLinkedList<String> list = new CircularSingleLinkedList<>(str);
        //Node<Integer> node = new Node<>(1);
        //CircularSingleLinkedList<Integer> list = new CircularSingleLinkedList<>(node);

        System.out.println("list.isEmpty() is : " + list.isEmpty());
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.length() is : " + list.length());
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.get(index = 0) is " + list.get(0));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.set(index = 4, data = 'head') : " + list.set(4, "head"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.add(index = 2, data = 'a') : " + list.add(2, "a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.add(data = 'a') is : " + list.add("a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        //System.out.println("list.remove(index = 6) is : " + list.remove(5));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.contains(data = 'a') is : " + list.contains("a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        System.out.println("list.removeAll(data = 'a') is : " + list.removeAll("a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data + " | rear.next.next.data = " + list.rear.next.next.data);

        list.clear();
        System.out.println("list.toString() is : " + list.toString());
    }
}
