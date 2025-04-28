![image](https://github.com/user-attachments/assets/5e679529-a884-4f7a-8a68-74d0224e888c)

![image](https://github.com/user-attachments/assets/d2a6ba8d-ff6c-49d7-b86c-c4e197d3857c)

![image](https://github.com/user-attachments/assets/9c7d847b-ef0a-4721-8788-05bd6ba1db35)

![image](https://github.com/user-attachments/assets/aea28ec0-58b5-41ab-8661-da7fc7a37048)

The Controller:
![image](https://github.com/user-attachments/assets/b5df7e34-b3db-40e4-aa54-c0d2579ec1fb)

First 4 tests:
![image](https://github.com/user-attachments/assets/8d8c36d0-3538-4d69-9145-ae5bc6adbc2c)

Second 4 tests:

![image](https://github.com/user-attachments/assets/ad0e0bf6-9665-4272-9add-2bfdfacd185c)

Third 4 tests 'kill the mutants':
![image](https://github.com/user-attachments/assets/b3665cfc-5dea-4f83-9cf6-3f7f03707eb4)

Html to post data once runing: 

//**<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit Comment</title>
</head>
<body>
    <h1>Submit a Comment</h1>
    <form method="POST" action="http://localhost:8081/comments">
        <label>Comment Text: <input type="text" name="text" value="Hello from Browser!"/></label><br><br>
        <label>Security Rating (optional): <input type="number" name="securityRating" min="1" max="10"/></label><br><br>
        <button type="submit">Submit Comment</button>
    </form>
</body>
</html>**//

Sample looks:
![image](https://github.com/user-attachments/assets/ab30d154-21ec-4621-99c5-cb10f05a75ce)

Sample response:
![image](https://github.com/user-attachments/assets/02903335-4c36-499b-90e1-850b0cee4da2)








