package personal.buildbroad.model;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {

	private String statusCode;

	private String result;

	private Integer totalSize;

	private Integer totalCount;

	private String message;
	
	private Date serviceTime;

	private String errcode;

	private String errmsg;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "Result{" +
				"statusCode='" + statusCode + '\'' +
				", result='" + result + '\'' +
				", totalSize=" + totalSize +
				", totalCount=" + totalCount +
				", message='" + message + '\'' +
				", serviceTime=" + serviceTime +
				", errcode='" + errcode + '\'' +
				", errmsg='" + errmsg + '\'' +
				'}';
	}
}
