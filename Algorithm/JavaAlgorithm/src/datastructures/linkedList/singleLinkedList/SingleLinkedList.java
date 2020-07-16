/**
Single linked list structure
无头节点 无尾指针 单向链表
**/

package datastructures.linkedList.singleLinkedList;
import datastructures.linkedList.ILinkedList;


public class SingleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected Node<AnyType> head;

    public SingleLinkedList(Node<AnyType> head) {
        this.head = head;
    }

    public SingleLinkedList() {

    }
    //AnyType array to singleLinkedList
    public SingleLinkedList(AnyType[] array) {
        this.head = null;
        if (array.length > 0 && array != null) {
            this.head = new Node<AnyType>(array[0]);
            int i = 1;
            Node<AnyType> rear = this.head;
            while (i < array.length) {
                rear.next = new Node<AnyType>(array[i]);
                i++;
                rear = rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int length() {
        int len = 0;
        Node<AnyType> temp = this.head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public AnyType get(int index) {
        if (this.head != null && index >= 0) {
            int i = 0;
            Node<AnyType> temp = this.head;
            while (temp != null && i < index) {
                temp = temp.next;
                i++;
            }
            if (temp != null) {
                return temp.data;
            }
        }
        return null;
    }

    public AnyType set(int index, AnyType data) {
        if (index < 0 || this.head == null || data == null) {
            System.out.println("index error or list is empty or data error");
            return null;
        }
        int i = 0;
        Node<AnyType> temp = this.head;
        while (temp != null && i < index) {
            temp = temp.next;
            i++;
        }
        if (temp != null) {
            AnyType oldData = temp.data;
            temp.data = data;
            return oldData;
        }
        System.out.println("index out of range");
        return null;

    }


    public boolean add(int index, AnyType data) {
        if (index < 0 || data == null) {
            System.out.println("index error or data error");
            return false;
        }

        //index == 0
        if (index == 0) {
            this.head  = new Node<AnyType>(data, this.head);
            return true;
        }
        // index > 0
        int i = 0;
        Node<AnyType> temp = this.head;
        while (temp != null && i < index - 1) {
            temp = temp.next;
            i++;
        }
        if (temp != null) {
            temp.next = new Node<AnyType>(data, temp.next);
            return true;
        }
        System.out.println("index out of range");
        return false;

    }

    //index == SingleLinkedList.length
    public boolean add(AnyType data) {
        if (data == null) {
            System.out.println("data error");
            return false;
        }
        if (this.head == null) {
            this.head = new Node<AnyType>(data);
        }
        else {
            Node<AnyType> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<AnyType>(data);
        }
        return true;
    }

    public AnyType remove(int index) {
        if (this.head == null || index < 0) {
            System.out.println("head is null or index error");
            return null;
        }
        AnyType removed = null;
        if (index == 0) {
            removed = this.head.data;
            this.head = this.head.next;
            return removed;
        }
        int i = 0;
        Node<AnyType> temp = this.head;
        while (temp.next != null && i < index - 1) {
            temp = temp.next;
            i++;
        }
        if (temp.next != null) {
            removed = temp.next.data;
            temp.next = temp.next.next;
            return removed;
        }
        System.out.println("index out of range");
        return null;
    }

    public boolean removeAll(AnyType data) {
        if (this.head == null || data == null) {
            return false;
        }
        int count = 0;

        Node<AnyType> temp = this.head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                count++;
            }
            temp = temp.next;
        }
        if (this.head.data.equals(data)) {
            count++;
            this.head = this.head.next;
        }
        System.out.println("remove " + count + " data");
        return true;
    }

    /**
    删除并拿到指定节点
    **/
    public Node<AnyType> removeGetNode(int index) {
        if (this.head == null || index < 0) {
            return null;
        }
        Node<AnyType> temp = this.head;

        if (index == 0) {
            this.head = temp.next;
            return temp;
        }
        int i = 0;
        while (i < index - 1 && temp.next != null) {
            i++;
            temp = temp.next;
        }
        if (temp != null) {
            Node<AnyType> res = temp.next;
            temp.next = temp.next.next;
            return res;
        }
        return null;
    }

    public void clear() {
        this.head = null;
    }

    public boolean contains(AnyType data) {
        if (this.head == null || data == null) {
            System.out.println("");
            return false;
        }
        int index = 0;
        Node<AnyType> temp = this.head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
            index++;
        }
        return false;
    }

    public String toString() {
        String str = "(";
        Node<AnyType> temp = this.head;
        while (temp != null) {
            str += temp.data;
            temp = temp.next;
            if (temp != null) {
                str += ", ";
            }
        }
        return str + ")";
    }


    public static void main(String[] args) {
        String[] letters={"A", "B", "C", "D", "E", "F"};
        //Integer[] letters = {1,2,3,4};
        //float[] letters = {1,2,3};
        //char[] letters = {'1', '2'};

        SingleLinkedList<String> list = new SingleLinkedList<>(letters);
        boolean flag = list.isEmpty();
        System.out.println(flag);
        flag = list.add("G");
        flag = list.add(6, "H");
        String data = list.remove(1);
        System.out.println(data);
        flag = list.removeAll("A");
        String res = list.toString();
        System.out.println(res);
        System.out.println(list.length());
        System.out.println(list.get(2));
        System.out.println(list.contains("1"));

        System.out.println(list.head.data);
        System.out.println(list.removeGetNode(0).data);
        System.out.println(list.toString());
    }

}
