package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddView extends View {

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

    public int repeat() {
        System.out.print("Повторяющаяся задача? (да/нет): ");
        try {
            switch (reader.readLine()) {
                case "да":
                    return 1;
                case "нет":
                    return 0;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз ");
                    return repeat();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int printInfo(Object object) {
        System.out.println("\n\tЗадача добавлена\n");
        return Controller.MAIN_MENU;
    }
}
