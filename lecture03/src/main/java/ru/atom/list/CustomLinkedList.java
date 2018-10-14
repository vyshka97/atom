package ru.atom.list;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;


public class CustomLinkedList<E> implements List<E> {

    private int size;
    private ListNode<E> head;

    private ListNode<E> node(int index) {

        if (head == null) {
            return null;
        }

        ListNode<E> current;
        int counter = 0;

        for (current = head; current.getNext() != head && counter != index; current = current.getNext()) {
            counter++;
        }

        return (counter == index) ? current : null;
    }

    private ListNode<E> node(Object o) {

        if (head == null) {
            return null;
        }

        ListNode<E> current;

        for (current = head; current.getNext() != head && !current.getData().equals(o); current = current.getNext());

        return (current.getData().equals(o)) ? current : null;
    }

    private void eraseListNode(ListNode<E> listNode) {
        ListNode<E> next = listNode.getNext();
        ListNode<E> prev = listNode.getPrev();

        listNode.setNext(null);
        listNode.setPrev(null);

        if (listNode == head) {
            if (next == head) {
                head = null;
            } else {
                head = next;
                next.setPrev(prev);
                prev.setNext(next);
            }
        } else {
            next.setPrev(prev);
            prev.setNext(next);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return node(o) != null;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomLinkedListIterator<>(this);
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new ListNode<>(e, null, null);
            head.setPrev(head);
            head.setNext(head);
            return true;
        }

        ListNode<E> last = head.getPrev();
        ListNode<E> newListNode = new ListNode<>(e, last, head);
        last.setNext(newListNode);
        head.setPrev(newListNode);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListNode<E> foundLIstNode = node(o);

        if (foundLIstNode == null) {
            return false;
        }

        eraseListNode(foundLIstNode);

        return true;
    }

    @Override
    public void clear() {
        for (ListNode<E> current = head; current.getNext() != head; current = current.getNext()) {
            eraseListNode(current);
        }
    }

    @Override
    public E get(int index) {
        ListNode<E> foundListNode = node(index);

        return (foundListNode != null) ? foundListNode.getData() : null;
    }

    @Override
    public int indexOf(Object o) {
        if (head == null) {
            return -1;
        }

        ListNode<E> current;
        int counter = 0;

        for (current = head; current.getNext() != head && !current.getData().equals(o); current = current.getNext()) {
            counter++;
        }

        return (current.getData().equals(o)) ? counter : -1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }

        return true;
    }

    public static class CustomLinkedListIterator<E> implements Iterator<E> {

        private CustomLinkedList<E> customLinkedList;
        private ListNode<E> current;

        public CustomLinkedListIterator(CustomLinkedList<E> customLinkedList) {
            this.customLinkedList = customLinkedList;
            current = customLinkedList.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == customLinkedList.head && current.getNext() == customLinkedList.head) {
                current = null;
                return customLinkedList.head.getData();
            }

            if (current.getNext() == customLinkedList.head) {
                E data = current.getData();
                current = null;
                return data;
            }

            E data = current.getData();
            current = current.getNext();
            return data;
        }
    }


    /*
      !!! Implement methods below Only if you know what you are doing !!!
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return true;
            }
        }
        return true;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public void add(int index, E element) {
    }

    /**
     * Do not implement
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Do not implement
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public E set(int index, E element) {
        return null;
    }
}
