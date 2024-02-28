# Company MT API Documentation

Welcome to the Company MT API documentation. This API provides access to a service for translating text from many different languages and into many different styles and domains.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/jobo215/MTApiProject.git
    ```

2. Install dependencies:

    ```bash
    cd company.mt.api
    mvn clean install
    ```

## Usage

Run API with command:

```bash
mvn spring-boot:run
```

## Endpoints

### Validated translation endpoint

The API responds with translated content, converted from the source language to the target language as indicated in the request body, within the specified domain.

- **URL:** `/validated-translate`
- **Method:** `POST`
- **Headers**
  - `Content-Type: application/json`
- **Body:**
    - `source_language` (required): The language of the content being translated.
    - `target_language` (required): The language into which the content should be translated.
    - `domain` (required): The content domain that needs translation.
    - `content` (required): The content of the text to be translated.
- **Example Request:**
  ```http
    POST /api/v1/validated-translate HTTP/1.1
    Host: http://localhost:8080
    Content-Type: application/json
  ```
  ```json
    {
      "source_language": "en-US",
      "target_language": "de-DE",
      "domain": "business",
      "content": "This is test"
    }
  ```
- **Example Response:**
    ```json
    {
      "translated_content": "This is some mocked translation!"
    }
    ```


## Error handling
The API returns appropriate HTTP status codes and error messages in case of errors. Common error codes include:
- 400 Bad Request
- 404 Not Found