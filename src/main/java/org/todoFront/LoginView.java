package org.todoFront;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.todoFront.entity.User;

@Route("/")
public class LoginView extends VerticalLayout {

    private final UserService userService;

    public LoginView(UserService userService) {
        this.userService=userService;
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Label label = new Label("Ты кто?");
        TextField userNameTextField = new TextField("Имя");
        Button okButton = new Button("ok");
        okButton.addClickListener(e -> {
            okButton.getUI().ifPresent(ui ->{
                String userName = userNameTextField.getValue();
                User user = userService.checkAndGetUser(userName);
                if (null!=user) {
                    ui.getSession().setAttribute("user", user.getName());
                    ui.getSession().setAttribute("userId", user.getId());
                    ui.navigate("todo");
                } else {
                    Notification.show("Не тот пользак!");
                }

            });
        });
        add(label, userNameTextField, okButton);
    }
}
