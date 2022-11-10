package app.lesson1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final Map<Product, Integer> productsCart = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return productsCart;
    }

    public void addToCart(Product product, Integer amount) {
        if (product != null)
            productsCart.merge(product, amount, Integer::sum);
    }

    public void removeFromCart(Product product, Integer amount) {
        if (productsCart.containsKey(product)) {
            if (amount != null && productsCart.get(product).compareTo(amount) > 0) {
                productsCart.put(product, productsCart.get(product) - amount);
            } else {
                productsCart.remove(product);
            }
        }
    }

}
