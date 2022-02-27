package org.todoFront;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/todo")
public class ToDoView extends VerticalLayout {

    public Label lbl = new Label();

    public ToDoView() {
        this.add(lbl);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.getUI().ifPresent(ui -> {
            String currentUser = ui.getSession().getAttribute("user").toString();
            lbl.setText(currentUser);
        });
    }
}
