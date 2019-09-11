package personal.buildbroad.http;


import personal.buildbroad.model.Result;

public interface IBaseServiceCallBack<T> {

    void onError(Exception e);

    void onSuccess(Result result);

}
