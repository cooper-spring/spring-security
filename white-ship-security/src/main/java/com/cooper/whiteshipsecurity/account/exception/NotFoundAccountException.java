package com.cooper.whiteshipsecurity.account.exception;

public class NotFoundAccountException extends RuntimeException {

    private static final String NOT_FOUND_ACCOUNT_MESSAGE_FORMAT = "입력한 username 으로 사용자를 찾을 수 없습니다 : %s";

    public NotFoundAccountException(String username) {
        super(String.format(NOT_FOUND_ACCOUNT_MESSAGE_FORMAT, username));
    }

}
