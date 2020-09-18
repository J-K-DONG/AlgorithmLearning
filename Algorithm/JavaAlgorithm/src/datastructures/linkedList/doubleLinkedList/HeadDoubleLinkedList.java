/**
double linked list with head node and rear point
**/

package datastructures.linkedList.doubleLinkedList;
import datastructures.linkedList.ILinkedList;


public class HeadDoubleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected DoubleNode<AnyType> head;
    protected DoubleNode<AnyType> rear;

    public HeadDoubleLinkedList() {
        this.head = new DoubleNode<AnyType>(null, null, null);
        this.rear = this.head;
    }

    public HeadDoubleLinkedList(DoubleNode<AnyType> node) {
        this();
        this.head.next = node;
        node.pre = this.head;
        node.next = null;
        this.rear = node;
    }

    public HeadDoubleLinkedList(AnyType[] array) {
        this();
        if (array.length > 0 && array != null) {
            int i = 0;
            while (i < array.length) {
                this.rear.next = new DoubleNode<AnyType>(array[i++], this.rear, null);
                this.rear = this.rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head == this.rear;
    }

    public int length() {
        if (this.head.next != null) {
            DoubleNode<AnyType> temp = this.head.next;
            int len = 0;
            while (temp != null && temp.data != null) {
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
            while (i < index && temp != null) {
                i++;
                temp = temp.next;
            }
            if (i == index && temp != null) {
                return temp.data;
            }
        }
        return null;
    }

    public AnyType set(int index, AnyType data) {
        if (this.head.next != null && index >= 0 && data != null) {
            DoubleNode<AnyType> temp = this.head.next;
            int i = 0;
            while (i < index && temp != null) {
                i++;
                temp = temp.next;
            }
            if (i == index && temp != null) {
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
            while (i < index && preNode != null) {
                i++;
                preNode = preNode.next;
            }
            if (i == index && preNode != null) {
                DoubleNode<AnyType> addNode = new DoubleNode<AnyType>(data, preNode, preNode.next);
                if (preNode.next != null) {
                    preNode.next.pre = addNode;
                    preNode.next = preNode.next.pre;
                } else {  // 在末尾添加节点
                    preNode.next = addNode;
                    this.rear = this.rear.next;
                }
                return true;
            }
        }
        return false;
    }

    // 在尾部添加节点
    public boolean add(AnyType data) {
        if (this.head.next != null && data != null) {
            this.rear.next = new DoubleNode<AnyType>(data, this.rear, null);
            this.rear = this.rear.next;
            return true;
        }
        return false;
    }

    public AnyType remove(int index) {
        if (this.head.next != null && index >= 0) {
            int i = 0;
            DoubleNode<AnyType> preNode = this.head;
            while (i < index && preNode.next != null) {
                i++;
                preNode = preNode.next;
            }
            if (i == index && preNode.next != null) {
                AnyType oldData = null;
                oldData = preNode.next.data;
                if (preNode.next.next != null) {
                    preNode.next.next.pre = preNode;
                    preNode.next = preNode.next.next;
                } else {
                    preNode.next = null;
                    this.rear = preNode;
                }
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
                    if (preNode.next.next != null) {
                        preNode.next.next.pre = preNode;
                        preNode.next = preNode.next.next;
                    } else {
                        preNode.next = null;
                        this.rear = preNode;
                    }
                    count++;
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
            int count = 0;
            DoubleNode<AnyType> temp = this.head.next;
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
            DoubleNode<AnyType> temp = this.head.next;
            String str = "(";
            while (temp != null) {
                str += temp.data;
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


    public String toStringCircular() {
        if (this.head.next != null) {
            DoubleNode<AnyType> temp = this.head.next;
            String str = "(";
            while (temp != this.rear) {
                str += temp.data;
                temp = temp.next;
                if (temp != null) {
                    str += ", ";
                }
            }
            while (temp != this.head) {
                str += temp.data;
                temp = temp.pre;
                if (temp.pre != null) {
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
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        //String[] str = {};
        //<String> str = new DoubleNode<>("node");

        HeadDoubleLinkedList<String> list = new HeadDoubleLinkedList<>(str);


        System.out.println("list.isEmpty()" + list.isEmpty());
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.toString()" + list.toString());
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.length() is : " + list.length());
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.get(index = 10) is : " + list.get(10));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.set(index = 3, data = 'a') is : " + list.set(3, "a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.add(index = 4, data = 'a') is : " + list.add(4, "a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.add(data = 'rear') is : " + list.add("rear"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.remove(index = 5) is : " + list.remove(5));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.contains(data = 'a') is : " + list.contains("a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        System.out.println("list.removeAll(data = 'a') is : " + list.removeAll("a"));
        System.out.println(list.toStringCircular() + " list.head.next.data = " + list.head.next.data + "  list.rear.data = " + list.rear.data);

        list.clear();

        System.out.println(list.toStringCircular() + " list.head.next = " + list.head.next + "  list.rear.data = " + list.rear.data);

    }

}
