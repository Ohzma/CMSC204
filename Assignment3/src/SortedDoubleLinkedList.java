import java.util.ListIterator;

/**
 * Implements a generic sorted double list using a provided Comparator. It extends
 * BasicDoubleLinkedList class.
 * 
 * @author Daniel Cortes Gratacos
 *
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
java.util.Comparator<T> comp = null;

/**
 * Creates an empty list that is associated with the specified comparator.
 * 
 * @param comparator - Comparator to compare data elements
 */
public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
comp = comparator2;
}


/**
 * Inserts the specified element at the correct position in the sorted list.
 * 
 * @param data - the data to be added to the list
 * @return reference to the current object
 */
public SortedDoubleLinkedList<T> add(T elem) {
if (null == elem) {
return this;
}

Node newnode = new Node(elem, null, null);
if (null == header) {
header = tail = new Node(elem, null, null);
} else {
if (0 >= comp.compare(elem, header.item)) {
newnode.next = header;
header = newnode;
} else if (0 <= comp.compare(elem, tail.item)) {
tail.next = newnode;
tail = newnode;
} else {
Node next = header.next;
Node prev = header;
while (0 < comp.compare(elem, next.item)) {
prev = next;
next = next.next;
}
prev.next = newnode;
newnode.next = next;
}
}
size++;
return this;
}

/**
 * This operation is invalid for a sorted list.
 * 
 * @param data - the data element to be removed
 * @return reference to the current object
 * @throws UnsupportedOperationException if method is called
 */
@Override
public BasicDoubleLinkedList<T> addToEnd(T data) {
throw new UnsupportedOperationException("Invalid operation for sorted list");
}

/**
 * This operation is invalid for a sorted list.
 * 
 * @param data - the data element to be removed
 * @return reference to the current object
 * @throws UnsupportedOperationException if method is called
 */
@Override
public BasicDoubleLinkedList<T> addToFront(T data) {
throw new UnsupportedOperationException("Invalid operation for sorted list");
}

/**
 * Implements the remove operation by calling the super class remove method.
 * 
 * @param data - the data element to be removed
 * @param comparator - the comparator to determine equality of data elements
 * @return reference to the current object
 */
public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
Node next = header;
Node prev = null;
while (null != next) {
if (0 == comparator.compare(next.item, data)) {
size--;
if (null != prev) {
prev.next = next.next;
} else {
header = next.next;
}
if (tail == next) {
tail = prev;
}
}
prev = next;
next = next.next;
}

return this;

}

/**
 * Implements the iterator by calling the super class iterator method.
 * 
 * @return an iterator positioned at the head of the list
 */
public ListIterator<T> iterator() {
return new iter();
}
}