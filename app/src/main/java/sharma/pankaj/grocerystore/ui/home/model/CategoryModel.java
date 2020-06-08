package sharma.pankaj.grocerystore.ui.home.model;

public class CategoryModel {

    private int icon;
    private String categoryName;

    public CategoryModel(int icon, String categoryName) {
        this.icon = icon;
        this.categoryName = categoryName;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
