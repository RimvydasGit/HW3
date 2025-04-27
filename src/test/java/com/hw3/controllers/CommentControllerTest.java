package com.hw3.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentControllerTest {

    private final CommentController controller = new CommentController();

    @Test
    public void testTooShortComment() {
        ResponseEntity<String> response = controller.submitComment("Hi", 5);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment length must be between 3 and 300 characters.", response.getBody());
    }

    @Test
    public void testTooLongComment() {
        String longText = "A".repeat(300);
        ResponseEntity<String> response = controller.submitComment(longText, 5);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment length must be between 3 and 300 characters.", response.getBody());
    }

    @Test
    public void testForbiddenCharactersInComment() {
        ResponseEntity<String> response = controller.submitComment("Hello%", 5);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment contains forbidden characters.", response.getBody());
    }

    @Test
    public void testInvalidSecurityRatingLow() {
        ResponseEntity<String> response = controller.submitComment("Good comment", 1);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Security rating must be between 1 and 10 if specified.", response.getBody());
    }

    @Test
    public void testInvalidSecurityRatingHigh() {
        ResponseEntity<String> response = controller.submitComment("Good comment", 10);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Security rating must be between 1 and 10 if specified.", response.getBody());
    }

    @Test
    public void testValidCommentWithRating() {
        ResponseEntity<String> response = controller.submitComment("Nice post!", 5);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Comment submitted successfully.", response.getBody());
    }

    @Test
    public void testValidCommentWithoutRating() {
        ResponseEntity<String> response = controller.submitComment("Really nice!", null);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Comment submitted successfully.", response.getBody());
    }
    @Test
    public void testNullComment() {
        ResponseEntity<String> response = controller.submitComment(null, 5);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment length must be between 3 and 300 characters.", response.getBody());
    }
    //Mutant killing
    @Test
    void testCommentLengthExactlyThree() {
        ResponseEntity<String> response = controller.submitComment("abc", null);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment length must be between 3 and 300 characters.", response.getBody());
    }
    @Test
    void testCommentLengthExactlyThreeHundred() {
        String text = "a".repeat(300); // 300 characters
        ResponseEntity<String> response = controller.submitComment(text, null);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Comment length must be between 3 and 300 characters.", response.getBody());
    }
    @Test
    void testSecurityRatingExactlyOne() {
        ResponseEntity<String> response = controller.submitComment("Valid comment", 1);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Security rating must be between 1 and 10 if specified.", response.getBody());
    }
    @Test
    void testSecurityRatingExactlyTen() {
        ResponseEntity<String> response = controller.submitComment("Valid comment", 10);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Security rating must be between 1 and 10 if specified.", response.getBody());
    }
}