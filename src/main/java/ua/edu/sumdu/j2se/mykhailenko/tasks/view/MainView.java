package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.IOException;

public class MainView extends View {

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
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println(WRONG_FORMAT + "\n");
        }
        return variant;
    }
}
