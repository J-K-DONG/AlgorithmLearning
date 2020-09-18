/**
double linked list with head point
**/


package datastructures.linkedList.doubleLinkedList;
import datastructures.linkedList.ILinkedList;

public class DoubleLinkedList<AnyType> implements ILinkedList<AnyType> {
    protected DoubleNode<AnyType> head;

    public DoubleLinkedList() {

    }

    public DoubleLinkedList(DoubleNode<AnyType> head) {
        this.head = head;
        this.head.pre = null;
    }

    public DoubleLinkedList(AnyType[] array) {
        this.head = null;
        if (array.length > 0 && array != null) {
            this.head = new DoubleNode<AnyType>(array[0]);
            this.head.pre = null;
            DoubleNode<AnyType> rear = this.head;
            DoubleNode<AnyType> pre = this.head;
            int i = 1;
            while (i < array.length) {
                rear.next = new DoubleNode<AnyType>(array[i++]);
                rear = rear.next;
                rear.pre = pre;
                pre = pre.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int length() {
        if (this.head != null) {
            int length = 0;
            DoubleNode<AnyType> temp = this.head;
            while (temp != null) {
                temp = temp.next;
                length++;
            }
            return length;
        }
        return 0;
    }

    public AnyType get(int index) {
        if (index >= 0 && this.head != null) {
            int i = 0;
            DoubleNode<AnyType> temp = this.head;
            while (i < index && temp != null) {
                temp = temp.next;
                i++;
            }
            if (i == index && temp != null) {
                return temp.data;
            }
        }
        return null;
    }

    public AnyType set(int index, AnyType data) {
        if (index >= 0 && this.head != null && data != null) {
            int i = 0;
            DoubleNode<AnyType> temp = this.head;
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
        if (index >= 0 && this.head != null && data != null) {
            if (index == 0) {
                this.head.pre = new DoubleNode<AnyType>(data, null, this.head);  // (data, pre, next)
                this.head = this.head.pre;
                return true;
            }else {
                DoubleNode<AnyType> temp = this.head;
                int i = 0;
                while (i < index - 1 && temp != null) {  // 找到目标位置的前一个节点
                    i++;
                    temp = temp.next;
                }
                if (i == index - 1 && temp != null) {
                    if (temp.next == null) {  // 在末尾添加节点
                        temp.next = new DoubleNode<AnyType>(data, temp, null);
                    } else {
                        temp.next.pre = new DoubleNode<>(data, temp, temp.next);
                        temp.next = temp.next.pre;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //默认在末尾添加节点
    public boolean add(AnyType data) {
        if (this.head != null && data != null) {
            DoubleNode<AnyType> preNode = this.head;
            while (preNode.next != null) {
                preNode = preNode.next;
            }
            preNode.next = new DoubleNode<AnyType>(data, preNode);
            return true;
        }
        return false;
    }

    public AnyType remove(int index) {
        if (index >=0 && this.head != null) {
            if (index == 0) {
                this.head = this.head.next;
                this.head.pre = null;
            } else {
                // 找到要删除的前一个节点
                int i = 0;
                DoubleNode<AnyType> preNode = this.head;
                while (i < index - 1 && preNode.next != null) {
                    i++;
                    preNode = preNode.next;
                }
                if (i == index - 1 && preNode.next != null) {
                    AnyType oldData = preNode.next.data;
                    if (preNode.next.next == null) {  // 末尾节点
                        preNode.next = null;
                    } else {  // 不是末尾节点
                        preNode.next.next.pre = preNode;
                        preNode.next = preNode.next.next;
                    }
                    return oldData;
                }
            }
        }
        return null;
    }

    public boolean removeAll(AnyType data) {
        if (this.head != null && data != null) {
            DoubleNode<AnyType> preNode = this.head;  // 从第 1 号节点开始检查 （标号从 0 开始）
            int count = 0;
            while (preNode.next != null)
            {
                if (preNode.next.data == data) {
                    count++;
                    if (preNode.next.next == null) {
                        preNode.next = null;
                    } else {
                        preNode.next.next.pre = preNode;
                        preNode.next = preNode.next.next;
                    }
                }
                else {
                    preNode = preNode.next;
                }
            }
            if (this.head.data == data) {
                count++;
                this.head = this.head.next;
                this.head.pre = null;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.head = null;
    }

    public boolean contains(AnyType data) {
        if (this.head != null && data != null) {
            DoubleNode<AnyType> temp = this.head;
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
        if (this.head != null) {
            String str = "(";
            DoubleNode temp = this.head;
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

    public String toStringCircular() {
        if (this.head != null) {
            String str = "(";
            DoubleNode temp = this.head;
            while (temp.next != null) {
                str += (String)temp.data;
                temp = temp.next;
                if (temp != null) {
                    str += ", ";
                }
            }
            while (temp != null) {
                str += (String)temp.data;
                temp = temp.pre;
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
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        //String[] str = {};
        //DoubleNode<String> str = new DoubleNode<>("node");

        DoubleLinkedList<String> list = new DoubleLinkedList<>(str);

        System.out.println("list.isEmpty()" + list.isEmpty());
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.toString()" + list.toString());
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.length() is : " + list.length());
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.get(index = 4) is : " + list.get(0));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.set(index = 3, data = 'a') is : " + list.set(3, "a"));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.add(index = 4, data = 'a') is : " + list.add(4, "a"));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.add(data = 'rear') is : " + list.add("rear"));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.remove(index = 5) is : " + list.remove(5));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.contains(data = 'a') is : " + list.contains("a"));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);

        System.out.println("list.removeAll(data = 'a') is : " + list.removeAll("a"));
        System.out.println(list.toStringCircular() + " list.head.data = " + list.head.data + "  list.head.pre = " + list.head.pre);


        list.clear();
        System.out.println(list.toStringCircular() + " list.head = " + list.head);

    }

}
