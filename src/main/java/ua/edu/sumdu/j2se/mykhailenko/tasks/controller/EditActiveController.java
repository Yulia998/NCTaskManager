package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public class EditActiveController extends SubController {

    public EditActiveController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        if (task.isActive()) {
            task.setActive(false);
        } else {
            task.setActive(true);
        }
        return view.printInfo(task.isActive());
    }
}
