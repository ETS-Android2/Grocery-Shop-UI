package sharma.pankaj.grocerystore.ui.home.model;

public class ViewModelController {

    public enum ItemType {
        BANNER_ITEM, CATEGORIES_ITEM, FRESH_PRODUCT_ITEM, VEGITABLE_ITEM;
    }

    private ItemType type;

    public ViewModelController() {}

    public ViewModelController(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
