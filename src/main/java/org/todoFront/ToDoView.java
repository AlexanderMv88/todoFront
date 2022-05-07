package org.todoFront;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.todoFront.entity.Task;

import java.util.List;

@Route("/todo")
public class ToDoView extends VerticalLayout {

    private Label lblName = new Label();
    private Label lblId = new Label();
    private VerticalLayout tasksLayout = new VerticalLayout();
    private final TasksService tasksService;

    public ToDoView(TasksService tasksService) {
        this.tasksService = tasksService;
        this.add(lblId, lblName, tasksLayout);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);



        this.getUI().ifPresent(ui -> {
            String currentUser = ui.getSession().getAttribute("user").toString();
            String userId = ui.getSession().getAttribute("userId").toString();
            lblName.setText(currentUser);
            lblId.setText(userId);
        });

        List<Task> tasks = tasksService.getTasks(lblId.getText());
        tasks.forEach(task -> {
            tasksLayout.add(new Checkbox(task.getDescription(), task.getDone()));
        });
    }
}
