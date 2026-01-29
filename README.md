**Employee Management API – Problem Statement**

This project implements a RESTful API for managing employee data in MongoDB. The API provides the following features:

**Create Employee** – Store employee details such as name, email, phone, address, date of birth, position, etc.
**Fetch Employee Data Dynamically** – Return all employee records with only the fields requested by the client. For example, if 5 fields are requested, each record will include exactly those 5 fields.

**Key Requirements:**
- Built with Spring Boot and MongoDB
- Service layer with interface + implementation
- Dynamic field selection when fetching data
- Standardized API response format (ApiResponse)
- Proper error handling and logging

**Sample Use Case:**
**Input:** 
["name", "email", "city", "position", "phone"]

**Output:** 
All employee records with only the requested fields



<img width="1919" height="1079" alt="Screenshot 2026-01-30 005733" src="https://github.com/user-attachments/assets/2f52bc7a-525b-4e95-bd2e-53a81d2cf1b0" />

<img width="1919" height="1079" alt="Screenshot 2026-01-30 005733" src="https://github.com/user-attachments/assets/94c53f33-f2b5-454e-babb-da2e314f527d" />
<img width="1920" height="1080" alt="Screenshot 2026-01-30 005806" src="https://github.com/user-attachments/assets/14afc910-a0d4-4480-985e-2de98851dbba" />
<img width="1920" height="1080" alt="Screenshot 2026-01-30 010006" src="https://github.com/user-attachments/assets/ee834574-6de9-4c8f-8f45-e0d581a78f01" />
<img width="1920" height="1080" alt="Screenshot 2026-01-30 005828" src="https://github.com/user-attachments/assets/546f2a45-909c-4cbf-8fe6-22da8c74c701" />
