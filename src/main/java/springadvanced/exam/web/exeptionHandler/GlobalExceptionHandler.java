package springadvanced.exam.web.exeptionHandler;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleDbExceptions() {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
