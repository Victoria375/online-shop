package app.lesson1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {
    private final Map<Integer, Product> productsList = new ConcurrentHashMap<>();

    {
        double cost = 0;
        for (int i = 0; i < 5; i++) {
            productsList.put(i, new Product(i, "Product " + i, cost + (int) (Math.random() * 100)));
        }
    }

    public List<Product> getProductsList() {
        return new ArrayList<>(productsList.values());
    }

    public Product findProduct(Integer id) {
        return productsList.get(id);
    }

    public void removeProduct(Integer id) {
        productsList.remove(id);
    }
}
