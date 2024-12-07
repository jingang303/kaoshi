package org.example.springboot.exception;

public class CustomerException extends RuntimeException {

    private String code;
    private String mesg;

    public CustomerException( String code,String message) {
        this.mesg=message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
