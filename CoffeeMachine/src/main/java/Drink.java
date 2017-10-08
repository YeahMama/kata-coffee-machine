public enum Drink {
    Chocolate("H"),
    Coffee("C"),
    Tea("T");

    private String code;

    Drink(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
