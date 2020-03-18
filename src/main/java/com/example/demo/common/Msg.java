package com.example.demo.common;

/**
 * @author chengzhenxing
 * @date 2019/3/2
 */
public enum Msg {

    /**
     * success
     */
    Success(200, "success"),
    /**
     * code exception
     */
    CodeException(300, "code exception"),
    /**
     * parameter error
     */
    ParameterError(301, "parameter error"),
    /**
     * request type error
     */
    RequestTypeError(302, "request type error"),
    /**
     * bad request
     */
    BadRequest(400, "Bad Request!"),
    /**
     * no privilege
     */
    NoPrivilege(401, "no privilege"),
    /**
     * no privilege
     */
    NoUser(402, "no user"),
    /**
     * method not allowed
     */
    MethodNotAllowed(405, "method not allowed"),
    /**
     * method not acceptable
     */
    NotAcceptable(406, "method not acceptable"),
    /**
     * error
     */
    Error(500, "System internal error"),
    /**
     * database name not match
     */
    DBNameNotMatch(600, "database name not match"),
    /**
     * no data match
     */
    NoDataMatch(601, "no data match"),
    /**
     * sql error
     */
    SqlError(602, "sql error"),
    /**
     * [server] runtime exception
     */
    RuntimeException(700, "[server] runtime exception"),
    /**
     * [server] null pointer exception
     */
    NullPointerException(701, "[server] null pointer exception"),
    /**
     * [server] class cast exception
     */
    ClassCastException(702, "[server] class cast exception"),
    /**
     * [server] io exception
     */
    IoException(703, "[server] io exception"),
    /**
     * [server] no such method exception
     */
    NoSuchMethodException(704, "[server] no such method exception"),
    /**
     * [server] index out of bounds exception
     */
    IndexOutOfBoundsException(705, "[server] index out of bounds exception"),
    /**
     * [server] request not readable
     */
    RequestNotReadable(706, "[server] request not readable"),
    /**
     * create fail
     */
    CreateFail(901, "create fail"),
    /**
     * create fail
     */
    DuplicateKeyError(902, "This record already exists."),
    /**
     * update fail
     */
    UpdateFail(910, "update fail"),
    /**
     * query fail
     */
    QueryFail(930, "query fail"),
    /**
     * delete fail
     */
    DeleteFail(940, "delete fail");

    private int code;
    private String tip;

    public int getCode() {
        return code;
    }

    public String getTip() {
        return tip;
    }

    Msg(int code, String tip) {
        this.code = code;
        this.tip = tip;
    }
}
