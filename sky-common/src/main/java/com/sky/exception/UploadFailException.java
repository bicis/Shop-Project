package com.sky.exception;

/**
 * 图片上传失败
 */
public class UploadFailException extends BaseException{

    public UploadFailException(String msg) {
        super(msg);
    }
}
