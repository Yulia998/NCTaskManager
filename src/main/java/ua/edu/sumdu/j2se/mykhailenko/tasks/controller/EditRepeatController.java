package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.EditRepeatView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDateTime;

public class EditRepeatController extends SubController {
    private static final Logger LOGGER = Logger.getLogger(EditRepeatController.class);

    public EditRepeatController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        EditRepeatView editRepeat = (EditRepeatView) view;
        LocalDateTime dateStartTime, dateEndTime;
        int interval;
        boolean success = true;
        try {
            if (task.isRepeated()) {
                dateStartTime = editRepeat.inputDateTime();
                task.setTime(dateStartTime);
            } else {
                dateStartTime = editRepeat.inputDateStart();
                dateEndTime = editRepeat.inputDateEnd();
                interval = editRepeat.inputInterval();
                task.setTime(dateStartTime, dateEndTime, interval);
            }
        } catch (IllegalArgumentException e) {
            success = false;
            editRepeat.dateException();
            LOGGER.error(Controller.LOG_MESSAGE);
        }
        if (!success) {
            return Controller.MAIN_MENU;
        }
        return editRepeat.printInfo(null);
    }
}
