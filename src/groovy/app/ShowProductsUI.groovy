package app

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import com.vaadin.ui.themes.Reindeer
import domains.User

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class ShowProductsUI extends UI {

    TextField usuario;
    PasswordField password;
    Button loginButton = new Button("Login",new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            String user = usuario.value;
            String pass = password.value;
            if(User.findByUsernameAndPassword(user, pass))
                println("Autentificado: "+user);

            // getSession().setAttribute("user", null);

        }
    });

    Button registerButton = new Button("Registrar",new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
           // getSession().setAttribute("user", null);
            // Refresh this view, should redirect to login view
            getUI().getPage().setLocation("../user/");

        }
    });


    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }
}
