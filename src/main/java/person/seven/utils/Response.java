package person.seven.utils;

import java.io.Serializable;

/**
 * 接口数据返回通用对象
 * 
 * @author seven
 *
 */
public class Response implements Serializable {

	
	private static final String OK = "200";
	private static final String FAIL = "400";
	public static final String ERROR_PARAM = "10000002";
	public static final String ERROR_REQUEST = "10000001";

	/* 返回码 */
	private String code;
	/* 返回描述 */
	private String message;
	/* 消息体 */
	private Object body;

	private static final String SUCCESS_MSG = "请求成功";

	public Response() { }

	public static Response SUCCESS = new Response(OK, SUCCESS_MSG);

	public static Response success(Object data) {
		return new Response(OK, SUCCESS_MSG, data);
	}

	public static Response fail(String code,String message, Object data) {
		return new Response(code, message, data);
	}

	public static Response fail(String message) {
		return new Response(FAIL, message, null);
	}

	public static Response success(String message, Object data) {
		return new Response(OK, message, data);
	}

	public Response(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Response(String code, String message, Object body) {
		this.code = code;
		this.message = message;
		this.body = body;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
