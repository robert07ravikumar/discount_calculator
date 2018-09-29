package com.retail.discount;

public class UserNotValidException extends Exception {

	private static final long serialVersionUID =  323L;

    public UserNotValidException() {
        super("User is not valid");
    }

}