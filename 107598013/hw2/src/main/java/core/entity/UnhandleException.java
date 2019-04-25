package core.entity;

public class UnhandleException extends RuntimeException {
    public UnhandleException() {
        super();
    }

    public UnhandleException(Throwable e) {
        super(e);
    }

    public UnhandleException(String msg) {
        super(msg);
    }

    public UnhandleException(String msg, Throwable e) {
        super(msg, e);
    }
}
