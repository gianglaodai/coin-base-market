package leo.prj.petrocoin.bean.backobject;

import leo.prj.petrocoin.common.CommonConstant;

public class ResponseObject<T> {
	private String message;
	private T value;

	public ResponseObject(String message, T value) {
		this.message = message;
		this.value = value;
	}

	public ResponseObject(T value) {
		this(CommonConstant.EMPTY, value);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
