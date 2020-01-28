package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.AddView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AddController extends Controller {
    private static final Logger LOGGER = Logger.getLogger(AddController.class);

    public AddController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    public int process(AbstractTaskList taskList) {
        AddView addView = (AddView) view;
        String name = addView.inputNameOrID("\nВведите название задачи: ");
        int repeat = addView.repeat();
        LocalDateTime dateStartTime, dateEndTime;
        Task task;
        boolean success = true;
        try {
            if (repeat == -1) {
                dateStartTime = addView.inputDate(View.DATE);
                task = new Task(name, dateStartTime);
                taskList.add(task);
                task.setId(LocalDate.now() + "-" + LocalTime.now().getHour()
                        + LocalTime.now().getMinute() + LocalTime.now().getSecond());
            } else if (repeat == 1) {
                dateStartTime = addView.inputDate(View.DATE_START);
                dateEndTime = addView.inputDate(View.DATE_END);
                repeat = addView.inputInterval();
                task = new Task(name, dateStartTime, dateEndTime, repeat);
                taskList.add(task);
                task.setId(LocalDate.now() + "-" + LocalTime.now().getHour()
                        + LocalTime.now().getMinute() + LocalTime.now().getSecond());
            } else {
                return Controller.MAIN_MENU;
            }
        } catch (IllegalArgumentException e) {
            success = false;
            addView.dateException();
            LOGGER.error(Controller.LOG_MESSAGE);
        }
        if (!success) {
            return Controller.MAIN_MENU;
        }
        return addView.printInfo("\n\tЗадача добавлена\n");
    }
}
