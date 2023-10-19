#!/bin/sh

docker build . -t yocto-ros-cross-sdk:latest --build-arg="CURRENT_DIR=$(pwd)"