/**
Single linked list interface
**/

package datastructures.linkedList;

public interface ILinkedList<AnyType> {

    boolean isEmpty();

    int length();

    AnyType get(int index);

    AnyType set(int index, AnyType data);

    boolean add(int index, AnyType value);

    boolean add(AnyType value);

    AnyType remove(int index);

    boolean removeAll(AnyType value);

    void clear();

    boolean contains(AnyType value);

    String toString();
}
