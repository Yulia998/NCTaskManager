package ua.edu.sumdu.j2se.mykhailenko.tasks.view;

import java.io.IOException;

public class EditMenuView extends View {
    @Override
    public int printInfo(Object object) {
        System.out.println("      Меню редактирования");
        System.out.println("1. Изменить название задачи");
        System.out.println("2. Изменить время выполнение задачи");
        System.out.println("3. Сделать задачу активной/неактивной");
        System.out.println("4. Сделать задачу повторяемой/неповторяемой");
        System.out.println("5. Вернуться к главному меню");
        int variant = 1;
        try {
            variant = Integer.parseInt(reader.readLine());
            if (variant < 1 || variant > 5) {
                System.out.println("Введеного пункта меню не существует\n");
                return printInfo(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода\n");
            return printInfo(object);
        }
        return variant;
    }
}
