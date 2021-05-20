package org.gruzdov.spring.springboot.spring_course_springboot_rest.exception_handling;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
