package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public abstract class SubController {
    public static final int EDIT_MENU = 0;
    public static final int BACK_MENU = 5;

    protected View view;
    protected int actionPerform;

    public SubController(View view, int actionPerform) {
        this.view = view;
        this.actionPerform = actionPerform;
    }

    public boolean canProcess(int action) {
        return action == actionPerform;
    }

    public abstract int run(Task task);
}
