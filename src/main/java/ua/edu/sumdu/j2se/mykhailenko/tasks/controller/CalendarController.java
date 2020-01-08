package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Tasks;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.CalendarView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.SortedMap;

public class CalendarController extends Controller {
    public CalendarController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        CalendarView calendarView = (CalendarView) view;
        LocalDateTime start = calendarView.inputDateFrom();
        LocalDateTime end = calendarView.inputDateTo();
        SortedMap<LocalDateTime, Set<Task>> calendar = Tasks.calendar(taskList, start, end);
        String output = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (SortedMap.Entry<LocalDateTime, Set<Task>> element : calendar.entrySet()) {
            output += "\n\t" + element.getKey().format(formatter) + "\n";
            for (Task task : element.getValue()) {
                output += task + "\n-------------------\n";
            }
        }
        return calendarView.printInfo(output);
    }
}
