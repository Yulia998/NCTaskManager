package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.NotificationView;

import java.time.Duration;
import java.time.LocalDateTime;

public class NotificationController extends Thread {
    private static final Logger LOGGER = Logger.getLogger(NotificationController.class);
    private NotificationView view;
    private AbstractTaskList taskList;

    public NotificationController(NotificationView view, AbstractTaskList taskList) {
        this.view = view;
        this.taskList = taskList;
    }

    @Override
    public void run() {
        LocalDateTime next, now;;
        while (true) {
            now = LocalDateTime.now().withSecond(0).withNano(0);
            for (Task task : taskList) {
                next = task.nextTimeAfter(now.minusMinutes(1));
                if (next != null) {
                    if (next.equals(now)) {
                        view.printInfo(task);
                    }
                }
            }
            try {
                if (now.equals(LocalDateTime.now().withSecond(0).withNano(0))) {
                    Thread.sleep(Duration.between(LocalDateTime.now(), now.plusMinutes(1)).toMillis());
                }
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }
}
