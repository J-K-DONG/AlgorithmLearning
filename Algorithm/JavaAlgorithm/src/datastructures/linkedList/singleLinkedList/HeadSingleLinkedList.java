/**
带头节点的单链表 头节点不戴数据 null
**/


package datastructures.linkedList.singleLinkedList;
import datastructures.linkedList.ILinkedList;

public class HeadSingleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected Node<AnyType> head;
    protected Node<AnyType> rear;

    public HeadSingleLinkedList() {
        this.head = new Node<>(null);
        this.rear = head;
    }

    public HeadSingleLinkedList(Node<AnyType> node) {
        this();
        this.head.next = node;
        this.rear = node;
    }

    public HeadSingleLinkedList(AnyType[] array) {
        this();
        if (array != null && array.length > 0) {
            this.head.next = new Node<AnyType>(array[0]);
            this.rear = this.head.next;
            int i = 1;
            while (i < array.length) {
                this.rear.next = new Node<AnyType>(array[i++]);
                this.rear = this.rear.next;
            }
        }
    }

    public HeadSingleLinkedList(HeadSingleLinkedList<AnyType> list) {
        this();
        if (list != null && list.head.next != null) {
            // 从头节点开始
            this.head.next = new Node<AnyType>(list.head.data);
            Node<AnyType> temp = list.head.next;
            this.rear = this.head.next;
            while (temp != null) {
                this.rear.next = new Node<AnyType>(temp.data);
                temp = temp.next;
                this.rear = this.rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int length() {
        int length = 0;
        Node<AnyType> temp = this.head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // index 从 0 开始
    public AnyType get(int index) {
        if (this.head.next == null || index < 0) {
            return null;
        }
        int i = 0;
        Node<AnyType> temp = this.head.next;
        while (i < index && temp != null) {
            temp = temp.next;
            i++;
        }
        if (i == index && temp != null) {
            return temp.data;
        }
        System.out.println("index out of range");
        return null;
    }

    public AnyType set(int index, AnyType data) {
        if (index < 0 || this.head.next == null || data == null) {
            return null;
        }
        int i = 0;
        Node<AnyType> temp = this.head.next;
        while (i < index && temp != null) {
            temp = temp.next;
            i++;
        }
        if (i == index && temp != null) {
            AnyType oldData = temp.data;
            temp.data = data;
            return oldData;
        }
        return null;
    }

    // index 0 ~ list.length()
    //如果增加的是末尾节点 要更新尾指针
    public boolean add(int index, AnyType data) {
        if (index >= 0 && data != null && this.head.next != null) {
            int i = 0;
            Node<AnyType> temp = this.head;
            while (i < index && temp != null) {
                temp = temp.next;
                i++;
            }
            if (i == index && temp != null) {
                temp.next = new Node<AnyType>(data, temp.next);
                if (temp.next.next == null) {
                    this.rear = temp.next;
                }
                return true;
            }
        }
        return false;
    }

    // 从末尾增加节点 使用尾指针 rear 并更新rear
    public boolean add(AnyType data) {
        if (data != null) {
            this.rear.next = new Node<AnyType>(data);
            this.rear = this.rear.next;
            return true;
        }
        return false;
    }

    public AnyType remove(int index) {
        if (index >= 0 && this.head.next != null) {
            int i = 0;
            Node<AnyType> pre = this.head;
            while (i < index && pre.next != null) {
                pre = pre.next;
                i++;
            }
            if (i == index && pre.next != null) {
                AnyType oldData = pre.data;
                pre.next = pre.next.next;
                //如果是末尾节点 要更新尾指针
                if (pre.next == null) {
                    this.rear = pre;
                }
                return oldData;
            }
        }
        return null;
    }

    //如果是末尾节点 要更新尾指针
    public boolean removeAll(AnyType data) {
        if (this.head.next != null && data != null) {
            Node<AnyType> pre = this.head;
            int count = 0;
            while (pre.next != null) {
                if (pre.next.data == data) {
                    count++;
                    pre.next = pre.next.next;
                    if (pre.next == null) {
                        this.rear = pre;
                        break;
                    }
                }
                pre = pre.next;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.head.next = null;
        this.rear = this.head;
    }

    public boolean contains(AnyType data) {
        if (this.head.next != null && data != null) {
            Node<AnyType> temp = this.head.next;
            int count = 0;
            while (temp != null) {
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
            Node<AnyType> temp = this.head.next;
            String str = "(";
            while (temp != null) {
                str += (String)temp.data;
                temp = temp.next;
                if (temp != null) {
                    str += ", ";
                }
            }
            str += ")";
            return str;
        }
        return null;
    }

    public static void main(String[] args) {

        //testing
        String[] str = {"a", "b", "c", "d", "e"};
        //String[] str = {};
        HeadSingleLinkedList<String> list = new HeadSingleLinkedList<>(str);

        //Node<Integer> node = new Node<>(1);
        //HeadSingleLinkedList<Integer> list = new HeadSingleLinkedList<>(node);

        System.out.println("list.isEmpty() is : " + list.isEmpty());
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.length() is : " + list.length());
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.get(index = 4) is " + list.get(4));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.set(index = 2, data = 'a') : " + list.set(2, "a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.add(index = 5, data = '000') : " + list.add(5, "000"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.add(data = 'rear') is : " + list.add("rear"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.remove(index = 6) is : " + list.remove(6));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.removeAll(data = 'a') is : " + list.removeAll("a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        //list.clear();
        //System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);

        System.out.println("list.contains(data = 'a') is : " + list.contains("a"));
        System.out.println(list.toString() + "---------- head.next.data = " + list.head.next.data + " | rear.data = " + list.rear.data);


        System.out.println("list.toString() is : " + list.toString());

    }
}
