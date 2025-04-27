package com.hw3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @PostMapping
    public ResponseEntity<String> submitComment(@RequestParam String text,
                                                @RequestParam(required = false) Integer securityRating) {
        if (text == null || text.length() <= 3 || text.length() >= 300) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comment length must be between 3 and 300 characters.");
        }

        if (text.matches(".*[\"';\\.\\(\\)%,].*")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comment contains forbidden characters.");
        }

        if (securityRating != null && (securityRating <= 1 || securityRating >= 10)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security rating must be between 1 and 10 if specified.");
        }

        return ResponseEntity.ok("Comment submitted successfully.");
    }
}
