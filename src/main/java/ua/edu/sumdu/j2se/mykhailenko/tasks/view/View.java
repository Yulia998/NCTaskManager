package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class View {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public abstract int printInfo(Object object);

    public String inputName() {
        System.out.print("\nВведите название задачи: ");
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public LocalDateTime inputDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(reader.readLine(), formatter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат ввода");
            return null;
        }
        return dateTime;
    }

    public int inputInterval() {
        System.out.print("Введите интервал повторения в часах: ");
        int interval = 0;
        try {
            interval = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода");
            return inputInterval();
        }
        return interval * 3600;
    }

    public String inputId() {
        System.out.print("\nВведите id задачи: ");
        String id = "";
        try {
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int DateException() {
        System.out.println("\nОдин из временных параметров введен неверно\n");
        return Controller.MAIN_MENU;
    }
}
