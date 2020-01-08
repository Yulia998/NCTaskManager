package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

public class Tasks {
    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {
        return new Iterable<Task>() {
            @Override
            public Iterator<Task> iterator() {
                Stream<Task> stream = StreamSupport.stream(tasks.spliterator(), false);
                Iterator<Task> iterator = stream.filter(task -> task != null
                        && task.nextTimeAfter(start) != null && !task.nextTimeAfter(start).isAfter(end))
                        .iterator();
                return iterator;
            }
        };
    }

    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        SortedMap<LocalDateTime, Set<Task>> sortedMap = new TreeMap<>();
        Set<Task> set;
        LocalDateTime current;
        for (Task task:tasks) {
            current = task.nextTimeAfter(start.minusNanos(1));
            while (current != null && !current.isAfter(end)) {
                    if (sortedMap.containsKey(current)) {
                        sortedMap.get(current).add(task);
                    }
                    else {
                        set = new HashSet<>();
                        set.add(task);
                        sortedMap.put(current, set);
                    }
                    current = task.nextTimeAfter(current);
                }
        }
        return sortedMap;
    }
}
