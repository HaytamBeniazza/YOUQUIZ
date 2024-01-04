# WI-QUIZ-TIME
UML LINK:
https://lucid.app/lucidchart/ada89605-6805-4dfe-852a-10997e466a84/edit?viewport_loc=-1088%2C-532%2C4033%2C1840%2C0_0&invitationId=inv_8066f568-2b73-40d9-8a9b-a513df2c5333


## Api documentation
### Answer
endpoint| method | payload | description
-|--------|-|-
/answer| `POST` |`{ "assignQuiz": {"id" : 2}, "validation": {"id" : 3} }`| create a answer
/answer/{id}| `GET`  | `-` | find answer by id
/answer/{id}| `DELETE`  | `-` | delete answer by id
/answer/{id}| `PUT`  | `{ "assignQuiz": {"id" : 2}, "validation": {"id" : 3} }` | edit a answer
/answer| `GET` | `-` | get all levels

### Answer Quiz
endpoint| method | payload | description
-|--------|-|-
/assignquiz| `POST` |`{ "student": { "id" : 2 }, "quiz": {"id":2}, "score": 50, "chance": 5, "notes": "jme3 **** had lmra", "date": "2023-12-12" }`| create a assignquiz
/assignquiz/{id}| `GET`  | `-` | find assignquiz by id
/assignquiz/{id}| `DELETE`  | `-` | delete assignquiz by id
/assignquiz/{id}| `PUT`  | `{ "student": { "id" : 2 }, "quiz": {"id":2}, "score": 50, "chance": 5, "notes": "jme3 **** had lmra", "date": "2023-12-12" }` | edit a assignquiz
/assignquiz| `GET` | `-` | get all assignquizs

### Level
endpoint| method | payload | description
-|--------|-|-
/level| `POST` |`{ "description": "mediem", "maxPoints": 0, "minPoints": 0 }`| create a level
/level/{id}| `GET`  | `-` | find level by id
/level/{id}| `DELETE`  | `-` | delete level by id
/level/{id}| `PUT`  | `{ "description": "mediem", "maxPoints": 0, "minPoints": 0 }` | edit a level
/level| `GET` | `-` | get all levels

### Media
endpoint| method | payload | description
-|--------|-|-
/media| `POST` |`{ "src": "/Media/ahmedsoultan/", "type": "MP4", "question": { "id" : 1 } }`| create a media
/media/{id}| `GET`  | `-` | find media by id
/media/{id}| `DELETE`  | `-` | delete media by id
/media/{id}| `PUT`  | `{ "src": "/Media/ahmedsoultan/", "type": "MP4", "question": { "id" : 1 } }` | edit a media
/media| `GET` | `-` | get all medias

### Question Of Quiz
endpoint| method | payload | description
-|--------|-|-
/questionofquiz| `POST` |`{ "question": {"id" : 2}, "quiz": {"id" : 2} }`| create a questionofquiz
/questionofquiz/{id}| `GET`  | `-` | find questionofquiz by id
/questionofquiz/{id}| `DELETE`  | `-` | delete questionofquiz by id
/questionofquiz/{id}| `PUT`  | `{ "question": {"id" : 2}, "quiz": {"id" : 2} }` | edit a questionofquiz
/questionofquiz| `GET` | `-` | get all questionofquizs

### Question
endpoint| method | payload | description
-|--------|-|-
/question| `POST` |`{ "question": "what is the first rap album?", "numberOfAnswers": 1, "numberOfCorrectAnswers": 1, "questionType": null, "points": 0, "time": 0, "level": { "id" : 1 }, "subject": { "id" : 2 } }`| create a question
/question/{id}| `GET`  | `-` | find question by id
/question/{id}| `DELETE`  | `-` | delete question by id
/question/{id}| `PUT`  | `{ "question": "what is the first rap album?", "numberOfAnswers": 1, "numberOfCorrectAnswers": 1, "questionType": null, "points": 0, "time": 0, "level": { "id" : 1 }, "subject": { "id" : 2 } }` | edit a question
/question| `GET` | `-` | get all questions

### Quiz
endpoint| method | payload | description
-|--------|-|-
/quiz| `POST` |`{ "successResult": 19, "answerAccess": false, "resultAccess": false, "numberOfChances": 5, "comment": "3la 10 dh", "teacher": { "id" : 1 } }`| create a quiz
/quiz/{id}| `GET`  | `-` | find quiz by id
/quiz/{id}| `DELETE`  | `-` | delete quiz by id
/quiz/{id}| `PUT`  | `{ "successResult": 19, "answerAccess": false, "resultAccess": false, "numberOfChances": 5, "comment": "3la 10 dh", "teacher": { "id" : 1 } }` | edit a quiz
/quiz| `GET` | `-` | get all quizs

### Response
endpoint| method | payload | description
-|--------|-|-
/response| `POST` |`{ "response": "the weekend is rnb artist" }`| create a response
/response/{id}| `GET`  | `-` | find response by id
/response/{id}| `DELETE`  | `-` | delete response by id
/response/{id}| `PUT`  | `{ "response": "the weekend is rnb artist" }` | edit a response
/response| `GET` | `-` | get all responses

### Student
endpoint| method | payload | description
-|--------|-|-
/student| `POST` |`{ "lastName": "marouane", "firstName": "ait elhaj", "dateOfBirth": "2004-12-06", "address": "Attauia", "enrollmentDate": "2023-11-15", "quizzes": null }`| create a student
/student/{id}| `GET`  | `-` | find student by id
/student/{id}| `DELETE`  | `-` | delete student by id
/student/{id}| `PUT`  | `{ "lastName": "marouane", "firstName": "ait elhaj", "dateOfBirth": "2004-12-06", "address": "Attauia", "enrollmentDate": "2023-11-15", "quizzes": null }` | edit a student
/student| `GET` | `-` | get all students

### Subject
endpoint| method | payload | description
-|--------|-|-
/subject| `POST` |`{ "name": "drill", "top" : { "id" : 2 } }`| create a subject
/subject/{id}| `GET`  | `-` | find subject by id
/subject/{id}| `DELETE`  | `-` | delete subject by id
/subject/{id}| `PUT`  | `{ "name": "drill", "top" : { "id" : 2 } }` | edit a subject
/subject| `GET` | `-` | get all subjects

### Teacher
endpoint| method | payload | description
-|--------|-|-
/teacher| `POST` |`{ "question": { "id": 6 }, "response": { "id": 2 }, "points": 0, "correct": false }`| create a teacher
/teacher/{id}| `GET`  | `-` | find teacher by id
/teacher/{id}| `DELETE`  | `-` | delete teacher by id
/teacher/{id}| `PUT`  | `{ "question": { "id": 6 }, "response": { "id": 2 }, "points": 0, "correct": false }` | edit a teacher
/teacher| `GET` | `-` | get all teachers

### Validation
endpoint| method | payload | description
-|--------|-|-
/validation| `POST` |`{ "question": { "id": 6 }, "response": { "id": 2 }, "points": 0, "correct": false }`| create a validation
/validation/{id}| `GET`  | `-` | find validation by id
/validation/{id}| `DELETE`  | `-` | delete validation by id
/validation/{id}| `PUT`  | `{ "question": { "id": 6 }, "response": { "id": 2 }, "points": 0, "correct": false }` | edit a validation
/validation| `GET` | `-` | get all validations