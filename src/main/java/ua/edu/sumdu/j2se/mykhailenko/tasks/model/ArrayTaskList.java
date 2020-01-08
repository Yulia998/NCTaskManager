package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import java.util.*;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList {
    private Task[] list = new Task[10];
    private int size;

    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }
        if (size == list.length) {
            list = Arrays.copyOf(list, (int) (list.length * 1.5));
        }
        list[size] = task;
        size++;
    }

    public boolean remove(Task task) {
        boolean removed = false;
        for (int i = 0, j = i; j < size; i++, j++) {
            if (!removed && list[i].equals(task)) {
                j++;
                removed = true;
            }
            list[i] = list[j];
        }
        if (removed) {
            list[size - 1] = null;
            size--;
        }
        return removed;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public AbstractTaskList createInstance() {
        return new ArrayTaskList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return size == that.size &&
                Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }

    public ArrayTaskList clone() {
        try {
            ArrayTaskList arrayTaskList = (ArrayTaskList) super.clone();
            arrayTaskList.list = Arrays.copyOf(list, list.length);
            return arrayTaskList;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Stream<Task> getStream() {
        return Stream.of(list);
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Task next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return list[currentIndex++];
            }

            @Override
            public void remove() {
                if (currentIndex == 0) {
                    throw new IllegalStateException();
                }
                ArrayTaskList arrayTaskList = new ArrayTaskList();
                arrayTaskList.list = list;
                arrayTaskList.size = size;
                Task removeTask = list[--currentIndex];
                arrayTaskList.remove(removeTask);
                size--;
            }
        };
    }
}
