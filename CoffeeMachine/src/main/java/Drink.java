public enum Drink {
    Chocolate("H", 0.5),
    Coffee("C", 0.6),
    Tea("T", 0.4);

    private String code;
    private double price;

    Drink(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }
}
