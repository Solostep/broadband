package personal.buildbroad.http;

import java.util.Date;
import java.util.List;

public interface IServiceCallBack<T> {

	void onError();

	void onSuccess(String code, List<T> result, Integer totalSize, Integer pageNo);

	void onSuccess(String code, T result);

	void onSuccess(String code);

	void onSuccess(String code, List<T> result, Integer totalSize, Integer pageNo, Date serviceTime);
}
