package sharma.pankaj.grocerystore.ui.mycart.model;

public class AddressModel {

    private boolean layout;
    private boolean isSelected;
    private String address;

    public AddressModel(boolean layout, boolean isSelected, String address) {
        this.layout = layout;
        this.isSelected = isSelected;
        this.address = address;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isLayout() {
        return layout;
    }

    public void setLayout(boolean layout) {
        this.layout = layout;
    }
}
