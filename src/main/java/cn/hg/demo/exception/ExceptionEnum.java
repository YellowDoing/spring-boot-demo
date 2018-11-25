package cn.hg.demo.exception;

public enum ExceptionEnum {

    EXCEPTION_PARAM_VALIDATE(10001, "参数错误"),
    EXCEPTION_MISSING_REQUEST_BODY(10002, "Json解析错误"),
    EXCEPTION_TOKEN_VALIDATE(10003, "token失效,请重新登陆"),
    EXCEPTION_UPDATE_DATA(10200, "修改数据失败"),
    EXCEPTION_INSERT_DATA(10107, "插入数据库失败");
    private final  int code;
    private final String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
