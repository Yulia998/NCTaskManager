package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDateTime;

public class EditRepeatController extends SubController {
    private static final Logger LOGGER = Logger.getLogger(EditRepeatController.class);

    public EditRepeatController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        LocalDateTime dateStartTime, dateEndTime;
        int interval;
        boolean success = true;
        try {
            if (task.isRepeated()) {
                dateStartTime = view.inputDate(View.DATE);
                task.setTime(dateStartTime);
            } else {
                dateStartTime = view.inputDate(View.DATE_START);
                dateEndTime = view.inputDate(View.DATE_END);
                interval = view.inputInterval();
                task.setTime(dateStartTime, dateEndTime, interval);
            }
        } catch (IllegalArgumentException e) {
            success = false;
            view.dateException();
            LOGGER.error(Controller.LOG_MESSAGE);
        }
        if (!success) {
            return Controller.MAIN_MENU;
        }
        return view.printInfo("\nПовторяемость задачи изменено\n");
    }
}
