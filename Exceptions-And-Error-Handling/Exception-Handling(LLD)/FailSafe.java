// Search Product in any of the websites..
class ProductServiceFailSafe
{
    ProductRepo productRepo;

    public Product getProduct(String productId) {
        try
        {
            return productRepo.find(productId);
        }
        catch (Exception e)
        {
            // fail-safe: return default
            return new Product("default", "Fallback Product");
        }
    }
}

