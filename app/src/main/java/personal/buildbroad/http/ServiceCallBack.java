package personal.buildbroad.http;

import java.util.Date;
import java.util.List;

public abstract class ServiceCallBack<T> implements IServiceCallBack<T> {

    public void onError() {
    }

    public void onSuccess(String code, List<T> result, Integer totalSize,
                          Integer pageNo) {
    }

    public void onSuccess(String code, List<T> result, Integer totalSize,
                          Integer pageNo, Integer flag) {
    }

    public void onSuccess(String code, T result) {
    }

    public void onSuccess(String code) {
    }

    public void onSuccess(String code, List<T> result, Integer totalSize,
                          Integer pageNo, Date serviceTime) {
    }
}
