package sharma.pankaj.grocerystore.ui.mycart.model;

import sharma.pankaj.grocerystore.ui.home.model.ViewModelController;

public class MyCartViewModel {
    public enum ItemType {
        CART_ITEM, CALCULATION_SECTION;
    }

    private MyCartViewModel.ItemType type;

    public MyCartViewModel() {}

    public MyCartViewModel(MyCartViewModel.ItemType type) {
        this.type = type;
    }

    public MyCartViewModel.ItemType getType() {
        return type;
    }

    public void setType(MyCartViewModel.ItemType type) {
        this.type = type;
    }
}
