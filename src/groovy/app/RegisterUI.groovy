package app

import com.vaadin.annotations.Theme
import com.vaadin.data.validator.EmailValidator
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import com.vaadin.ui.themes.Reindeer
import domains.User
import services.UserService

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class RegisterUI extends UI {
   // public final static String USUARIO_LOGEADO="USUARIO_LOGEADO";
    TextField firstname;
    TextField lastname;
    TextField email;
    TextField usuario;
    PasswordField password;
    Button loginButton = new Button("Registrar",new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {
        //crear un usuario
            String nombre = firstname.value;
            String apellido = lastname.value;
            String correo = email.value;
            String user = usuario.value
            String secret = password.value;
            println(nombre);
            UserService.create(nombre,apellido,correo,user,secret,"customer");
           // println(UserService.userList())
            getUI().getPage().setLocation("../login/");
        }
    });

    Button registerButton = new Button("Cancelar",new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {

            //limpiar campos
            getUI().getPage().setLocation("../login/");
        }
    });


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();


        // campos del login de usuario
        firstname = new TextField("First Name: ");
        firstname.setRequired(true);
        lastname = new TextField("Last Name: ");
        lastname.setRequired(true);
        email = new TextField("Email: ");
        email.setRequired(true);
        email.addValidator(new EmailValidator("Invalid e-mail address {0}"));
        usuario = new TextField("Usuario: ");
        usuario.setRequired(true);

        password  = new PasswordField("Contraseña: ");
        password.setRequired(true);



        //botones

        //agregando los botones a un horizontal layout
        HorizontalLayout botones = new HorizontalLayout(loginButton,registerButton);
        botones.setSpacing(true);

        //agregando los datos a los campos
        VerticalLayout campos = new VerticalLayout(firstname,lastname,email,usuario,password,botones);
        campos.setCaption("Please enter your information");
        campos.setSpacing(true);
        campos.setMargin(new MarginInfo(true, true, true, false));
        campos.setSizeUndefined();
        //agregando los campos al layout
        VerticalLayout layout = new VerticalLayout(campos);
        layout.setSizeFull();
        layout.setComponentAlignment(campos,Alignment.MIDDLE_CENTER);
        layout.setStyleName(Reindeer.LAYOUT_BLUE);
        setContent(layout);
    }
}
