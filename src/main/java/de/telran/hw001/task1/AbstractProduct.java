package de.telran.hw001.task1;

public abstract class AbstractProduct {

    abstract void addToArray(Product[] products);
    abstract void removeFromArray(Product[] products);

}
abstract class AbstractDatabaseOperation{
    abstract void searchInArray(Product[] products, String query);
    abstract void updateArray(Product[] products, Product product);
}

interface IArrayProcessing{
    void sortArray(Product[] products);
    void filterArray(Product[] products, String criteria);
}
interface IProductManagement{
    void addProduct(Product product);
    void removeProduct(Product product);
}
//================================================================
class FoodProduct extends AbstractProduct{

    @Override
    void addToArray(Product[] products) {

    }

    @Override
    void removeFromArray(Product[] products) {

    }

    void calculateExpiration(Product[] products) {

    }

    void applyDiscount(Product[] products, double discount) {

    }
}
class NonFoodProduct extends AbstractProduct{

    @Override
    void addToArray(Product[] products) {

    }

    @Override
    void removeFromArray(Product[] products) {

    }

    void checkWarranty(Product[] products) {

    }

    void updatePrice(Product[] products, double price) {

    }
}
class ProductDatabase extends AbstractDatabaseOperation implements IArrayProcessing,IProductManagement {

    @Override
    void searchInArray(Product[] products, String query) {

    }

    @Override
    void updateArray(Product[] products, Product product) {

    }

    @Override
    public void sortArray(Product[] products) {

    }

    @Override
    public void filterArray(Product[] products, String criteria) {

    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }

    void backupDatabase(Product[] products) {

    }

    void restoreDatabase(Product[] products) {

    }
}

class ProductAnalytics implements IArrayProcessing{

    @Override
    public void sortArray(Product[] products) {

    }

    @Override
    public void filterArray(Product[] products, String criteria) {

    }
    void calculateAveragePrice(Product[] products){

    }
    void findMostPopularProduct(Product[] products){

    }
}
class InventoryManagement implements IProductManagement{

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }
    void countProducts(Product[] products){

    }
    void listExpiredProducts(Product[] products){

    }
}
class SpecialOfferProduct extends NonFoodProduct{
    void addSpecialOffer(Product[] products, SpecialOffer offer){

    }
    void removeSpecialOffer(Product[] products, SpecialOffer offer){

    }
}

class Product {
    public static void main(String[] args) {
        FoodProduct foodProduct = new FoodProduct();
        NonFoodProduct nonFoodProduct = new NonFoodProduct();
    }
}

class SpecialOffer {
    //
}
