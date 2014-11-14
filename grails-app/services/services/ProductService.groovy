package services

import domains.Product
import grails.transaction.Transactional

@Transactional
class ProductService {

    public void create(String name, String description, Integer availables, Double price, List<String> pictures){
        def product = new Product(name: name, description: description,
                availables: availables, price: price, pictures: pictures).save(flush: true)
    }

    public List<Product> productList(){
        return Product.list()
    }

    public Product getproductbyname(String name){
        return Product.findByName(name)
    }

    public void deletebyname(String name){
        def producto = Product.findByName(name).delete()
    }

    public void updateproduct(String name, String description, Integer availables, Double price, List<String> pictures){
        def product = Product.findByName(name)
        product.description = description
        product.availables = availables
        product.price = price
        product.pictures = pictures
        product.save()
    }

    public static void productbuyed(String name, Integer quantity){
        def producto = Product.findByName(name)
        producto.availables -= quantity
        producto.save(flush: true)
    }
}
