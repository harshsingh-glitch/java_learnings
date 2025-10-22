class StringPrinter {
    public StringPrinter(String msg) {
        System.out.println("Constructor called with message: " + msg);
    }

    public static void main(String[] args) {
        StringPrinter[] arr = new StringPrinter[5]; // Array of references
        System.out.println("Array created but objects not initialized");
    }
}
