# ROS2 SDK Demo Image

This is an example of yocto ROS2 with a setup that can create an SDK for cross compilation.
It has been developed/tested with `MACHINE=raspberry4` but should be easy to adapt.

## Building an SDK

You will need build environment that is [setup to build yocto](https://docs.yoctoproject.org/4.0.13/brief-yoctoprojectqs/index.html#compatible-linux-distribution). 
See below for an example using docker.

    git clone <REPO URL>
    cd yocto-ros2-sdk-demo
    git submodule update --init
    . ./layers/oe-init-build-env build

Now you have a `build` directory, ready to go.
This is based on the `raspberry4` machine. 

## To build the sdk:

    bitbake ros2-demo-image -c do_populate_sdk

The SDK install files are then available in `<REPO ROOT DIR>/artifacts/tmp/deploy/sdk/`.
This path is important, as the Dockerfile to create a build image is dependend on it. 

## Build a Docker image

    ./scripts/create-sdk-docker-latest.sh

This will create a docker iamge named `yocto-ros-cross-sdk:latest`. 

## Run the build container:

    ./scripts/start-build-container.sh .

This will start the build container with the SDK setup. 
The parameter passed to the script `.` is the path that should be made available to `/workdir`. 
This path can be outside the current directory.

## Build the action_tutorials_cpp

Inside the build container:

    cd /workdir/playground
    colcon build


## Get your disk space back:

    rm -rf artifacts/tmp

Get all your disk space back:

    rm -rf artifacts/*
