#!/bin/bash

docker rm -f $(docker ps -a -q) 2>/dev/null
docker rmi -f breakout-java 2>/dev/null
