package exception;

public class DurationConversionErrorException extends RuntimeException{
    private String message;
    public DurationConversionErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
