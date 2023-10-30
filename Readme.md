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


# How did we get here

## ROS2 release

This is based on a proof of concept setup of ROS2 Iron. Iron is not currently officially supported but somehting
I've been working on recenty.

To get this working with another release, you probably need to add a fair amount of  `.bbappends`. 
What is needed mainly are:

    BBCLASSEXTEND =+ "native nativesdk"
    
Or at least the `nativesdk` part of it. 

## Special recipe for the SDK setup

[layers/meta-ros2-demo-image/recipes-sdk/sdk-support/ros2-demo-image-sdk-support_1.0.0.bb](ros2-demo-image-sdk-support_1.0.0.bb) has a couple of the modifications we need for the SDK. 
There is a script to setup environment variables when you start the docker container. There is also a `cmake` configuration file setting certain values. 

## Customization in the Docker container

There are some fixes and customizations needed that are done during Docker contaiiner creation.
These are done in the [Dockerfile](Dockerfile).



