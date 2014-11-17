package cn.believeus.exception;

// RuntimeException(运行时异常) Exception(非运行时异常)
public class UnSupportTypeExcetion extends RuntimeException {

	private static final long serialVersionUID = 3793710814157813546L;
	public UnSupportTypeExcetion() {
	}

	public UnSupportTypeExcetion(String message) {
		super(message);
	}

}
