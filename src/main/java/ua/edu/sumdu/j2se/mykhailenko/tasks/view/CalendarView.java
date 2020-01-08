package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.time.LocalDateTime;

public class CalendarView extends View {

    public LocalDateTime inputDateFrom() {
        System.out.print("\nВведите начальное время (Г-М-Д Ч:М): ");
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateFrom();
        }
        return result;
    }

    public LocalDateTime inputDateTo() {
        System.out.print("Введите конечное время (Г-М-Д Ч:М): ");
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
