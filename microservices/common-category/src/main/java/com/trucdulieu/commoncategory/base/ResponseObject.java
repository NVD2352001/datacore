package com.trucdulieu.commoncategory.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trucdulieu.commoncategory.config.Constant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {

    private int code;
    private String message;
    private Object data;
    private Integer count; // int vs Integer
    private Integer totalPage;
    private Integer sizeOfPage;
    private Date timestamp;

    public ResponseObject(String message) {
        this.message = message;
        this.code = -1;
    }

    public ResponseObject(Object data) {
        this.timestamp = new Date();
        this.code = 0;
        this.message = Constant.SUCCESS;
        if(data == null) {
            this.code = 1;
            this.message = Constant.FAILED;
        } else if(data instanceof List<?>) {
            this.count = ((List<?>) data).size();
            this.totalPage = 1;
            this.data = data;
        } else if(data instanceof Page<?>) {
            this.totalPage = ((Page<?>) data).getTotalPages();
            this.sizeOfPage = ((Page<?>) data).getSize();
            this.data = ((Page<?>) data).getContent();
        } else {
            this.data = data;
            this.count = null;
            this.totalPage = null;
            this.sizeOfPage = null;
        }
    }
}
