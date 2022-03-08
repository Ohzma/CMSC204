import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This generic double-linked list relies on a head (reference to first element of the list) and
 * tail (reference to the last element of the list). Both are set to null when the list is empty.
 * Both point to the same element when there is only one element in the list. A node structure has
 * only three fields: data and the prev and next references. The class must only define the
 * following entities: an inner class Node, an inner class that implements ListIterator (for the
 * iterator method), head and tail references and an integer representing the list size. However
 * only the hasNext(), next(), hasPrevious() and previous() methods of ListIterator need to be
 * implemented, all other methods can throw the UnsupportedOperationException. All the entities are
 * defined as protected so they can be accessed by the subclasses.
 * 
 * @author Daniel Cortes Gratacos
 *
 */

public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> {
protected class Node {
protected T item;
protected Node next, previous;

protected Node(T item, Node next, Node previous) {
this.item = item;
this.next = next;
this.previous = previous;
}
}

protected int size;
protected Node header, tail;

public BasicDoubleLinkedList() {

size = 0;
header = tail = null;

}

/**
 * This method just returns the value of the instance variable you use to keep track of size.
 * 
 * @return the size of the linked list
 */
public int getSize() {
return size;
}

/**
 * Returns but does not remove the last element from the list. If there are no elements the method
 * returns null.
 * 
 * @return the data element or null
 */public T getLast() {
return tail.item;
}

/**
 * Returns but does not remove the first element from the list. If there are no elements the
 * method returns null.
 * 
 * @return the data element or null
 */public T getFirst() {
return header.item;
}
 
 /**
  * Removes the first instance of the targetData from the list.
  * 
  * @param targetData - the data element to be removed
  * @param comparator - the comparator to determine equality of data elements
  * @return reference to the current object
  */
public BasicDoubleLinkedList<T> remove(T elem, java.util.Comparator<T> comparator) {
Node prev = null, curr = header;
while (null != curr) {
if (0 == comparator.compare(curr.item, elem)) {
if (header == curr) {
header = header.next;
header = curr;
} else if (tail == curr) {
curr = null;
tail = prev;
prev.next = null;
} else {
prev.next = curr.next;
curr = curr.next;
}
size--;
} else {
prev = curr;
curr = curr.next;
}
}
return this;
}

/**
 * Adds element to the front of the list.
 * 
 * @param data - the data for the Node within the linked list
 * @return reference to the current object
 */
public BasicDoubleLinkedList<T> addToFront(T elem) {

Node tmp = new Node(elem, header, null);
if (null != header) {
header.previous = tmp;
}
header = tmp;
if (null == tail) {
tail = tmp;
}
size++;
return this;
}

/**
 * Adds an element to the end of the list.
 * 
 * @param data - the data for the Node within the linked list
 * @return reference to the current object
 */
public BasicDoubleLinkedList<T> addToEnd(T elem) {

Node tmp = new Node(elem, null, tail);
if (null != tail) {
tail.next = tmp;
}
tail = tmp;
if (null == header) {
header = tmp;
}
size++;
return this;
}

/**
 * Returns an arraylist of the items in the list from head of list to tail of list
 * 
 * @return an arraylist of the items in the list
 */
public ArrayList<T> toArrayList() {
ArrayList<T> temp = new ArrayList<T>();
ListIterator<T> iterator1 = new iter();

while (iterator1.hasNext()) {
temp.add(iterator1.next());
}
return temp;
}

/**
 * Removes and returns the last element from the list. If there are no elements the method returns
 * null.
 * 
 * @return the data element or null
 */
public T retrieveLastElement() {

if (null == header) {
throw new NoSuchElementException("Linked list is empty");

}
Node previousNode = null;
Node currentNode = header;

while (null != currentNode) {
if (currentNode.equals(tail)) {
tail = previousNode;
break;
}
previousNode = currentNode;
currentNode = currentNode.next;
}
size--;
return currentNode.item;
}

/**
 * Removes and returns the first element from the list. If there are no elements the method
 * returns null.
 * 
 * @return the data element or null
 */
public T retrieveFirstElement() {
if (0 == size) {
throw new NoSuchElementException("Linked list is empty");
}
Node tmp = header;
header = header.next;
header.previous = null;
size--;
return tmp.item;
}

/**
 * A Node is a basic unit of a data structure. Node contains data and links to other nodes. This
 * node class is specific for double linked lists because it has a link for the previous and the
 * next node.
 */

/**
 * An iterator for lists that allows the programmer to traverse the list in either direction, and
 * obtain the iterator's current position in the list. Modification options have been disabled.
 */


public class iter implements ListIterator<T> {
private Node current;
private Node last;
public iter()
{
current = header;
last = null;
}
public T next()
{
if(null != current)
{
T returnData = current.item;
last = current;
current = current.next;
if(null != current) { current.previous = last;}
return returnData;
}
else
throw new NoSuchElementException();
}
public boolean hasNext()
{
return null != current;
}
public T previous()
{
if(null != last)
{
current = last;
last= current.previous;
T returnData = current.item;
return returnData;
}
else
throw new NoSuchElementException("No previous elements available in List");
}
public boolean hasPrevious()
{
return null != last;
}
public void set(T elem) {
current.item = elem;
}
@Override
public int nextIndex() {
throw new UnsupportedOperationException();
}

@Override
public int previousIndex() {
throw new UnsupportedOperationException();
}

@Override
public void remove() {
throw new UnsupportedOperationException();
}

@Override
public void add(T e) {
throw new UnsupportedOperationException();

}
}

/**
 * This method implements ListIterator and defines the methods of hasNext(), next(), hasPrevious()
 * and previous().
 * 
 * @return an iterator positioned at the head of the list
 * @throws UnsupportedOperationException When there´s no more elements (at the end of the list and
 *         calling next() or at the beginning of the list and calling previous()).
 * @throws NoSuchElementException If remove(), add(), nextIndex() and previousIndex() and set()
 *         methods are called
 */
public ListIterator<T> iterator() {
return new iter();
}

}