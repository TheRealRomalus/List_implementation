import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {

    private E[] array;
    private int numb_elements;
    private static final int Initila_Capacity = 10;

    public MyArrayList() {
        this(Initila_Capacity);
        numb_elements = 0;

    }

    public MyArrayList(int capacity) {
        if (capacity <= 10) {
            array = (E[]) new Object[Initila_Capacity];

        } else {
            array = (E[]) new Object[capacity];
        }
        numb_elements = 0;
    }

    public boolean add(E element) {
        add(numb_elements, element);

        return true;

    }

    public void add(int index, E element) {

        if (index < 0 || index > numb_elements) {
            throw new IndexOutOfBoundsException("Index out of bound add");
        }

        if (array[index] == null) {
            array[index] = element;
            numb_elements++;
            resize();

        } else {

            add(index + 1, array[index]);
            array[index] = element;

        }

    }

    // just make size == 0
    public void clear() {
        array = (E[]) new Object[Initila_Capacity];
        numb_elements = 0;

    }

    public E remove(int index) {

        if (index < 0 || index >= numb_elements) {
            throw new IndexOutOfBoundsException("Index out of bound in remove");
        }

        E temp = array[index];

        for (int i = index; i < numb_elements; i++) {
            array[i] = array[i + 1];
        }
        numb_elements--;
        resize();

        return temp;

    }

    public boolean remove(Object object) {

        int index = 0;
        while (array[index] != null) {
            if (array[index].equals((E) object)) {
                return (remove(index) != null);

            }
            index++;
        }

        return false;

    }

    public int size() {
        return numb_elements;
    }

    public String toString() {

        String result = "[";

        for (E i : array) {
            if (i != null) {
                result += i + ", ";
            }

        }

        if (numb_elements != 0) {
            result = result.substring(0, result.length() - 2);

        }

        return result + "]";

    }

    public void resize() {

        if (array.length / 2 <= numb_elements) {

            // double size
            E[] tempArr = (E[]) new Object[array.length * 2];

            for (int i = 0; i < numb_elements; i++) {
                tempArr[i] = array[i];
            }
            array = tempArr;

        } else if (array.length / 4 >= numb_elements) {

            //
            E[] tempArr = (E[]) new Object[array.length / 2];

            for (int i = 0; i < numb_elements; i++) {
                tempArr[i] = array[i];
            }
            array = tempArr;

        }

    }

    public void lenght() {
        System.out.println("array length; " + array.length);
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

        MyArrayList<String> test = new MyArrayList<>();

        test.lenght();
        test.add("eoiw");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("eoiw");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("ppp");
        test.lenght();

        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();
        test.remove(0);
        test.lenght();

        test.lenght();
        test.add("eoiw");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("eoiw");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("hello");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("ppp");
        test.lenght();
        test.add("ppp");
        test.lenght();

        System.out.println(test);
        System.out.println(test.size());

    }

}
