package ru.atom.list;

import java.util.Objects;

/**
 * Contains ref to next node, prev node and value
 */
public class ListNode<E> {

    private E data;
    private ListNode<E> next;
    private ListNode<E> prev;

    public ListNode(E data, ListNode<E> prev, ListNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(data, listNode.data);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<E> prev) {
        this.prev = prev;
    }
}
