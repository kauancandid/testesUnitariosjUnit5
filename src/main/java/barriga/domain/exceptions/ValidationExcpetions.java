package barriga.domain.exceptions;

public class ValidationExcpetions extends RuntimeException {

    private static final long serialVersionUID = -2738361854550222002l;
    public ValidationExcpetions(String message) {
        super(message);
    }
}
