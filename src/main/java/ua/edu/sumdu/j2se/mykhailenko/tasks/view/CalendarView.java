package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.time.LocalDateTime;

public class CalendarView extends View {

    public LocalDateTime inputDateFrom() {
        System.out.print("\n" + DATE_START);
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateFrom();
        }
        return result;
    }

    public LocalDateTime inputDateTo() {
        System.out.print(DATE_END);
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateTo();
        }
        return result;
    }

    public int printInfo(Object object) {
        System.out.println(object + "\n");
        return Controller.MAIN_MENU;
    }
}
