# Breakout Game

This project implements the classic Breakout game in Java, with additional windows for displaying top scores and recent games. The player uses the keyboard to control the paddle, break bricks, and achieve high scores.

---

## 📌 Features

- Register player name consisting of exactly three letters before starting the game.
- Control paddle with left (←) and right (→) arrow keys.
- Break all bricks by bouncing the ball without letting it pass below the paddle.
- Lose a ball if it touches the barrier below the paddle; game continues until all balls are lost.
- Display the top ten scores with player names.
- Separate windows for gameplay, top scores, and recent results.
- Display results from the last three games.

---

## 📂 Project Structure

| File / Folder   | Description                                                       |
| --------------- | ----------------------------------------------------------------- |
| `.classpath`    | Eclipse project classpath configuration file.                     |
| `.dockerignore` | Files/directories to exclude from Docker build.                   |
| `.project`      | Eclipse project configuration file.                               |
| `*.java`        | Java source files containing game logic and GUI.                  |
| `*.class`       | Compiled Java bytecode.                                           |
| `Dockerfile`    | Docker configuration file for building and running the project.   |
| `clean.sh`      | Script to remove Docker containers/images related to the project. |
| `run.sh`        | Script to build and run the project inside Docker.                |
| `README.md`     | Project documentation.                                            |
| `LICENSE`       | License file (MIT License).                                       |


---

## 🛠 Requirements

- **Java version:** `20 or higher`  
- **Docker** (optional, for containerized execution).  
- Unix-like environment (Linux, macOS, or WSL for Windows).

---

## 🚀 Running the Project

This project is designed to be built, run, and cleaned using the provided scripts for convenience and consistency.

### 📦 Using Docker

Clean Docker build:

```bash clean.sh```

Execute the run script:

```bash run.sh```

To clean Docker build artifacts and remove containers:

```bash clean.sh```

### 💻 Running Locally (Without Docker)

1- Ensure Java version 20 or higher is installed:

```java --version```

2- Compile all .java files:

```javac *.java```

3- Run the project:

```java Program```

---

## 📜 License

This project is licensed under the MIT License. See the LICENSE file for details.

---


