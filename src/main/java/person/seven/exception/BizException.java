package person.seven.exception;

/**
 * 通用异常类
 * 
 * @author seven
 *
 */
public class BizException extends RuntimeException {


	public static final BizException ERROR_REQUEST = new BizException(
			10000001, "非法请求");
	public static final BizException ERROR_PARAM = new BizException(
			10000002, "非法参数错误");
	
	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected int code;


	 public BizException(int code, String msgFormat, Object... args) {
	        super(String.format(msgFormat, args));
	        this.code = code;
	        this.msg = String.format(msgFormat, args);
	    }

	    public BizException() {
	        super();
	    }

	    public BizException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public BizException(Throwable cause) {
	        super(cause);
	    }

	    public BizException(String message) {
	        super(message);
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public int getCode() {
	        return code;
	    }

	    /**
	     * 实例化异常
	     * 
	     * @param msgFormat
	     * @param args
	     * @return
	     */
	    public BizException newInstance(String msgFormat, Object... args) {
	        return new BizException(this.code, msgFormat, args);
	    }

		@Override
		public synchronized Throwable fillInStackTrace() {
			return this;
		}
	    
	    
}
