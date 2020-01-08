package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

public class TasksView extends View {

    public int printInfo(Object object) {
        System.out.println(object + "\n");
        return Controller.MAIN_MENU;
    }
}
