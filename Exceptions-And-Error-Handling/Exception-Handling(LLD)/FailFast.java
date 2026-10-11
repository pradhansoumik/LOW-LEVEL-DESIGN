class ProductServiceFailFirst
{
    ProductRepo productRepo;

    public Product getProduct(String productId)
    {
        if (productId == null)
        {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        // fail-fast for invalid input
        return productRepo.find(productId);
    }
}

//dummy
class Product
{
    public Product() {

    }

    public Product(String aDefault, String fallbackProduct) {

    }
}
//dummy
class ProductRepo
{
    Product find(String productId)
    {
        return new Product();
    }
}
