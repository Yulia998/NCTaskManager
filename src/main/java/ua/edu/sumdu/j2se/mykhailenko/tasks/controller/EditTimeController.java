package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.EditTimeView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDateTime;

public class EditTimeController extends SubController {

    public EditTimeController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        EditTimeView editTime = (EditTimeView) view;
        LocalDateTime dateStartTime, dateEndTime;
        int interval;
        boolean success = true;
        try {
            if (task.isRepeated()) {
                dateStartTime = editTime.inputDateStart();
                dateEndTime = editTime.inputDateEnd();
                interval = editTime.inputInterval();
                task.setTime(dateStartTime, dateEndTime, interval);
            } else {
                dateStartTime = editTime.inputDateTime();
                task.setTime(dateStartTime);
            }
        } catch (IllegalArgumentException e) {
            success = false;
            editTime.dateException();
        }
        if (!success) {
            return Controller.MAIN_MENU;
        }
        return editTime.printInfo(null);
    }
}
