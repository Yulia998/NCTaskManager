package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import org.apache.log4j.Logger;

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
    private static final Logger LOGGER = Logger.getLogger(View.class);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public abstract int printInfo(Object object);

    public String inputName() {
        System.out.print("\nВведите название задачи: ");
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return name;
    }

    public LocalDateTime inputDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(reader.readLine(), formatter);
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (DateTimeParseException e) {
            System.out.println(WRONG_FORMAT);
            LOGGER.error("Введенное значение не может быть преобразовано в дату");
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
            LOGGER.error(e);
        } catch (NumberFormatException e) {
            exception = true;
            LOGGER.error("Введенное значение не соответствует целочисленному значению интервала");
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
            LOGGER.error(e);
        }
        return id;
    }

    public void dateException() {
        System.out.println("\nОдин из временных параметров введен неверно\n");
    }
}
