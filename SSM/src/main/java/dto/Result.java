package dto;

/**
 * ��װjson�������з��ؽ����ʹ����
 */
public class Result<T> {
	private boolean success; //�Ƿ�ɹ���־
	private T data; //�ɹ�ʱ���ص�����
	private String error; //������Ϣ
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
// �ɹ�ʱ�Ĺ�����
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	
//	����ʱ�Ĺ�����
	public Result(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", data=" + data + ", error=" + error + "]";
	}
	
	
}
