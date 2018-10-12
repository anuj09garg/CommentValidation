# CommentValidation
This repository is to validate the comments posted by the customers


This repository is to validate the comments posted by the customers

Below curl Request can be used to run.

curl -X POST 
http://localhost:8080/target/v1/checkObjectionableContent 
-H 'Cache-Control: no-cache' 
-H 'Content-Type: application/json' 
-H 'Postman-Token: 75f82c37-65c9-4919-9a53-e4c78d4fe4c1' 
-d '{ "userId":912839, "emailId":"useremail@gmail.com", "itemId":1238479, "comment":"this shit is the best product bla bla blah" }'
