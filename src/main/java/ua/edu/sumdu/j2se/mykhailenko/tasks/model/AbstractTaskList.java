package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Cloneable, Serializable {
    public abstract void add(Task task) throws NullPointerException;

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index) throws IndexOutOfBoundsException;

    public abstract AbstractTaskList createInstance();

    public abstract Stream<Task> getStream();

    @Override
    public String toString() {
        String vyvod = "   Список задач:";
        for (int i = 0; i < size(); i++) {
            vyvod += '\n' + getTask(i).toString() +
                    "\n-------------------------";
        }
        return vyvod;
    }

//    public AbstractTaskList incoming(int from, int to) {
//        AbstractTaskList incoming = createInstance();
//        getStream().filter(task -> task != null
//                            && task.nextTimeAfter(from) != -1 && task.nextTimeAfter(from) <= to)
//                            .forEach(incoming::add);
//
//
//        return incoming;
//    }
}
