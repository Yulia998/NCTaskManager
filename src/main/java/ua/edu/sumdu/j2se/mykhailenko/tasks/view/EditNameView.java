package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.SubController;

public class EditNameView extends View {
    @Override
    public int printInfo(Object object) {
        System.out.println("Название задачи было изменено\n");
        return SubController.EDIT_MENU;
    }
}
