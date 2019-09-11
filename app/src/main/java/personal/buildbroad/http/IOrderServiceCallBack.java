package personal.buildbroad.http;



public interface IOrderServiceCallBack<T> {

    void onError(Exception e);

    void onSuccess(String str);

}
