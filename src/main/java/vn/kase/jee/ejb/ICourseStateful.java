package vn.kase.jee.ejb;

import vn.kase.jee.ejb.exception.AuthenticationException;

public interface ICourseStateful {
    void authen(String email, String password) throws AuthenticationException;

    void join(Integer linkId);
}
