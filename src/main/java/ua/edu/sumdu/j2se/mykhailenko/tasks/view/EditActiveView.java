package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.SubController;

public class EditActiveView extends View {
    @Override
    public int printInfo(Object object) {
        if ((boolean) object) {
            System.out.println("\nЗадача изменена на активную\n");
        } else {
            System.out.println("\nЗадача изменена на неактивную\n");
        }
        return SubController.EDIT_MENU;
    }
}
