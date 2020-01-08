package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedTaskList extends AbstractTaskList {
    private Node firstNode;
    private Node lastNode;
    private int size;

    public LinkedTaskList() {
        lastNode = new Node(null, firstNode, null);
        firstNode = new Node(null, null, lastNode);
    }

    public void add(Task task) {
        Node prev = lastNode;
        prev.currentElement = task;
        lastNode = new Node(null, prev, null);
        prev.nextElement = lastNode;
        size++;
    }

    public boolean remove(Task task) {
        boolean removed = false;
        Node result = firstNode;
        for (int i = 0; i < size; i++) {
            result = result.nextElement;
            if (result.currentElement.equals(task)) {
                removed = true;
                if (result.prevElement == null) {
                    firstNode.nextElement = result.nextElement;
                    if (size != 1) {
                        result.nextElement.prevElement = null;
                    } else {
                        lastNode.prevElement=firstNode;
                    }
                } else if (result.nextElement == null) {
                    lastNode.prevElement = result.prevElement;
                } else {
                    result.prevElement.nextElement = result.nextElement;
                    result.nextElement.prevElement = result.prevElement;
                }
                size--;
                break;
            }
        }
        return removed;
    }

    public Task getTask(int index) {
        Node result = firstNode.nextElement;
        for (int i = 0; i < index; i++) {
            result = result.nextElement;
        }
        return result.currentElement;
    }

    public int size() {
        return size;
    }

    public AbstractTaskList createInstance() {
        return new LinkedTaskList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        if (size != that.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!getTask(i).equals(that.getTask(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 31 * Objects.hash(size);
        for (int i = 0; i < size; i++) {
            hash += getTask(i).hashCode();
        }
        return hash;
    }

    public LinkedTaskList clone() {
        try {
            LinkedTaskList linkedTaskList = (LinkedTaskList) super.clone();
            linkedTaskList.lastNode = new Node(null, linkedTaskList.firstNode, null);
            linkedTaskList.firstNode = new Node(null, null, linkedTaskList.lastNode);
            linkedTaskList.lastNode.prevElement = linkedTaskList.firstNode;
            linkedTaskList.size = 0;
            for (int i = 0; i < size; i++) {
                linkedTaskList.add(getTask(i));
            }
            return linkedTaskList;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Stream<Task> getStream() {
       Iterable<Task> iterable = () -> iterator();
       return StreamSupport.stream(iterable.spliterator(), false);
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
                return getTask(currentIndex++);
            }

            @Override
            public void remove() {
                if (currentIndex == 0) {
                    throw new IllegalStateException();
                }
                LinkedTaskList linkedTaskList = new LinkedTaskList();
                linkedTaskList.firstNode = firstNode;
                linkedTaskList.lastNode = lastNode;
                linkedTaskList.size = size;
                Task removeTask = getTask(--currentIndex);
                linkedTaskList.remove(removeTask);
                size--;
            }
        };
    }

    private class Node {
        private Task currentElement;
        private Node nextElement;
        private Node prevElement;

        public Node(Task currentElement, Node prevElement, Node nextElement) {
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }
    }
}
