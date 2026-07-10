package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class GitHubService {
    private final RestClient client;

    public GitHubService(RestClient client) {
        this.client = client;
    }

    public int getPublicRepoCount(String userName){
        Map<String,Object> result = client.get().uri("https://api.github.com/users/{username}", userName).retrieve().body(Map.class);
        int count = (int) result.get("public_repos");
        return count;
    }
}
