package sharma.pankaj.grocerystore.ui.mycart.model;

public class MyCartModel {

    private boolean isFavorite;
    private int image;
    private String productName;
    private String productQuantity;
    private String productPrice;
    private String note;
    private String couponCode;


    public MyCartModel(boolean isFavorite, int image,
                       String productName, String productQuantity,
                       String productPrice, String note, String couponCode) {
        this.isFavorite = isFavorite;
        this.image = image;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.note = note;
        this.couponCode = couponCode;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}
