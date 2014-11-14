


import grails.converters.JSON

class AppController {

    def index() {
        println("Redireccionando a Vaadin..")
        redirect(uri: "/login/");
    }

    /**
     *
     * @return
     */

}
