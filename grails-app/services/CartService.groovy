import grails.transaction.Transactional

@Transactional
class CartService {

    public Cart getCartbyusername(String username){
        return User.findByUsername(username).cart
    }

    public void create(String username){
        def user = User.findByUsername(username)
        def cart = new Cart(usuario: user, date: new Date()).save(failOnError: true)
    }

    public void addProduct(String username, String productname){
        def cart = User.findByUsername(username).cart
        cart.products.add(Product.findByName(productname))
        cart.save(flush: true)
    }

    public void deleteProduct(String username, String productname){
        def cart = User.findByUsername(username).cart
        cart.products.remove(Product.findByName(productname))
        cart.save(flush: true)
    }

    public void buy(String username){
        def cart = User.findByUsername(username).cart
        for(Product p in cart.products){
        //implements logic for buy the article and clean the cart....
        }
    }
}
