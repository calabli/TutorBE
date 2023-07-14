package com.tutor.tutorbe.exception;



import com.tutor.tutorbe.base.FacadeResponse;
import com.tutor.tutorbe.base.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenjun
 * 
 * 异常处理配置
 *
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdapter {
	
	/**
	 * 应用层面的业务代码级别异常处理
	 * @param codeException
	 * @return
	 */
	@ExceptionHandler(CodeException.class) 
	public FacadeResponse<Void> handleCodeException(CodeException codeException) {
		log.info("code: {}, message: {}, CodeException:", codeException.getCode(), codeException.getMsg(), codeException);
		FacadeResponse<Void> facadeResponse = new FacadeResponse<>();
		facadeResponse.setSucceeded(false);
		facadeResponse.setResponseCode(ResponseCode.SYSTEM_ERROR);
		facadeResponse.setResponseMsg(codeException.getMsg());
		facadeResponse.setBizError(codeException.getCode());
		return facadeResponse;
	}



}
