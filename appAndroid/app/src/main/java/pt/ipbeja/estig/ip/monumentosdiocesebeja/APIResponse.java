package pt.ipbeja.estig.ip.monumentosdiocesebeja;

public class APIResponse<T> {

    private T data;

    public APIResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
