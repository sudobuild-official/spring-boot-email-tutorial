# Email Tutorial Project

This project demonstrates how to send emails using the **Spring Boot** framework. It provides a RESTful API to send both simple text emails and emails with attachments.

## Features

- **Simple Email**: Send plain text emails.
- **Email with Attachments**: Send emails containing file attachments using `MimeMessageHelper`.
- **Mailtrap Integration**: Pre-configured to work with Mailtrap for safe email testing.

## Technologies Used

- **Java 21**: The project is configured to use Java 21 for compilation.
- **Spring Boot 4.0.0**: The core framework for the application.
- **Spring Mail**: Provides the `JavaMailSender` and related utilities.
- **Spring Web**: Used for building the REST controller.
- **Lombok**: Reduces boilerplate code for data models.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven (or use the provided Maven Wrapper)

## Usage

The application exposes a single POST endpoint to send emails.

- **Endpoint**: `/sendEmail`
- **Method**: `POST`
- **Content Type**: `multipart/form-data`

### Request Parameters

The request body should include the following fields, mapping to the `EmailModel`:

| Field       | Type   | Description                    |
|------------|--------|--------------------------------|
| from       | String | Sender's email address         |
| to         | String | Recipient's email address      |
| subject    | String | Email subject line             |
| body       | String | Content of the email           |
| attachment | File   | (Optional) File to be attached |

## Project Structure

- **EmailTutorialApplication.java**: The main entry point of the Spring Boot application.
- **EmailController.java**: Handles incoming HTTP requests and routes them to the service layer.
- **EmailService.java**: Interface defining the email sending capabilities.
- **EmailServiceImpl.java**: Implementation of the email service using `JavaMailSender`.
- **EmailModel.java**: Data Transfer Object (DTO) for email data.
