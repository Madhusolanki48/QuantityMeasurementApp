# 🚀 Quantity Measurement Application

---

## 🔍 Overview

A backend system built with **Spring Boot** to perform operations on physical quantities such as length, weight, volume, and temperature.

The project evolves through **use-case driven development (UC1–UC18)**, starting from basic unit comparisons to a fully secure backend with authentication and persistence.

---

## ⚙️ What this project does

- ➕ Perform arithmetic operations on quantities  
- 🔄 Convert values across different measurement units  
- 📏 Handle multiple measurement domains  
- 🔐 Secure APIs using JWT and OAuth2  
- 🗄️ Store and retrieve operation history  

---

## 🧱 How it is built

The application follows a layered architecture:

```
Controller → Service → Repository → Database
```

- 🧠 Business logic is centralized  
- 📦 DTOs are used for clean data flow  
- 🔁 Each layer has a single responsibility  

---

## 🌿 Development approach

Each feature is developed independently using branches.

### 🟢 Core (UC1 – UC9)

```
feature/UC1-FeetEquality
feature/UC2-InchEquality
feature/UC3-GenericLength
feature/UC4-YardEquality
feature/UC5-UnitConversion
feature/UC6-UnitAddition
feature/UC7-TargetUnitAddition
feature/UC8-StandaloneUnit
feature/UC9-WeightMeasurement
```

---

### 🔵 Advanced (UC10 – UC14)

```
feature/UC10-GenericQuantityWithUnitInterface
feature/UC11-VolumeMeasurementEquality
feature/UC12-SubtractionDivision
feature/UC13-CentralizedArithmeticLogic
feature/UC14-TemperatureMeasurement
```

---

### 🟣 Backend & Security (UC15 – UC18)

```
feature/UC15-NTierArchitecture
feature/UC16-DatabaseIntegrationJDBC
feature/UC17-SpringBackend
feature/UC18-GoogleAuthUserManagement
```

---

## 📡 API Endpoints

```
POST   /api/v1/measurements/add
POST   /api/v1/measurements/subtract
POST   /api/v1/measurements/divide
POST   /api/v1/measurements/convert
POST   /api/v1/measurements/compare
GET    /api/v1/measurements/history
```

---

## 📦 Example Request

```json
{
  "first": {
    "value": 1,
    "unit": "FEET",
    "measurementType": "LengthUnit"
  },
  "second": {
    "value": 12,
    "unit": "INCH",
    "measurementType": "LengthUnit"
  }
}
```

---

## 🔐 Authentication

### 🔑 JWT

```
POST /auth/login?email=your_email
Authorization: Bearer <token>
```

### 🌐 Google OAuth

```
http://localhost:8080/oauth2/authorization/google
```

---

## ⚙️ Configuration

```properties
spring.datasource.url=jdbc:h2:mem:quantitydb
spring.jpa.hibernate.ddl-auto=update

jwt.secret=your_secret_key

spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
```

---

## 🚀 Run Locally

```
git clone <repo-url>
cd QuantityMeasurementApp
```

Run:

```
QuantityMeasurementApp.java
```

---

## 🗄️ Database

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:quantitydb`  
- Username: `sa`  
- Password: `empty`  

---

## 📁 Project Structure

```
controller/
service/
repository/
entity/
dto/
config/
utils/
```

---

## 🔮 Future Improvements

- 🛡️ Role-based authentication  
- 🛢️ MySQL/PostgreSQL integration  
- 🔄 Refresh tokens  
- 🎨 Frontend integration  

---

## 👩‍💻 Author

**Madhu Solanki**