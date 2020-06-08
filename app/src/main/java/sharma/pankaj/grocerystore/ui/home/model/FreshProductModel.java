package sharma.pankaj.grocerystore.ui.home.model;

public class FreshProductModel {

    private boolean isFavorite;
    private int image;
    private String productName;
    private String productQuantity;
    private String productPrice;

    public FreshProductModel(boolean isFavorite, int image, String productName, String productQuantity, String productPrice) {
        this.isFavorite = isFavorite;
        this.image = image;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
