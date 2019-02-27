package com.codecool.contributor.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import java.io.IOException;
import java.util.HashMap;

@UtilityClass
public class JwtDecoder {

    public HashMap jwtDecode(String token) throws IOException {
        token = token.replaceAll("^\"|\"$", "");
        Jwt decodedToken = JwtHelper.decode(token);
        String jwtClaims = decodedToken.getClaims();
        return new ObjectMapper().readValue(jwtClaims, HashMap.class);
    }
}
