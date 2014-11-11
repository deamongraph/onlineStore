package app

import com.vaadin.annotations.Theme
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.*

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class MyUI extends UI {
    public final static String USUARIO_LOGEADO="USUARIO_LOGEADO";

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout()

        //Grails. -> Para utilizar el contexto Grails utilizando Vaadin..
        String homeLabel = Grails.i18n("default.home.label")
        Label label = new Label(homeLabel+", Con Vaadin...")
        layout.addComponent(label)
        layout.addComponent(new Label("Otro label en VerticalLayout...."))
        layout.addComponent(new Label("La cantidad de estudiantes registrados es: "+Estudiante.count))

        //Consultando un estudiante
        def estudiante = Estudiante.get(1);
        layout.addComponent(new Label("El estudiante matricula ${estudiante.matricula} - creado por ${estudiante.creadoPor.type}"))

        HorizontalLayout hz=new HorizontalLayout() ;
        hz.addComponent(new Label("h1") )
        hz.addComponent(new Label("h2") )
        hz.addComponent(new Label("h3") )

        layout.addComponent(hz);

        Panel p=new Panel();
        FormLayout formLayout=new FormLayout();

        TextField txtNomnbre=new TextField("type: ");
        txtNomnbre.setRequired(true);

        PasswordField txtPass=new PasswordField("Clave: ");
        txtPass.setRequired(true);

        Button btnAceptar=new Button("Aceptar");
        btnAceptar.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                println("Esta llamada se visualiza en el servidor....")
                //Notification.show("Presionaste el boton.....")

                //
              /*  if(txtNomnbre.isValid() && txtPass.isValid()){
                    def usuario =Grails.get(UsuarioService).UserAuth(txtNomnbre.value, txtPass.value);
                    if(usuario){
                        VaadinSession.current.setAttribute(USUARIO_LOGEADO, usuario);
                        setContent(new VlPanelPrincipal());
                        //Rediredccionar....
                        // Notification.show("Autenticado, usuario ${usuario.type}",Notification.Type.TRAY_NOTIFICATION)
                    } else{
                        Notification.show("Error de contraseña",Notification.Type.ERROR_MESSAGE)
                    }
                } else{
                    Notification.show("Campos no validos...",Notification.Type.WARNING_MESSAGE)
                }*/
            }
        })

        formLayout.addComponent(txtNomnbre)
        formLayout.addComponent(txtPass)
        formLayout.addComponent(btnAceptar)

        layout.addComponent(formLayout)

        // example of how to get Grails service and call a method
        // List<User> users = Grails.get(UserService).getListOfUsers()
        //    for (User user : users) {
        //        layout.addComponent(new Label(user.name))
        // }

        setContent(layout)
    }
}
