package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddView extends View {

    public LocalDateTime inputDateTime() {
        System.out.print(DATE);
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateTime();
        }
        return result;
    }

    public LocalDateTime inputDateStart() {
        System.out.print(DATE_START);
        LocalDateTime result = super.inputDate();
        if (result == null) {
            return inputDateStart();
        }
        return result;
    }

    public LocalDateTime inputDateEnd() {
        System.out.print(DATE_END);
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
                    return -1;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз ");
                    return repeat();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Controller.MAIN_MENU;
    }

    public int printInfo(Object object) {
        System.out.println("\n\tЗадача добавлена\n");
        return Controller.MAIN_MENU;
    }
}
