package homeworks.homework29.hwSelenidePO;

public class CartPageLogic extends CartPageElement{

    public String cartItemTitleText() {
        return cartItemTitle.text().trim();
    }
}
