package app

import com.vaadin.annotations.Theme
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import com.vaadin.ui.themes.Reindeer
import domains.User
import services.UserService
import sun.awt.HorizBagLayout
import sun.awt.VerticalBagLayout

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class LoginUI extends UI {
   // public final static String USUARIO_LOGEADO="USUARIO_LOGEADO";
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
        setSizeFull();


        // campos del login de usuario
       usuario = new TextField("Usuario: ")
        usuario.setRequired(true)
        password = new PasswordField("Contraseña: ")
        password.setRequired(true)
        //botones

        //agregando los botones a un horizontal layout
        HorizontalLayout botones = new HorizontalLayout(loginButton,registerButton)
        botones.setSpacing(true)

        //agregando los datos a los campos
        VerticalLayout campos = new VerticalLayout(usuario,password,botones)
        campos.setCaption("Please login to access the application");
        campos.setSpacing(true);
        campos.setMargin(new MarginInfo(true, true, true, false));
        campos.setSizeUndefined();
        //agregando los campos al layout
        VerticalLayout layout = new VerticalLayout(campos)
        layout.setSizeFull()
        layout.setComponentAlignment(campos,Alignment.MIDDLE_CENTER)
        layout.setStyleName(Reindeer.LAYOUT_BLUE)
        setContent(layout)
    }
}
