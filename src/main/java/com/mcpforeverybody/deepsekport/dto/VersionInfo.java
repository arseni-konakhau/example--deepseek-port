package com.mcpforeverybody.deepsekport.dto;

import java.time.Instant;

public class VersionInfo {
    
    private String version;
    private Instant buildTime;
    private String springBootVersion;
    private String javaVersion;

    public VersionInfo() {
    }

    public VersionInfo(String version, Instant buildTime, String springBootVersion, String javaVersion) {
        this.version = version;
        this.buildTime = buildTime;
        this.springBootVersion = springBootVersion;
        this.javaVersion = javaVersion;
    }

    // Getters and setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Instant getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Instant buildTime) {
        this.buildTime = buildTime;
    }

    public String getSpringBootVersion() {
        return springBootVersion;
    }

    public void setSpringBootVersion(String springBootVersion) {
        this.springBootVersion = springBootVersion;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
}
