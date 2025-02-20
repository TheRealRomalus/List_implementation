import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

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
            throw new IndexOutOfBoundsException("Index out of bound add");
        }
        Node<E> tempElement = new Node<E>(element);

        if (index == size) {
            add(element);

        } else {
            Node<E> temp = head;

            while (temp != null && index != 0) {

                temp = temp.nextNode;
                index--;
            }

            tempElement.nextNode = temp;
            tempElement.previousNode = temp.previousNode;
            temp.previousNode.nextNode = tempElement;
            temp.previousNode = tempElement;
            return;

        }

        size++;

    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    public E remove(int index) {

        Node<E> temp = head;

        while (temp != null) {

            if (index == 0) {
                temp.previousNode.nextNode = temp.nextNode;
                temp.nextNode.previousNode = temp.previousNode;
                return temp.data;
            }

            temp = temp.nextNode;
            index--;
        }
        return null;

    }

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
                        temp.previousNode.nextNode = temp.nextNode.previousNode;
                        temp.nextNode.previousNode = temp.previousNode.nextNode;

                    }

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

    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(2);

        System.out.println(test);
        System.out.println((test.remove((Integer) 1)) ? "did find and removed" : "didn't find ");
        System.out.println(test);

        System.out.println(test);
        System.out.println((test.remove((Integer) 2)) ? "did find and removed" : "didn't find ");
        System.out.println(test);
    }
}