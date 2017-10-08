public enum Drink {
    Chocolate("Hh", 0.5),
    Coffee("Ch", 0.6),
    Orange("O", 0.6),
    Tea("Th", 0.4);

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
