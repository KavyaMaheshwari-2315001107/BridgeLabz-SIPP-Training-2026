interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 12;
    }
}

public class ShoppingCartCouponValidator implements CouponValidator {
    private final String[] coupons = {"SAVE20", "DISCOUNT10", "XMAS5", "FREE100", "ABC"};

    @Override
    public boolean validateCoupon(String code) {
        if (code == null || !CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.matches("[A-Z0-9]+") && (code.contains("SAVE") || code.contains("DISCOUNT") || code.contains("FREE") || code.matches("^[A-Z]{3}[0-9]{1,3}$"));
    }

    public void validateAll() {
        for (String coupon : coupons) {
            boolean valid = validateCoupon(coupon);
            System.out.println(coupon + " is " + (valid ? "valid" : "invalid"));
        }
    }

    public static void main(String[] args) {
        ShoppingCartCouponValidator cart = new ShoppingCartCouponValidator();
        cart.validateAll();
    }
}
