package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

public class DeleteView extends View {

    public int printInfo(Object object) {
        if ((boolean) object) {
            System.out.println("\tЗадача удалена\n");
        } else {
            System.out.println("\t" + TASK_NOT_FOUND + "\n");
        }
        return Controller.MAIN_MENU;
    }
}
