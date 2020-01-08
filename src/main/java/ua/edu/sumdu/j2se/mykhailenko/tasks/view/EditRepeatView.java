package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.time.LocalDateTime;

public class EditRepeatView extends View {
    public LocalDateTime inputDateTime() {
        System.out.print("Введите дату выполнения (Г-М-Д Ч:М): ");
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateTime();
        }
        return result;
    }

    public LocalDateTime inputDateStart() {
        System.out.print("Введите дату начала (Г-М-Д Ч:М): ");
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateStart();
        }
        return result;
    }

    public LocalDateTime inputDateEnd() {
        System.out.print("Введите дату окончания (Г-М-Д Ч:М): ");
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateEnd();
        }
        return result;
    }

    public int printInfo(Object object) {
        System.out.println("\nПовторяемость задачи изменено\n");
        return Controller.MAIN_MENU;
    }
}
