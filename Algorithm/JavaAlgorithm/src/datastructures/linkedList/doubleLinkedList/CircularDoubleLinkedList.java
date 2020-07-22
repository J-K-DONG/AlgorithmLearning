/**
circular double linked list with head node and rear point
**/

package datastructures.linkedList.doubleLinkedList;
import datastructures.linkedList.ILinkedList;

public class CircularDoubleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected DoubleNode<AnyType> head;
    protected DoubleNode<AnyType> rear;

    public CircularDoubleLinkedList() {
        this.head = new DoubleNode<AnyType>(null);
        this.rear = this.head;
    }

    public CircularDoubleLinkedList(AnyType[] array) {
        this();
        if (array.length > 0 && array != null) {
            int i = 0;
            while (i < array.length && array[i] != null) {
                this.rear.next = new DoubleNode<AnyType>(array[i++], this.rear, this.head);
                this.rear = this.rear.next;
                this.head.pre = this.rear;
            }
        }
    }


    public boolean isEmpty() {
        return this.head == this.rear;
    }

    public int length() {
        if (this.head.next != null) {
            int len = 0;
            DoubleNode<AnyType> temp = this.head.next;
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
            DoubleNode<AnyType> temp = this.head.next;
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
            DoubleNode<AnyType> temp = this.head.next;
            while (i < index && temp != this.head) {
                i++;
                temp = temp.next;
            }
            if (i == index && temp != this.head) {
                AnyType oldData = temp.data;
                temp.data = data;
                return oldData;
            }
        }
        return null;
    }

    public boolean add(int index, AnyType data) {
        if (this.head.next != null && index >= 0 && data != null) {
            int i = 0;
            DoubleNode<AnyType> preNode = this.head;
            while (i < index && preNode != this.rear) {
                i++;
                preNode = preNode.next;
            }
            if (i == index) {
                preNode.next.pre = new DoubleNode<AnyType>(data, preNode, preNode.next);
                preNode.next = preNode.next.pre;
                if (this.rear == preNode) {
                    this.rear = this.rear.next;
                }
                return true;
            }
        }
        return false;
    }

    // 末尾添加节点
    public boolean add(AnyType data) {
        if (this.head.next != null && data != null) {
            DoubleNode<AnyType> preNode = this.head;
            while (preNode != this.rear) {
                preNode = preNode.next;
            }
            if (preNode == this.rear) {
                preNode.next.pre = new DoubleNode<AnyType>(data, preNode, preNode.next);
                preNode.next = preNode.next.pre;
                this.rear = this.rear.next;
                return true;
            }
        }
        return false;
    }

    public AnyType remove(int index) {
        if (this.head.next != null && index >= 0) {
            int i = 0;
            DoubleNode<AnyType> preNode = this.head;
            while (i < index && preNode != this.rear) {
                i++;
                preNode = preNode.next;
            }
            if (i == index && preNode != this.rear) {
                if (preNode.next == this.rear) {
                    this.rear = preNode;
                }
                AnyType oldData = preNode.next.data;
                preNode.next.next.pre = preNode;
                preNode.next = preNode.next.next;
                return oldData;
            }
        }
        return null;
    }

    public boolean removeAll(AnyType data) {
        if (this.head.next != null && data != null) {
            DoubleNode<AnyType> preNode = this.head;
            int count = 0;
            while (preNode != this.rear) {
                if (preNode.next.data == data) {
                    count++;
                    if (preNode.next == this.rear) {
                        this.rear = preNode;
                    }
                    preNode.next.next.pre = preNode;
                    preNode.next = preNode.next.next;
                } else {
                    preNode = preNode.next;
                }
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
            DoubleNode<AnyType> temp = this.head.next;
            int count = 0;
            while (temp != this.head) {
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
            DoubleNode<AnyType> temp = this.head.next;
            String str = "(";
            while (temp != this.head) {
                str += temp.data;
                temp = temp.next;
                if (temp != this.head) {
                    str += ", ";
                }
            }
            str += ")";
            return str;
        }
        return null;
    }

    public String toStringCircular() {
        if (this.head.next != null) {
            DoubleNode<AnyType> temp = this.head.next;
            String str = "(";
            while (temp != this.rear) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            while (temp != this.head) {
                str += temp.data;
                temp = temp.pre;
                if (temp != this.head) {
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
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        //String[] str = {};

        CircularDoubleLinkedList<String> list = new CircularDoubleLinkedList<>(str);

        System.out.println("list.isEmpty()" + list.isEmpty());
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.toString()" + list.toString());
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.length() is : " + list.length());
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.get(index = 0) is : " + list.get(0));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.set(index = 3, data = 'a') is : " + list.set(3, "a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.add(index = 4, data = 'a') is : " + list.add(4, "a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.add(data = 'rear') is : " + list.add("rear"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.remove(index = 5) is : " + list.remove(5));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.contains(data = 'a') is : " + list.contains("a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.removeAll(data = 'a') is : " + list.removeAll("a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " +  list.head.next.data + " list.head.pre.data = " + list.head.pre.data + "  list.rear.data = " + list.rear.data);

        list.clear();

        System.out.println(list.toStringCircular());

    }
}
