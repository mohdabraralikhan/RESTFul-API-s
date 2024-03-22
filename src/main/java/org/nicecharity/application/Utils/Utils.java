package org.nicecharity.application.Utils;

import org.nicecharity.application.user.LoginRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

public class Utils {

    public static LoginRequest extractLoginRequestFromBody(HttpServletRequest request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(request.getInputStream(), LoginRequest.class);
    }
}
