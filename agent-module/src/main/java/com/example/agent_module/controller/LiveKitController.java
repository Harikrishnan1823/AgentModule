//package com.example.agent_module.controller;
//
//import com.example.agent_module.service.LiveKitTokenService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/livekit")
//public class LiveKitController {
//
//    private final LiveKitTokenService tokenService;
//
//    public LiveKitController(LiveKitTokenService tokenService) {
//        this.tokenService = tokenService;
//    }
//
//    @GetMapping("/token")
//    public String getToken(
//            @RequestParam String identity,
//            @RequestParam String room
//    ) {
//        return tokenService.generateToken(identity, room);
//    }
//}



