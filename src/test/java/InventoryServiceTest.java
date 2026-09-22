
import org.junit.jupiter.api.Test;
import se.chasacademy.Inventory;
import se.chasacademy.InventoryService;
import se.chasacademy.Product;
import se.chasacademy.ProductNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InventoryServiceTest {

    @Test
    void shouldAddProduct() {
        Inventory inventory = new Inventory();
        InventoryService service = new InventoryService(inventory);
        Product product = new Product(1, "Keyboard", 5);

        service.addProduct(product);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(product, inventory.getProducts().getFirst());
    }

    @Test
    void shouldFindProductById() {
        Inventory inventory = new Inventory();
        InventoryService service = new InventoryService(inventory);
        Product product = new Product(1, "Keyboard", 5);

        service.addProduct(product);

        Product result = service.findProductById(1);

        assertEquals(product, result);
    }

    @Test
    void shouldThrowWhenProductDoesNotExist() {
        Inventory inventory = new Inventory();
        InventoryService service = new InventoryService(inventory);

        assertThrows(
                ProductNotFoundException.class,
                () -> service.findProductById(999)
        );
    }

    @Test
    void shouldAddTotalQuantityOfMultipleProducts() {
        Inventory inventory = new Inventory();
        InventoryService service = new InventoryService(inventory);
        Product product = new Product(1, "Keyboard", 5);
        Product product2 = new Product(2, "Shampoo", 10);

        service.addProduct(product);
        service.addProduct(product2);

        int result = service.getTotalQuantity();

        assertEquals(15, result);
    }
}