import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void testEveryBranch() {
        System.out.println("Test allItems == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        System.out.println("Test name == null, discount > 0, sum > 300, sum >= payment, barcode[0]=='0'");
        assertTrue(SILab2.checkCart(List.of(new Item(null, "0123456", 300, 0.25F)), 100));
        System.out.println("Testing if barcode has invalid character");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("apple", "b12345", 100, 0)), 50));
        System.out.println("Testing sum < payment and discount != 0");
        assertFalse(SILab2.checkCart(List.of(new Item("banana", "0123", 100, 0)), 50));
        System.out.println("Testing barcode == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("pineapple", null, 300, 0)), 100));
    }

    @Test
    void testMultipleCondition() {
        Item item = new Item(null, null, 0, 0);
        item.setPrice(350);
        item.setDiscount(0.1F);
        item.setBarcode("012345");
        assertTrue(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
        item.setPrice(230);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
        item.setPrice(330);
        item.setDiscount(0);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
        item.setDiscount(0.1F);
        item.setBarcode("12345");
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }
}
