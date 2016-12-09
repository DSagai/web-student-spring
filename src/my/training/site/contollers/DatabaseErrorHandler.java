package my.training.site.contollers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {

	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(){
		return "error";
	}
}
