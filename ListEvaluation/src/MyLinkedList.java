import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

    @SuppressWarnings("hiding")
    private class Node<E> {
        private E data;
        private Node<E> nextNode;
        private Node<E> previousNode;

        public Node(E data) {
            this.data = data;
            this.nextNode = null;
            this.previousNode = null;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public MyLinkedList() {

        head = new Node<E>(null);
        tail = head;
        size = 0;
    }

    public boolean add(E e) {

        Node<E> temp = new Node<E>(e);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.nextNode = temp;
            temp.previousNode = tail;
            tail = temp;

        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound in MyLinkedList");

        }

        Node<E> newNode = new Node<>(element);

        if (index == 0) {
            newNode.nextNode = head;
            if (head != null) {
                head.previousNode = newNode;
            }
            head = newNode;

            if (size == 0) {
                tail = newNode;
            }
        }

        else if (index == size) {
            add(element);
            return;
        } else {
            Node<E> temp = head;
            if (index < size / 2) {
                temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.nextNode;
                }
            } else {
                for (int i = 0; i < index; i++) {
                    temp = temp.nextNode;
                }

            }

            newNode.nextNode = temp;
            newNode.previousNode = temp.previousNode;
            temp.previousNode.nextNode = newNode;
            temp.previousNode = newNode;
        }

        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound in MyLinkedList");
        }

        Node<E> temp = head;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.nextNode;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previousNode;
            }
        }

        if (index == 0) {
            E data = head.data;
            head = head.nextNode;
            if (head != null) {
                head.previousNode = null;
            } else {
                tail = null;
            }
            size--;
            return data;
        }

        for (int i = 0; i < index; i++) {
            temp = temp.nextNode;
        }

        if (temp == tail) {
            tail = tail.previousNode;
            if (tail != null) {
                tail.nextNode = null;
            }
        }

        else {
            temp.previousNode.nextNode = temp.nextNode;
            temp.nextNode.previousNode = temp.previousNode;
        }

        size--;
        return temp.data;
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {

        Node<E> temp = head;
        while (temp != null) {
            if (temp.data != null) {
                if (temp.data.equals((E) o)) {

                    if (temp.nextNode == null) {
                        temp.previousNode.nextNode = null;
                        tail = temp.previousNode;

                    } else if (temp.previousNode == null) {
                        temp.nextNode.previousNode = null;
                        head = temp.nextNode;

                    } else {
                        temp.previousNode.nextNode = temp.nextNode;
                        temp.nextNode.previousNode = temp.previousNode;

                    }
                    size--;

                    break;
                }
            }

            temp = temp.nextNode;

        }

        return temp != null ? true : false;
    }

    public int size() {
        return size;
    }

    public String toString() {

        String result = "{";
        Node<E> temp = head;

        while (temp != null) {
            if (temp.data != null) {
                result += temp.data;
                result += "<--->";
            }

            temp = temp.nextNode;

        }

        return result.substring(0, result.length() - 5) + "}";

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

}