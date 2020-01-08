package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public class EditNameController extends SubController {
    public EditNameController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    @Override
    public int run(Task task) {
        String name = view.inputName();
        task.setTitle(name);
        return view.printInfo(null);
    }
}
