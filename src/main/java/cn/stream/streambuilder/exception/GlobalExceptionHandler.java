package cn.stream.streambuilder.exception;

import cn.stream.streambuilder.web.base.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.InvocationTargetException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ClassCharSetIllegalException.class,ClassNotFoundException.class,IllegalAccessException.class,InstantiationException.class,NoSuchMethodException.class, InvocationTargetException.class})
    @ResponseBody
    public Object handlerSellerException(ClassCharSetIllegalException e) {
        log.error(e.getMessage(), e);
        return Response.fail(-1,"导入class类型错误,请详细查看'注意选项'");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Object badArgumentHandler(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return Response.fail(-1,"参数错误");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Object badArgumentHandler(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        return Response.fail(-1,"方法参数错误");
    }

}
