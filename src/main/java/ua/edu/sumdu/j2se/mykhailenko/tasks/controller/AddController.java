package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.AddView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AddController extends Controller {
    public AddController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    public int process(AbstractTaskList taskList) {
        AddView addView = (AddView) view;
        String name = addView.inputName();
        int repeat = addView.repeat();
        LocalDateTime dateStartTime, dateEndTime;
        Task task;
        try {
            if (repeat == 0) {
                dateStartTime = addView.inputDateTime();
                task = new Task(name, dateStartTime);
                taskList.add(task);
                task.setId(LocalDate.now() + "-" + LocalTime.now().getHour()
                        + LocalTime.now().getMinute() + LocalTime.now().getSecond());
            } else if (repeat == 1) {
                dateStartTime = addView.inputDateStart();
                dateEndTime = addView.inputDateEnd();
                repeat = addView.inputInterval();
                task = new Task(name, dateStartTime, dateEndTime, repeat);
                taskList.add(task);
                task.setId(LocalDate.now() + "-" + LocalTime.now().getHour()
                        + LocalTime.now().getMinute() + LocalTime.now().getSecond());
            } else {
                return Controller.MAIN_MENU;
            }
        } catch (IllegalArgumentException e) {
            return addView.DateException();
        }
        return addView.printInfo(null);
    }
}