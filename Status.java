package taskmate;
/**
 * @author Vignesh G
 * @apiNote
 * A enum Status to keep track of the state of the task
 */
public enum Status {
    TODO("todo"),
    IN_PROGRESS("in progress"),
    DONE("done");

    private final String value;

    Status(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
