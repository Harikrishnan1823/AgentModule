package com.example.agent_module.service;

import io.livekit.server.AccessToken;
import io.livekit.server.RoomJoin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LiveKitTokenService {

    @Value("${livekit.api-key}")
    private String apiKey;

    @Value("${livekit.api-secret}")
    private String apiSecret;

    public String generateToken(String identity, String roomName) {
        RoomJoin roomJoin = new RoomJoin(true); // pass publish & room in constructor

        AccessToken token = new AccessToken(apiKey, apiSecret);
        token.setIdentity(identity);
        token.setTtl(3600); // 1 hour in seconds
        token.addGrants(roomJoin);

        return token.toJwt();
    }
}







