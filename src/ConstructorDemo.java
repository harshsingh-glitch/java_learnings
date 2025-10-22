class ConstructorDemo {
    private int value;

    // First constructor
    public ConstructorDemo() {
        this(42); // Call second constructor with default value
        System.out.println("First constructor executed");
    }

    // Second constructor
    public ConstructorDemo(int value) {
        this.value = value;
        System.out.println("Second constructor executed with value: " + value);
    }

    public static void main(String[] args) {
        ConstructorDemo obj = new ConstructorDemo();
    }
}
