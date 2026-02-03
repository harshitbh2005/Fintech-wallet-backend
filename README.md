# Fintech Wallet Backend

A Spring Boot based backend for a digital wallet similar to Paytm / PhonePe.

## Features
- User signup & login (JWT based authentication)
- Wallet created automatically for each user
- Send money between users
- View wallet balance
- Transaction history
- PostgreSQL database

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT
- Hibernate (JPA)
- PostgreSQL
- Maven

## APIs
POST  /auth/signup  
POST  /auth/login  
GET   /wallet/balance  
POST  /wallet/transfer  
GET   /wallet/transactions  

## How to Run
1. Create PostgreSQL database `walletdb`
2. Update `application.properties`
3. Run:


This project demonstrates a real-world fintech wallet backend with authentication, transactions, and database integration.

