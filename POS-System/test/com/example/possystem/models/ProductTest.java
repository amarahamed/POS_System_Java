package com.example.possystem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    @BeforeEach
    void setUp() {
        product = new Product(12345678, "Apple", 2.49, 1, "lb","Canadian Farmers", 56, 256);
    }

    /* Product ID */

    @Test
    void setProductId() {
        product.setProductId(12345679);
        assertEquals(12345679, product.getProductId());
    }

    @Test
    void setProductIdInvalidLengthLess() {
        assertThrows(IllegalArgumentException.class, () -> {
           product.setProductId(125);
        });
    }

    @Test
    void setProductIdInvalidLengthMore() {
        assertThrows(IllegalArgumentException.class, ()-> {
           product.setProductId(1234067891);
        });
    }

    @Test
    void setProductIdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            product.setProductId(Integer.parseInt("12569SD"));
        });
    }

    /* Product Name */


    @Test
    void setProductName() {
        product.setProductName("Orange");
        assertEquals("Orange", product.getProductName());
    }

    @Test
    void setProductNameInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
           product.setProductName("G");
        });
    }

    @Test
    void setProductNameInvalid() {
        assertThrows(IllegalArgumentException.class, ()-> {
           product.setProductName("    s");
        });
    }


    /* Product Price */

    @Test
    void setProductPrice() {
        product.setProductPrice(1.49);
        assertEquals(1.49, product.getProductPrice());
    }

    @Test
    void setProductPriceInvalidAmount() {
        assertThrows(IllegalArgumentException.class, ()-> {
           product.setProductPrice(-0.5);
        });
    }
    @Test
    void setProductPriceInvalid() {
        assertThrows(IllegalArgumentException.class, ()-> {
           product.setProductPrice(Double.parseDouble("56.7$"));
        });
    }


    /* Product Weight */

    @Test
    void setProductWeight() {
        product.setProductWeight(5);
        assertEquals(5, product.getProductWeight());
    }

    @Test
    void setProductWeightInvalid() {
        assertThrows(IllegalArgumentException.class, ()-> {
            product.setProductWeight((float) -0.356);
        });
    }
    @Test
    void setProductWeightInvalidString() {
        assertThrows(IllegalArgumentException.class, ()-> {
            product.setProductWeight(Float.parseFloat("568952.25$"));
        });
    }


    /* Product Weigh Unit */

    @Test
    void setProductWeightUnit() {
        product.setProductWeightUnit("lb");
        assertEquals("lb", product.getProductWeightUnit());
    }

    @Test
    void setProductManufacture() {
        product.setProductManufacture("Walmart");
        assertEquals("Walmart", product.getProductManufacture());
    }

    @Test
    void setQuantity() {
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }

    @Test
    void setCategoryId() {
        product.setCategoryId(5675);
        assertEquals(5675, product.getCategoryId());
    }
}