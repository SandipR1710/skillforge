package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {
    private final GitHubService gitHubService;
    public GitHubController(GitHubService gitHubService){
        this.gitHubService = gitHubService;
    }

    @GetMapping("/gitHub/{username}")
    public int getRepoCount(@PathVariable String username){
        int result = gitHubService.getPublicRepoCount(username);
        return result;
    }
}
