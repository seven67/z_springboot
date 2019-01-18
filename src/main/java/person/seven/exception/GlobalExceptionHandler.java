package person.seven.exception;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import person.seven.utils.BackWebUtil;
import person.seven.utils.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常统一处理类
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 所有异常报错
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView allExceptionHandler(HttpServletRequest request,
			HttpServletResponse response, Exception exception) throws Exception {
		Response rs = null;
		if (exception instanceof BizException) {
			BizException e = (BizException) exception;
			rs = new Response(e.getCode()+"" , e.getMsg());
			logger.error("异常,code:{},messge{}", e.getCode(), e.getMsg());
		}else {
			rs = new Response(Response.ERROR_REQUEST, "非法请求");
			logger.error(exception.getMessage(), exception);
		}
		BackWebUtil.writeJsonToClient(response, JSONObject.fromObject(rs).toString());
		return null;
	}

}
