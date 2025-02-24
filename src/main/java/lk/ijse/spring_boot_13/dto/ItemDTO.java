package lk.ijse.spring_boot_13.dto;

public class ItemDTO {

    private int itemCode;
    private String itemName;
    private double itemPrice;
    private int itemQuantity;

    public ItemDTO() {
    }

    public ItemDTO(int itemCode, String itemName, double itemPrice, int itemQuantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
