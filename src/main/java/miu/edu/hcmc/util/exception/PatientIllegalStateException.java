package miu.edu.hcmc.util.exception;

public class PatientIllegalStateException extends IllegalStateException {
    private static final long serialVersionUID = 1L;

    public PatientIllegalStateException(String message) {
        super(message);
    }

    public PatientIllegalStateException(Throwable e) {
        super(e);
    }

}