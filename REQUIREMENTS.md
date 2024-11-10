# Spring Boot Data JPA

## Requirements
- Replace the existing BookRepository with the one that will use JpaRepository interface
- Add Liquibase support
- Change spring.jpa.hibernate.ddl-auto property value to validate
- Implement soft delete concept for the Book entity
- Add missing endpoints and methods for BookService
- As a result of this HW you should have the following endpoints in the BookController:

## Book Endpoints:

- GET: /api/books (Retrieve book catalog) (should be done in the previous PR)
- GET: /api/books/{id} (Retrieve book details) (should be done in the previous PR)
- POST: /api/books (Create a new book) (should be done in the previous PR)
- PUT: /api/books/{id} (Update a specific book)

Example of request body:

```json
{
  "title": "Updated Title",
  "author": "Updated Author",
  "isbn": "978-1234567890",
  "price": 19.99,
  "description": "Updated description",
  "coverImage": "https://example.com/updated-cover-image.jpg"
}
```
DELETE /api/books/{id} (Delete a specific book)


