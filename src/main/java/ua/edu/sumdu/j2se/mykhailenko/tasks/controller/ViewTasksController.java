package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public class ViewTasksController extends Controller{
    public ViewTasksController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    public int process(AbstractTaskList taskList) {
        return view.printInfo(taskList);
    }
}
