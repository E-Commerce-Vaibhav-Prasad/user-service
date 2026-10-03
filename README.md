
Complete User Service Structure
user-service
│
├── src/main/java
│   │
│   └── com.ecommerce.user
│       │
│       ├── controller
│       │   ├── UserController
│       │   └── AddressController
│       │
│       ├── service
│       │   ├── UserService
│       │   └── AddressService
│       │
│       ├── repository
│       │   ├── UserRepository
│       │   └── AddressRepository
│       │
│       ├── entity
│       │   ├── User
│       │   └── Address
│       │
│       ├── dto
│       │   ├── request
│       │   │   ├── CreateUserRequest
│       │   │   ├── UpdateUserRequest
│       │   │   └── CreateAddressRequest
│       │   │
│       │   └── response
│       │       ├── UserResponse
│       │       └── AddressResponse
│       │
│       ├── exception
│       │   ├── UserNotFoundException
│       │   ├── DuplicateEmailException
│       │   └── GlobalExceptionHandler
│       │
│       ├── mapper
│       │   └── UserMapper
│       │
│       └── config
│           └── ...
│
└── src/main/resources
└── application.yml

API Contract
USER SERVICE
│
├── USER
│   │
│   ├── POST   /api/v1/users
│   ├── GET    /api/v1/users/{userId}
│   ├── GET    /api/v1/users?email={email}
│   ├── PUT    /api/v1/users/{userId}
│   ├── PATCH  /api/v1/users/{userId}/status
│   └── DELETE /api/v1/users/{userId}
│
└── ADDRESS
│
├── POST   /api/v1/users/{userId}/addresses
├── GET    /api/v1/users/{userId}/addresses
├── GET    /api/v1/users/{userId}/addresses/{addressId}
├── PUT    /api/v1/users/{userId}/addresses/{addressId}
└── DELETE /api/v1/users/{userId}/addresses/{addressId}