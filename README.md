# Dating Recommendation Engine

## Overview
The Dating Recommendation Engine is a Spring Boot application that provides recommendations for potential matches based on gender, age, and interests. It also includes messaging functionality, allowing users to exchange messages.

---

## Features
1. Register users with attributes like name, gender, age, and interests.
2. Retrieve the top matches for any user based on:
   - Opposite gender preference.
   - Closest age.
   - Shared interests.
3. Messaging:
   - Send messages to other users.
   - Retrieve conversation history.
   - Mark messages as read.

---

## Prerequisites
1. **Java:** JDK 17 or later.
2. **Maven:** Version 3.6+.
3. **Database:** MySQL.
4. **Postman:** (Optional) for testing REST APIs.

---

## Installation

### 1. Clone the Repository
```bash
$ git clone https://github.com/your-username/dating-recommendation-engine.git
$ cd dating-recommendation-engine
```

### 2. Configure the Database
1. Create a database in MySQL:
   ```sql
   CREATE DATABASE datingdb;
   ```
2. Update the `application.properties` file in the `src/main/resources` directory with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/datingdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### 3. Build the Application
Run the following command to build the application:
```bash
$ mvn clean install
```

### 4. Run the Application
Start the Spring Boot application:
```bash
$ mvn spring-boot:run
```
The application will start on `http://localhost:8080` by default.

---

## Usage

### **Endpoints**

#### 1. **Register a User**
**POST** `/users`

**Request Body:**
```json
{
  "name": "Alice",
  "gender": "Female",
  "age": 25,
  "interests": ["Cricket", "Chess"]
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Alice",
  "gender": "Female",
  "age": 25,
  "interests": ["Cricket", "Chess"]
}
```

#### 2. **Fetch Matches**
**GET** `/users/{id}/matches?limit={limit}`

**Example:** `/users/1/matches?limit=2`

**Response:**
```json
[
  {
    "id": 2,
    "name": "Bob",
    "gender": "Male",
    "age": 27,
    "interests": ["Football", "Movies"]
  },
  {
    "id": 3,
    "name": "Charlie",
    "gender": "Male",
    "age": 26,
    "interests": ["Tennis", "Cricket"]
  }
]
```

#### 3. **Send a Message**
**POST** `/messages/send?senderId={senderId}&receiverId={receiverId}`

**Request Body:** (Plain text)
```
Hello Bob! How are you?
```

**Response:**
```json
{
  "id": 1,
  "senderId": 1,
  "receiverId": 2,
  "content": "Hello Bob! How are you?",
  "timestamp": "2025-01-22T14:45:00"
}
```

#### 4. **Fetch Conversation**
**GET** `/messages/conversation?userId1={userId1}&userId2={userId2}`

**Response:**
```json
[
  {
    "id": 1,
    "senderId": 1,
    "receiverId": 2,
    "content": "Hello Bob! How are you?",
    "timestamp": "2025-01-22T14:45:00"
  },
  {
    "id": 2,
    "senderId": 2,
    "receiverId": 1,
    "content": "I'm good, Alice! How about you?",
    "timestamp": "2025-01-22T14:46:00"
  }
]
```

#### 5. **Mark Messages as Read**
**PUT** `/messages/mark-as-read?userId={userId}&senderId={senderId}`

**Response:**
- **Status:** `200 OK`
- **Body:** _(Empty)_

---

## Testing

### Unit Testing
Run the following command to execute the test cases:
```bash
$ mvn test
```

### API Testing
Use Postman or any other API testing tool to test the endpoints.
1. Start the application.
2. Use the base URL: `http://localhost:8080`.
3. Test the provided endpoints.

---

## Technologies Used
1. **Java** (JDK 17+)
2. **Spring Boot**
3. **Maven**
4. **MySQL**
5. **JUnit** for testing

---

## Troubleshooting
1. **Database Connection Issues:**
   - Ensure the database is running and accessible.
   - Verify credentials in `application.properties`.

2. **Port Conflict:**
   - If `8080` is in use, change the port in `application.properties`:
     ```properties
     server.port=8081
     ```

---

## Author
-sunilkumar
-https://github.com/SunilkumarDodamani


