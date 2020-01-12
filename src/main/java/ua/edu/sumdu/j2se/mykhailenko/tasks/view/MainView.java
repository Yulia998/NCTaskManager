package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.IOException;

public class MainView extends View {

    private static final Logger LOGGER = Logger.getLogger(MainView.class);

    @Override
    public int printInfo(Object object) {
        System.out.println("      Меню");
        System.out.println("1. Создать новую задачу");
        System.out.println("2. Изменить задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Просмотреть все задачи");
        System.out.println("5. Просмотреть календарь на определенное время");
        System.out.println("6. Выйти");
        int variant = 0;
        try {
            variant = Integer.parseInt(reader.readLine());
            if (variant < 1 || variant > 6) {
                System.out.println(MENUITEM_NOT_FOUND + "\n");
                variant = Controller.MAIN_MENU;
                LOGGER.warn("Выбран несуществующий пункт основного меню");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(WRONG_FORMAT + "\n");
            LOGGER.error("Введенное значение не соответствует целочисленному" +
                    " значению пункта основного меню");
        }
        return variant;
    }
}
