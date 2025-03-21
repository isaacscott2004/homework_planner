
# Homework Planner Application
## This project is a full-stack Homework Planner application, built using Spring Boot for the backend and React.js (or Angular) for the frontend. The app allows users to manage homework tasks, including adding, updating, deleting, and viewing tasks. Users are authenticated using JWT tokens for security.

## 1. Backend (Java - Spring Boot)
   ### a. Project Structure
   ```
   /homework_plannner
        /src
            /main
                /java
                    /controller
                       TaskController.java
                       UserController.java
                    /service
                       TaskService.java
                       UserService.java
                   /repository
                       TaskRepository.java
                       UserRepository.java
                   /model
                       Task.java
                       User.java
                   /security
                       JWTFilter.java
                       SecurityConfig.java
               /resources
                    application.properties
            /test
               /java
                   /controller
                       /TaskControllerTests.java
                       /UserControllerTests.java
                   /model
                       /TaskTests.java
                       /UserTests.java
                   /repository
                       /TaskRepoTests.java
                       /UserRepoTests.java
                   /service
                       /TaskServiceTests.java
                       /UserServiceTests
   ```

### b. Key Components

- **Controllers**:
    - **TaskController.java**: Defines RESTful endpoints for task operations (add, update, delete, list tasks).
    - **UserController.java**: Handles user authentication and profile management.

- **Services**:
    - **TaskService.java**: Implements business logic for handling tasks (e.g., deadlines, reminders).
    - **UserService.java**: Manages user login, registration, and password encryption.

- **Repositories**:
    - **TaskRepository.java**: Interfaces with the database to manage task entities.
    - **UserRepository.java**: Interfaces with the database to manage user entities.

- **Security**:
    - **JWT Authentication**:
        - **JWTFilter.java**: Handles token verification for requests.
        - **SecurityConfig.java**: Configures Spring Security and JWT filters.

### c. Database Structure (PostgreSQL/MySQL)

- **Tables**:
    - **users**: For storing user information (e.g., username, email, password).
    - **tasks**: For storing homework tasks (e.g., task name, due date, priority, description).
    - **relationships**: One user can have multiple tasks.

## 2. Frontend (React.js or Angular)
   ### a. Project Structure
  ```
  /src
    /components
        TaskList.js
        TaskForm.js
        TaskItem.js
        Login.js
        Register.js
    /services
        api.js (for Axios API calls to backend)
    /styles
        styles.css (or use TailwindCSS)
  ```

### b. Key Components

- **TaskList.js**: Displays a list of homework tasks, with filtering/sorting by deadline or priority.
- **TaskForm.js**: Allows users to add or edit homework tasks. Has input fields for task name, description, due date, etc.
- **TaskItem.js**: Represents an individual task within the list.
- **Login.js**: Handles user login with authentication.
- **Register.js**: Allows users to sign up for an account.

### c. API Communication

- **Axios API (api.js)**: This file sets up functions to interact with your backend REST APIs for:
    - `login()`: POST request for user login.
    - `register()`: POST request for new user registration.
    - `getTasks()`: GET request to retrieve all tasks for the logged-in user.
    - `addTask()`, `updateTask()`, `deleteTask()`: Manage tasks through backend endpoints.

### d. Routing (React Router / Angular Router)

- **Routes**:
    - `/login`: User login page.
    - `/register`: User registration page.
    - `/tasks`: Task management interface (view/add/edit/delete tasks).
## 3. Database (PostgreSQL/MySQL)

### a. Schema Design

- **User Table**:
```sql
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);
	•	Task Table:
sql
CopyEdit
CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  due_date DATE NOT NULL,
  priority INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
```
## 4. Cloud Hosting Setup (AWS / Heroku / GCP)
   ### a. Cloud Architecture
- **Backend**: (Spring Boot) Hosting:
- **Deploy**: to AWS EC2 or Heroku.
- **Install**: Nginx or use Elastic Load Balancer to handle incoming HTTP requests.
- **Database**: (PostgreSQL/MySQL)
  - Use AWS RDS or Google Cloud SQL to host your database** 
  - Ensure your database is properly configured with VPC (Virtual Private Cloud) or firewall settings for secure access.
  - Frontend (React/Angular) Hosting:
  - Deploy static assets to S3 or Google Cloud Storage for scalability and CDN (Content Delivery Network) access.
  - Alternatively, deploy to Netlify or Vercel for easy frontend hosting.
### b. Continuous Integration/Deployment (CI/CD)
- **Use GitHub Actions, TravisCI, or CircleCI for CI/CD pipelines**
  - Automate build, test, and deployment to the cloud when new code is pushed to the main branch.

## 5. User Flow
- 1	Login/Register: User logs in or registers for the app.
- 2	View Tasks: User sees a list of all homework tasks, with options to filter by deadline or priority.
- 3	Add/Edit Task: User can add new tasks or update existing ones.
- 4	Delete Task: User can delete tasks that are no longer relevant.
- 5	Logout: The user logs out, and JWT token is invalidated.
