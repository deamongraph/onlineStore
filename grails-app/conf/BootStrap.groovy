import domains.Picture
import domains.Product
import domains.User
import domains.UserRole

class BootStrap {

    def init = { servletContext ->
        def role_admin = new UserRole(type:"Administrator").save(failOnError: true)
        def role_user = new UserRole(type:"Customer").save(failOnError: true)
        // definiendo el administrador
       // def admin = new User(firstname:"admin",lastname:"admin",mail:"info@host809.com",username:"admin",password:"admin",usertype:[role_admin]).save(failOnError: true)

       // definiendo algunos articulos fijos para pruebas
       def picture1 = new Picture(path: "http://cisc-sti.com/images/logo.png").save(failOnError: true)
       def picture2 = new Picture(path: "http://cisc-sti.com/images/acm.png").save(failOnError: true)
       def articulo1 = new Product(name:"Tenis",description: "Tenis nike",availables: 10,price: 10.5f,pictures:[picture1,picture2]).save(failOnError: true)
       def articulo2 = new Product(name:"Comite",description: "Pagina del comite ISC",availables: 10,price: 10.5f,pictures:[picture1]).save(failOnError: true)
       def articulo3 = new Product(name:"Jugo Po",description: "Jugo PO ",availables: 10,price: 10.5f,pictures:[picture2]).save(failOnError: true)

    }
    def destroy = {
    }
}
