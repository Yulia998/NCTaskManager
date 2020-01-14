package ua.edu.sumdu.j2se.mykhailenko.tasks;

import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.Controller;
import ua.edu.sumdu.j2se.mykhailenko.tasks.controller.MainController;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.TaskIO;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.MainView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/input.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        AbstractTaskList taskList = new ArrayTaskList();
        TaskIO.readBinary(taskList, file);
        View view = new MainView();
        Controller controller = new MainController(view, taskList);
        controller.process(taskList);
        TaskIO.writeBinary(taskList, file);
    }
}
