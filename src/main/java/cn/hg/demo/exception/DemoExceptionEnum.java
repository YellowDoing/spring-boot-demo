package cn.hg.demo.exception;

public enum DemoExceptionEnum {

    VALIDATE_EXCEPTION(10001, "参数错误"),
    MISSING_REQUEST_BODY_EXCEPTION(10002, "Json解析错误"),
    TOKEN_VALIDATE__EXCEPTION(10100, "请重新登陆"),
    TNUMBER_FORMAt_EXCEPTION(10101, "请输入正确的数字");

    final private int code;
    private String message;

    DemoExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public DemoExceptionEnum setMeaage(String meaage) {
        this.message = meaage;
        return this;
    }

    public String getMeaage() {
        return message;
    }
}
