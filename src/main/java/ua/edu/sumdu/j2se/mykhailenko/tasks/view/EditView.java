package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

public class EditView extends View {
    @Override
    public int printInfo(Object object) {
        System.out.println(TASK_NOT_FOUND);
        return Controller.MAIN_MENU;
    }
}
