package sharma.pankaj.grocerystore.product.model;

public class ProductCategoryViewModel {
    public enum ItemType {
        CATEGORY_ITEM, PRODUCT_ITEM;
    }

    private ProductCategoryViewModel.ItemType type;

    public ProductCategoryViewModel() {}

    public ProductCategoryViewModel(ProductCategoryViewModel.ItemType type) {
        this.type = type;
    }

    public ProductCategoryViewModel.ItemType getType() {
        return type;
    }

    public void setType(ProductCategoryViewModel.ItemType type) {
        this.type = type;
    }
}
