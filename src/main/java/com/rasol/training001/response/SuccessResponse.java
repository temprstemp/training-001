package com.rasol.training001.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

public class SuccessResponse extends BaseResponse{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public SuccessResponse(HttpServletRequest request, Object body){
        setTimestamp(Instant.now().toString());
        setPath(request.getRequestURI());
        try {
            setBody(objectMapper.writeValueAsString(body));
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
