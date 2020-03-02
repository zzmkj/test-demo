package com.geek.test.core;

import com.geek.test.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname: GlobalExceptionAdvice
 * @Author: Ming
 * @Date: 2020/3/2 2:26 下午
 * @Version: 1.0
 * @Description: 全局异常处理
 **/
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        System.out.println(e);

        String url = req.getRequestURI();
        String method = req.getMethod();

        UnifyResponse response = new UnifyResponse(9999, "未知异常", method + url);
        return response;
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e) {
        System.out.println(e);

        String url = req.getRequestURI();
        String method = req.getMethod();

        String message = exceptionCodeConfiguration.getMessage(e.getCode());

        UnifyResponse response = new UnifyResponse(e.getCode(), message, method + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        ResponseEntity responseEntity = new ResponseEntity(response, headers, httpStatus);
        return responseEntity;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public UnifyResponse handleConstraintException(HttpServletRequest req, ConstraintViolationException e) {
        String url = req.getRequestURI();
        String method = req.getMethod();

        String message = e.getMessage();

        UnifyResponse response = new UnifyResponse(80001, message, method + url);
        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public UnifyResponse handleConstraintException(HttpServletRequest req, MethodArgumentNotValidException e) {
        String url = req.getRequestURI();
        String method = req.getMethod();

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
//        String message = formatAllErrorMessage(errors);
        String message = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

        UnifyResponse response = new UnifyResponse(80001, message, method + url);
        return response;
    }

    private String formatAllErrorMessage(List<ObjectError> errors) {
        StringBuffer errMsg = new StringBuffer();
        errors.forEach(error -> errMsg.append(error.getDefaultMessage()).append(";"));
        return errMsg.toString();
    }

}
