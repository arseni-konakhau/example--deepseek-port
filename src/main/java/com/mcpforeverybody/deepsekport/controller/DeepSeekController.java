package com.mcpforeverybody.deepsekport.controller;

import com.mcpforeverybody.deepsekport.dto.AppInfo;
import com.mcpforeverybody.deepsekport.dto.ChatRequest;
import com.mcpforeverybody.deepsekport.dto.ChatResponse;
import com.mcpforeverybody.deepsekport.dto.VersionInfo;
import com.mcpforeverybody.deepsekport.service.DeepSeekService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class DeepSeekController {

    private final DeepSeekService deepSeekService;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${project.description:Basic DeepSeek Connection App}")
    private String appDescription;

    public DeepSeekController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @GetMapping("/")
    public ResponseEntity<AppInfo> getAppInfo() {
        AppInfo.Endpoints endpoints = new AppInfo.Endpoints("/api/chat", "/api/version");
        AppInfo appInfo = new AppInfo(
            appName,
            "0.0.1-SNAPSHOT",
            appDescription,
            endpoints
        );
        return ResponseEntity.ok(appInfo);
    }

    @GetMapping("/version")
    public ResponseEntity<VersionInfo> getVersionInfo() {
        VersionInfo versionInfo = new VersionInfo(
            "0.0.1-SNAPSHOT",
            Instant.now(),
            "3.5.5",
            "21"
        );
        return ResponseEntity.ok(versionInfo);
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
        ChatResponse response = deepSeekService.processChat(request);
        return ResponseEntity.ok(response);
    }
}
