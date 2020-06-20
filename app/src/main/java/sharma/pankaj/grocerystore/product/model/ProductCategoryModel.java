package sharma.pankaj.grocerystore.product.model;

public class ProductCategoryModel {
    private String categoryName;

    public ProductCategoryModel(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
