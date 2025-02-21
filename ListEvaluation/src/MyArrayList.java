
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

    @SuppressWarnings("unchecked")
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
            throw new IndexOutOfBoundsException("Index out of bound in MyArrayList");
        }

        if (numb_elements == array.length) {
            resize();
        }

        System.arraycopy(array, index, array, index + 1, numb_elements - index);

        array[index] = element;
        numb_elements++;

    }

    // just make size == 0
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (E[]) new Object[Initila_Capacity];
        numb_elements = 0;

    }

    public E remove(int index) {

        if (index < 0 || index >= numb_elements) {
            throw new IndexOutOfBoundsException("Index out of bound in MyArrayList");

        }
        E temp = array[index];

        System.arraycopy(array, index + 1, array, index, numb_elements - index - 1);

        numb_elements--;
        if (numb_elements < array.length / 4) {
            resize();
        }

        return temp;

    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object object) {

        for (int index = 0; index < numb_elements; index++) {
            if (array[index].equals(object)) {
                remove(index);
                return true;
            }
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
            @SuppressWarnings("unchecked")
            E[] tempArr = (E[]) new Object[array.length * 2];

            for (int i = 0; i < numb_elements; i++) {
                tempArr[i] = array[i];
            }
            array = tempArr;

        } else if (array.length / 4 >= numb_elements) {

            //
            @SuppressWarnings("unchecked")
            E[] tempArr = (E[]) new Object[array.length / 2];

            for (int i = 0; i < numb_elements; i++) {
                tempArr[i] = array[i];
            }
            array = tempArr;

        }

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
