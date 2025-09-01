package com.mcpforeverybody.deepsekport.dto;

public class AppInfo {
    
    private String name;
    private String version;
    private String description;
    private Endpoints endpoints;

    public AppInfo() {
    }

    public AppInfo(String name, String version, String description, Endpoints endpoints) {
        this.name = name;
        this.version = version;
        this.description = description;
        this.endpoints = endpoints;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    // Endpoints inner class
    public static class Endpoints {
        private String chat;
        private String version;

        public Endpoints() {
        }

        public Endpoints(String chat, String version) {
            this.chat = chat;
            this.version = version;
        }

        public String getChat() {
            return chat;
        }

        public void setChat(String chat) {
            this.chat = chat;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
