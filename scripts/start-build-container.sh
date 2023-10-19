#!/bin/bash

CONTAINER="yocto-ros-cross-sdk:latest"

# check if we have a parameter, if so, assign it to CURRENT_DIR
if [ -n "$1" ]; then
    CURRENT_DIR=$1
    # check if the path is relative, if so, make it absolute
    if [[ $CURRENT_DIR != /* ]]; then
        CURRENT_DIR="$(pwd)/$CURRENT_DIR"
    fi
else 
    CURRENT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/"
fi

echo "Starting with '/workdir' set to: ${CURRENT_DIR}"
echo ""

docker run \
    -it --rm \
    -v $(pwd):/workdir \
    ${CONTAINER}

