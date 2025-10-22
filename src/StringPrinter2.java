class StringPrinter2 {
    public StringPrinter2(String msg) {
        System.out.println("Constructor called with message: " + msg);
    }

    public static void main(String[] args) {
        StringPrinter2[] arr = new StringPrinter2[3];

        // Create objects and attach to array
        arr[0] = new StringPrinter2("Hello");
        arr[1] = new StringPrinter2("World");
        arr[2] = new StringPrinter2("Java");

        System.out.println("All objects attached to array");
    }
}
