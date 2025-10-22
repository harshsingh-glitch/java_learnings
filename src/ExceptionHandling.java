
class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

class FileProcessingException extends Exception {
    public FileProcessingException(String message) {
        super(message);
    }
}
public class ExceptionHandling {

    public static void riskyOperation(int option) throws DatabaseException, NetworkException, FileProcessingException {
        switch (option) {
            case 1:
                throw new DatabaseException("Database connection failed!");
            case 2:
                throw new NetworkException("Network timeout occurred!");
            case 3:
                throw new FileProcessingException("File could not be processed!");
            case 4:
                throw new NullPointerException("Unexpected null value!");
            default:
                System.out.println("Operation completed successfully!");
        }
    }

    public static void main(String[] args) {
        try {
            riskyOperation(1);
        }
        catch (DatabaseException | NetworkException | FileProcessingException e) {
            System.err.println("Handled custom exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Handled general exception: " + e.getMessage());
        }
        finally {
            System.out.println("Finally block executed — resource cleanup or final logging here.");
        }

        System.out.println("Program completed normally.");
    }
}
