package sharma.pankaj.grocerystore.myorders.model;

public class MyOrderViewControllerModel {
    public enum ItemType {
        CURRENT_ORDER_VIEW, OLD_ORDER_VIEW;
    }

    private MyOrderViewControllerModel.ItemType type;

    public MyOrderViewControllerModel() {}

    public MyOrderViewControllerModel(MyOrderViewControllerModel.ItemType type) {
        this.type = type;
    }

    public MyOrderViewControllerModel.ItemType getType() {
        return type;
    }

    public void setType(MyOrderViewControllerModel.ItemType type) {
        this.type = type;
    }
}
