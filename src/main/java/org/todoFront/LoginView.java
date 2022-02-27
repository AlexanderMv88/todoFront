package org.todoFront;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Label label = new Label("Ты кто?");
        TextField userNameTextField = new TextField("Имя");
        Button okButton = new Button("ok");
        okButton.addClickListener(e -> {
            okButton.getUI().ifPresent(ui ->{
                ui.getSession().setAttribute("user",userNameTextField.getValue());
                ui.navigate("todo");
            });
        });
        add(label, userNameTextField, okButton);
    }
}
