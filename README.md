# Anime Database Analysis API

This project is a RESTful API built for a university assignment involving SQL database exploration using an ORM.  
The task was to load an SQL dump, connect to the database manually, and implement all API endpoints **without raw SQL querying**, using **Spring Boot + JPA (Hibernate)**.

The API returns structured JSON arrays for all endpoints, following the required output format.

---

## 🗄️ Database Dump Download

You can download the SQL dump used in this project from the link below:

👉 **Download Database Dump:**  
https://uupload.ir/view/anime_hbl8.zip/

(Place the file in your MySQL environment and import it before running the API.)

---

## 📌 Features

✔ Uses ORM (JPA + Hibernate) — **no raw SQL**  
✔ Follows the required 7 endpoints of the assignment  
✔ Supports pagination, filtering, and sorting  
✔ Fully JSON-based responses  
✔ Clean layered structure (Controller → Service → Repository → Entity)  
✔ SQL dump imported directly for initial data

---

## 🛠 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**

---

## 📁 Project Structure

src/ \n
└── main/ \n
└── java/com/example/animeapi/ \n 
├── controller/ # API endpoints \n
├── service/ # Business logic \n 
├── repository/ # ORM (JPA) queries \n 
├── model/ # Entities mapped to DB tables \n 
├── dto/ # Response DTOs \n 
└── AnimeApiApplication.java \n 


---

## 🚀 Running the Project

### 1. Import the SQL Dump
```bash
mysql -u root -p anime_db < anime_dump.sql
```

### 2. Configue application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/anime_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 3. Start the server
```bash
mvn spring-boot:run
```

server runs at:
```
http://localhost:8080
```

## 📚 API Endpoints

All endpoints return JSON arrays of objects as required.

### 1. Top Anime by Episode Count
```
GET /anime/top
```
Returns the top 10 anime with the highest episode count (descending).

Response fields:
id, title, score, episodes

### 2. Top Female Users by Average Score
```
GET /users/top?page=1&offset=10&year=2017&gender=F
```

Returns female users who:

- Registered after the given year

- Have an average rating above 8
- Sorted in descending average score.

- Pagination supported.

Response fields:
username, average_score

### 3. Anime Watched by User
```
GET /users/{username}/watched?count=10
```

Returns the first 10 anime watched by the user, sorted ascending by the score given by the user.

Response fields:
anime_id, title, user_score, episodes

### 4. Most Popular Genres
```
GET /anime/popular
```

Returns the top 3 most frequently watched genres.
(Each record in user_anime_list is counted as a watch.)

Response fields:
genre_name

### 5. Most Active Users in a Given Year
```
GET /users/active/{year}
```

Returns the 5 users who spent the most days watching anime in that year.

Response fields:
username, days_watched

### 6. Similar Users (Shared Anime)
```
GET /users/{username}/similars
```

Returns users who share the most anime with the target user.
Sorted by number of common anime (descending).

Response fields:
username, common_anime_count

### 7. Update Anime Episode Count
```
POST /anime/{anime_id}/episodes?value=1
```

Increases the episode count of the anime by:

The provided value

Default = 1 if not provided

Returns the updated record.

Response fields:
anime_id, current_episodes


## 📄 License

This project is for academic and educational purposes only.
