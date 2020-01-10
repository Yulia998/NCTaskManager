package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class View {
    public static final String WRONG_FORMAT = "Неверный формат ввода";
    public static final String DATE = "Введите дату выполнения (Г-М-Д Ч:М): ";
    public static final String DATE_START = "Введите дату начала (Г-М-Д Ч:М): ";
    public static final String DATE_END = "Введите дату окончания (Г-М-Д Ч:М): ";
    public static final String TASK_NOT_FOUND = "Задача не найдена";
    public static final String MENUITEM_NOT_FOUND = "Введеного пункта меню не существует";
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
            System.out.println(WRONG_FORMAT);
        }
        return dateTime;
    }

    public int inputInterval() {
        System.out.print("Введите интервал повторения в часах: ");
        int interval = 0;
        boolean exception = false;
        try {
            interval = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            exception = true;
        }
        if (exception) {
            System.out.println(WRONG_FORMAT);
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

    public void dateException() {
        System.out.println("\nОдин из временных параметров введен неверно\n");
    }
}
