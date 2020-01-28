package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.time.LocalDateTime;

public class EditTimeController extends SubController {
    private static final Logger LOGGER = Logger.getLogger(EditTimeController.class);

    public EditTimeController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        LocalDateTime dateStartTime, dateEndTime;
        int interval;
        boolean success = true;
        try {
            if (task.isRepeated()) {
                dateStartTime = view.inputDate("Введите новую дату начала (Г-М-Д Ч:М): ");
                dateEndTime = view.inputDate("Введите новую дату окончания (Г-М-Д Ч:М): ");
                interval = view.inputInterval();
                task.setTime(dateStartTime, dateEndTime, interval);
            } else {
                dateStartTime = view.inputDate("Введите новую дату выполнения (Г-М-Д Ч:М): ");
                task.setTime(dateStartTime);
            }
        } catch (IllegalArgumentException e) {
            success = false;
            view.dateException();
            LOGGER.error(Controller.LOG_MESSAGE);
        }
        if (!success) {
            return Controller.MAIN_MENU;
        }
        return view.printInfo("\nВремя задачи изменено\n");
    }
}
