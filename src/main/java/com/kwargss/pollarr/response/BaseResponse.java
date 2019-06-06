package com.kwargss.pollarr.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    public T data;

    public BaseResponse(T data) {
        this.data = data;
    }
}
