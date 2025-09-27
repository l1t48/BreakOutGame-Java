#!/bin/bash

# Build Docker image
docker build -t breakout-java .

# Run container with X11 forwarding
docker run -it \
    --env="DISPLAY=$DISPLAY" \
    --env="QT_X11_NO_MITSHM=1" \
    --volume="/tmp/.X11-unix:/tmp/.X11-unix:rw" \
    breakout-java
