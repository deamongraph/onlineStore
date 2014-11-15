package app

import com.vaadin.annotations.Theme
import com.vaadin.data.Item
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import com.vaadin.ui.themes.Reindeer
import domains.Product
import domains.User
import services.ProductService

/**
 * Created by frangel on 31/10/14.
 */
@Theme("valo")
class ShowProductsUI extends UI {

   Table contenedor = new Table("Productos en venta");


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        contenedor.addContainerProperty("Name",String.class,null);
        contenedor.addContainerProperty("Description",String.class,null);
        contenedor.addContainerProperty("Availables",Integer.class,null);
        contenedor.addContainerProperty("Price",Float.class,null);
      //  contenedor.addContainerProperty("Imagen",String.class,null);
/*
         Object[] item = contenedor.addItem();
        Item[] articulo = contenedor.getItem(item);
        articulo.getItemProperty("Name").setValue("Tenis");
        articulo.getItemProperty("Description").setValue("Tenis usados con sicote");
        articulo.getItemProperty("Availables").setValue(10);
        articulo.getItemProperty("Price").setValue(-1.46f);
        // esto es solo probando
        Object item2 = contenedor.addItem();
        Item articulo2 = contenedor.getItem(item2);
        articulo2.getItemProperty("Name").setValue("Tenis");
        articulo2.getItemProperty("Description").setValue("Tenis  con sicote");
        articulo2.getItemProperty("Availables").setValue(10);
        articulo2.getItemProperty("Price").setValue(-1.46f);

*/
        Product[] productos = Product.list();
        println(productos.length)
        int conta = 0;
        for(Product producto:productos)
        {
        Object[] articulo=[producto.name,producto.description,producto.availables,producto.price];
            println(conta);
            contenedor.addItem(articulo,conta);
            conta++;
        }
        contenedor.setPageLength(contenedor.size());
        setContent(contenedor);
        //  // = ["Tenis", "Probando", 10, -1.46f];
    }

}
