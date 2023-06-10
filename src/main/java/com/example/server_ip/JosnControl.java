package com.example.server_ip;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JosnControl {
    @GetMapping("/json")
    public String hello() {
        LocalDateTime now = LocalDateTime.now();
        String ipAddress = getIPAdress();
        String message = "Hello wold from server";

        Map<String, String> response = new HashMap<>();
        response.put("ipAddress", ipAddress);
        response.put("date", now.toString());
        response.put("message", message);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return "";
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private String getIPAdress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }
}
