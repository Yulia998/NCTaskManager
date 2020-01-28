package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.IOException;

public class AddView extends View {

    private static final Logger LOGGER = Logger.getLogger(AddView.class);

    public int repeat() {
        System.out.print("Повторяющаяся задача? (да/нет): ");
        try {
            switch (reader.readLine()) {
                case "да":
                    return 1;
                case "нет":
                    return -1;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз ");
                    LOGGER.warn("Введенное значение повторения не соответстует одному из предложенных");
                    return repeat();
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return Controller.MAIN_MENU;
    }
}
