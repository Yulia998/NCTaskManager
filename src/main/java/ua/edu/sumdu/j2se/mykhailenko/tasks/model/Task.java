package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс позволяет сохранять,
 * просматривать задачи.
 *
 * @author Юлия Михайленко
 * @version 1.0 28 Октября 2019
 */
public class Task implements Cloneable, Serializable {
    /**
     * Хранится название задачи.
     */
    private String title;
    private LocalDateTime time;
    private LocalDateTime start;
    private LocalDateTime end;
    private int interval;
    private boolean active = true;
    private String id;

    /**
     * Задает название и время
     * выполнения неповторяемой задачи.
     *
     * @param title не должно быть пустым.<br/>
     * @param time  не должен быть отрицательный
     */
    public Task(String title, LocalDateTime time) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.time = time;
    }

    public Task(String title, LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException {
        if (start == null || end == null || interval <= 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getTime() {
        return (isRepeated()) ? start : time;
    }

    public void setTime(LocalDateTime time) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException();
        }
        if (interval > 0) {
            start = null;
            end = null;
            interval = 0;
        }
        this.time = time;
    }

    public LocalDateTime getStartTime() {
        return getTime();
    }

    public LocalDateTime getEndTime() {
        return (isRepeated()) ? end : time;
    }

    public int getRepeatInterval() {
        return (isRepeated()) ? interval : 0;
    }

    public void setTime(LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException {
        if (start == null || end == null || interval <= 0) {
            throw new IllegalArgumentException();
        }
        if (!isRepeated()) {
            time = null;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public boolean isRepeated() {
        return (interval > 0) ? true : false;
    }

    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        if (!active) {
            return null;
        }
        if (!isRepeated()) {
            return (current.isBefore(time)) ? time : null;
        }
        if (!current.isBefore(end)) {
            return null;
        }
        for (LocalDateTime intervalTime = start; !intervalTime.isAfter(end); intervalTime = intervalTime.plusSeconds(interval)) {
            if (intervalTime.isAfter(current)) {
                return intervalTime;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return interval == task.interval &&
                active == task.active &&
                Objects.equals(title, task.title) &&
                Objects.equals(time, task.time) &&
                Objects.equals(start, task.start) &&
                Objects.equals(end, task.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active);
    }

    @Override
    public String toString() {
        String result = "ID: " + id +
                "\nНазвание: " + title;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if (isRepeated()) {
            result += "\nДата начала: " + start.format(formatter) +
                    "\nДата окончания: " + end.format(formatter) +
                    "\nИнтервал в часах: " + interval/3600;
        } else {
            result += "\nДата выполнения: " + time.format(formatter);
        }
        if (isActive()) {
            result += "\nЗадача активная";
        } else {
            result += "\nЗадача неактивная";
        }
        return result;
    }

    public Task clone() {
        try {
            Task task = (Task) super.clone();
            return task;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
