# Spring Boot Translation Service with Redis Caching

## Overview
This project is a **Spring Boot** application that provides translation services using **Google Apps Script API** and caches responses using **Redis**. The application is built with **Gradle** for dependency management and integrates Redis to optimize performance by reducing external API calls.

## Features
- **Translate text** using Google Apps Script API.
- **Cache translations** in Redis to reduce API calls.
- **Spring Boot REST API** for handling translation requests.
- **Lettuce Redis client** for optimal performance.

## Tech Stack
- **Spring Boot** (Backend framework)
- **Spring Cache** (Caching abstraction)
- **Redis** (Caching layer)
- **Lettuce** (Redis client)
- **Gradle** (Build system)

## Setup Instructions

### 1. Prerequisites
Ensure you have the following installed:
- Java 17+ (Recommended)
- Redis Server (Standalone or Docker)
- Gradle 7+

### 2. Clone the Repository
```sh
git clone https://github.com/your-repo/spring-boot-translation.git
cd spring-boot-translation
```

### 3. Configure Redis
#### Option 1: Run Redis Locally
If you have Redis installed, start the Redis server:
```sh
redis-server
```

#### Option 2: Run Redis with Docker
```sh
docker run --name redis -d -p 6379:6379 redis
```

### 4. Configure Application Properties
Modify `src/main/resources/application.properties`:
```properties
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.timeout=6000ms
spring.redis.lettuce.pool.max-active=8
spring.redis.lettuce.pool.max-idle=8
spring.redis.lettuce.pool.min-idle=2
```

### 5. Build and Run the Application
```sh
./gradlew bootRun
```

## API Endpoints
### 1. Translate Text
**Endpoint:**
```http
POST /translate
```
**Request Body:**
```json
{
  "text": "Hello, how are you?",
  "sourceLang": "en",
  "targetLang": "ja"
}
```
**Response:**
```json
{
  "sourceText": "Hello, how are you?",
  "translatedText": "こんにちは、お元気ですか？"
}
```

## Redis Caching Strategy
- The application first **checks Redis** for an existing translation.
- If not found, it **fetches the translation from the API** and stores it in Redis.
- Translations are cached for **24 hours** to optimize performance.

## TranslateAPI using Google Apps Script
![Image](https://github.com/user-attachments/assets/00e95212-db3e-445f-b1b0-fc6ea7491ec6)

 
