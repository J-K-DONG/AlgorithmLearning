/**
Single linked list interface
**/

package datastructures.linkedList;

public interface ILinkedList<AnyType> {

    boolean isEmpty();

    int length();

    AnyType get(int index);

    AnyType set(int index, AnyType data);

    boolean add(int index, AnyType data);

    boolean add(AnyType data);

    AnyType remove(int index);

    boolean removeAll(AnyType data);

    void clear();

    boolean contains(AnyType data);

    String toString();
}
