package vn.kase.jee.ejb.exception;

public class AuthenticationException extends Exception {
    private static final long serialVersionUID = 7125839175531135216L;
    
    public AuthenticationException (String msg) {
        super(msg);
    }
}
