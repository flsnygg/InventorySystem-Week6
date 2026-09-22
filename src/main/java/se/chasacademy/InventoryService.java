package se.chasacademy;

import java.util.List;

public class InventoryService {

    private Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(Product product) {
        inventory.getProducts().add(product);
    }

    public Product findProductById(int id) {
        for (Product product : inventory.getProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public List<Product> getProducts() {
        return inventory.getProducts();
    }

    public void updateQuantity(int id, int quantity) {
        Product product = findProductById(id);
        product.setQuantity(quantity);
    }

    public int getTotalQuantity() {
        int total = 0;

        for (Product product : inventory.getProducts()) {
            total += product.getQuantity();
        }

        return total;
    }
}