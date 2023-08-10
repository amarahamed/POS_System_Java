package com.example.possystem.models;

import com.example.possystem.utilities.DBUtility;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private float productWeight;
    private String productWeightUnit;
    private String productManufacture;
    private double quantity;
    private int categoryId;

    public Product(int productId, String productName, double productPrice, float productWeight, String productWeightUnit, String productManufacture, double quantity, int categoryId) {
        setProductId(productId);
        setProductName(productName);
        setProductPrice(productPrice);
        setProductWeight(productWeight);
        setProductWeightUnit(productWeightUnit);
        setProductManufacture(productManufacture);
        setQuantity(quantity);
        setCategoryId(categoryId);
    }


    public int getProductId() {
        return productId;
    }

    /**
     * Method validates product id. Checks if it contains 8 digits
     * Later on DBUtility function will be added where product id will be incremented by the row number from DB
     * EG: lasted added row was 567, the next added product will get the id 568
     * @param productId - contains 8 digits
     */
    public void setProductId(int productId) {
        if(Integer.toString(productId).length() == 8 && Integer.toString(productId).matches("[0-9]{8}")) {
            this.productId = productId;
        } else {
            throw new IllegalArgumentException("Product ID should have 8 digits");
        }
    }

    public String getProductName() {
        return productName;
    }

    /**
     * Method validates product name
     * @param productName - should hv at least 2 characters and max 255
     */
    public void setProductName(String productName) {
        if(!productName.isBlank() && productName.trim().length() >= 2 && productName.length() <= 255) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Product name should contain 2-255 characters");
        }
    }

    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Method validates product price, where product price should only contain numerals to be valid
     * @param productPrice - More than 0$ to be valid - eg: 0.1$ is valid
     */
    public void setProductPrice(double productPrice) {
        if(productPrice > 0 && Double.toString(productPrice).matches("[0-9, .]*")) {
            this.productPrice = productPrice;
        }
        else {
            throw new IllegalArgumentException("Product price should be more than 0$ and contain numerals only");
        }
    }

    public float getProductWeight() {
        return productWeight;
    }

    /**
     * Method validates product weight, a valid weight should be more than 0. the unit of measurements doesn't matter
     * @param productWeight - More than 0 to be valid - eg: 0.1g is valid
     */
    public void setProductWeight(float productWeight) {
        if(productWeight < 0.0) {
            throw new IllegalArgumentException("Product weight should be more than 0");
        } else if (Float.toString(productWeight).matches("[^0-9]*")) {
            throw new IllegalArgumentException("Product weight should contain only numerals");
        } else {
            this.productWeight = productWeight;
        }
    }

    public String getProductManufacture() {
        return productManufacture;
    }

    /**
     * Method validates product manufactures, a valid manufacture should have at least 2 characters and cannot be blank
     * @param productManufacture - Min 2 characters, not blank
     */
    public void setProductManufacture(String productManufacture) {
        if(!productManufacture.trim().isBlank() && productManufacture.trim().length() > 1) {
            this.productManufacture = productManufacture;
        } else {
            throw new IllegalArgumentException("Product Manufacture cannot be blank and should contain at least 2 characters");
        }
    }

    public String getProductWeightUnit() {
        return productWeightUnit;
    }

    /**
     * Method validates correct measuring unit
     * @param productWeightUnit - Max chars length 3, cannot contain numerals
     */
    public void setProductWeightUnit(String productWeightUnit) {
        if(productWeightUnit.length() > 3) {
            throw new IllegalArgumentException("Product Weigh unit cannot be more than 3 characters");
        } else if(productWeightUnit.matches("[0-9]*")) {
            throw new IllegalArgumentException("Product Weigh unit cannot contain numerals");
        } else {
            this.productWeightUnit = productWeightUnit;
        }
    }

    public double getQuantity() {
        return quantity;
    }

    /**
     * Method validates Quantity value. A valid qty is any number greater than 0
     * @param quantity - At least 1
     */
    public void setQuantity(double quantity) {
        if(quantity >= 1) {
            this.quantity = quantity;
        } else if (Double.toString(quantity).matches("[^0-9]*")) {
            throw new IllegalArgumentException("Quantity should contain only numerals");
        } else {
            throw new IllegalArgumentException("Quantity should at least 1");
        }
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        if(categoryId > 0) {
            this.categoryId = categoryId;
        } else {
            throw new IllegalArgumentException("Category ID should be more than 0");
        }
    }
}
