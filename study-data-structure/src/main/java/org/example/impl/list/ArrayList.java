package org.example.impl.list;

import org.example.spec.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10; // 기본 용적 크기
    private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

    private int size; // 요소 개수

    Object[] array; // 요소를 담은 배열

    // 생성자1 (초기 공간 할당 X)
    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성자2 (초기 공간 할당 O)
    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    // 요소의 개수와 용적의 크기를 비교하여 배열을 재할당하는 메소
    private void resize() {
        int array_capacity = array.length;

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if (size == array_capacity) {
            int new_capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        if (size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    private void addLast(E value) {
        if (isFull()) {
            resize();
        }
        array[size++] = value;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            addLast(value);
            return;
        }

        if (isFull()) {
            resize();
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    @Override
    public E remove(int index) {
        E find = get(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }

        size--;
        resize();
        return find;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);

        if (index < 0) {
            return false;
        }

        remove(index);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return array.length == size;
    }

    /**
     * 현재 용적량의 기대치에 근접할 수준의 데이터가 재차 할당될 가능성이 높기 때문에
     * 용적량을 절반만 줄인다.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public int size() {
        return size;
    }
}
