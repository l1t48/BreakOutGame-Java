# Use Ubuntu base with JDK 20
FROM openjdk:20-slim

# Install required tools and X11 libraries
RUN apt-get update && \
    apt-get install -y x11-apps libxext6 libxrender1 libxtst6 libxi6 && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Compile Java program
RUN javac *.java

# Run program
CMD ["java", "Program"]
