package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public abstract class Controller {
    public static final int MAIN_MENU = 0;
    public static final int QUIT = 6;

    protected View view;
    protected int actionPerform;

    public Controller(View view, int actionPerform) {
        this.view = view;
        this.actionPerform = actionPerform;
    }

    public boolean canProcess(int action) {
        return action == actionPerform;
    }

    public abstract int process(AbstractTaskList taskList);
}
