package app

import com.vaadin.annotations.Theme
import com.vaadin.data.validator.EmailValidator
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import com.vaadin.ui.themes.Reindeer

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class RegisterUI extends UI {
   // public final static String USUARIO_LOGEADO="USUARIO_LOGEADO";

    Button loginButton = new Button("Registrar",new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {

            // logout the user
            getSession().setAttribute("user", null);
            // Refresh this view, should redirect to login view
           // getUI().getNavigator().navigateTo(NAME);
        }
    });

    Button registerButton = new Button("Cancelar",new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);
            // Refresh this view, should redirect to login view
            //getUI().getNavigator().navigateTo(NAME);
        }
    });


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();


        // campos del login de usuario
        TextField firstname = new TextField("First Name: ")
        firstname.setRequired(true)
        TextField lastname = new TextField("Last Name: ")
        lastname.setRequired(true)
        TextField email = new TextField("Email: ")
        email.setRequired(true)
        email.addValidator(new EmailValidator("Invalid e-mail address {0}"))
        TextField usuario = new TextField("Usuario: ")
        usuario.setRequired(true)
        PasswordField password = new PasswordField("Contraseña: ")
        password.setRequired(true)



        //botones

        //agregando los botones a un horizontal layout
        HorizontalLayout botones = new HorizontalLayout(loginButton,registerButton)
        botones.setSpacing(true)

        //agregando los datos a los campos
        VerticalLayout campos = new VerticalLayout(firstname,lastname,email,usuario,password,botones)
        campos.setCaption("Please enter your information");
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
