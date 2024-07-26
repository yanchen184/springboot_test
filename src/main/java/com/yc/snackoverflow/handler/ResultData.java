package com.yc.snackoverflow.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultData<T> {

    private String status;
    private String message;
    private T data;

    public static <T> ResultData<T> success(T data) {

        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus("200");
        resultData.setMessage("success");
        resultData.setData(data);

        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {

        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);

        return resultData;
    }
}