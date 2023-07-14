package com.tutor.tutorbe.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeExceptionAssert {
    public static void isTrue(boolean expression, String code, String message) {
        if (!expression) {
            log.error("get {} error because of {}", code, message);
            throw new CodeException(code, message);
        }
    }
}
