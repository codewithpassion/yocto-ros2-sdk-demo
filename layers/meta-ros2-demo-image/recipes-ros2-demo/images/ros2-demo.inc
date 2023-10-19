inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

ROS_WORLD_SKIP_GROUPS:append = " \
    connext \
"
SKIP_RECIPE[rmw-connextdds-common] = "Not supported on ${TARGET_ARCH}"

# TOOLCHAIN_HOST_TASK:append = " nativesdk-packagegroup-cuda-sdk-host"

IMAGE_INSTALL:append = " \
    ros-base \
    python3-fcntl \
    \
    fastcdr \
    fastrtps-cmake-module \
    fastrtps \   
    \
    rosidl-parser \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    \
    ros2cli \
    python3-packaging \
    python3-logging \
    ros2run \
    ros2topic \
    ros2service \
    ros2param \
    ros2action \
    ros2lifecycle \
    ros2component \
    ros2node \
    ros2launch \
    ros2multicast \
    rclpy \
    rpyutils \
    ros2pkg \
    ament-index-python \
    launch \
    launch-ros \
    python3 \
    python3-lark-parser \
    python3-numpy \
    rosidl-runtime-py \
    osrf-pycommon \
    \
    demo-nodes-cpp \
    demo-nodes-cpp-rosnative \
    demo-nodes-py \
"


X_ROS_SYSROOT_BUILD_DEPENDENCIES:append = " \
    fastcdr \
    fastrtps-cmake-module \
    fastrtps \
    git \
    gmock-vendor \
    gtest-vendor \
    pkgconfig \
    python-cmake-module \
    python3-catkin-pkg \
    python3-empy \
    python3 \
    python3-nose \
    python3-pytest \
    rcutils \
    rmw-implementation-cmake \
    ament-lint-auto \
    ament-cmake-auto \
    ament-cmake-core \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-export-definitions \
    ament-cmake-export-dependencies \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \
    ament-cmake-uncrustify \
    ament-cmake-flake8 \
    ament-cmake-pep257 \
    ament-copyright \
    ament-cpplint \
    ament-flake8 \
    ament-index-python \
    ament-lint-cmake \
    ament-mypy \
    ament-package \
    ament-pclint \
    ament-pep257 \
    ament-pycodestyle \
    ament-pyflakes \
    ament-uncrustify \
    ament-xmllint \
    cmake \
    eigen3-cmake-module \
    rosidl-cmake \
    rosidl-default-generators \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-dds-idl \
    rosidl-generator-py \
    rosidl-parser \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-interface \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    foonathan-memory-vendor \
    libyaml-vendor \    
"

X_IMAGE_INSTALL:append = " \
    examples-rclcpp-minimal-action-client \
    examples-rclcpp-minimal-action-server \
    examples-rclcpp-minimal-client \
    examples-rclcpp-minimal-composition \
    examples-rclcpp-minimal-publisher \
    examples-rclcpp-minimal-service \
    examples-rclcpp-minimal-subscriber \
    examples-rclcpp-minimal-timer \
    examples-rclcpp-multithreaded-executor \
    examples-rclpy-executors \
    examples-rclpy-minimal-action-client \
    examples-rclpy-minimal-action-server \
    examples-rclpy-minimal-client \
    examples-rclpy-minimal-publisher \
    examples-rclpy-minimal-service \
    examples-rclpy-minimal-subscriber \
    demo-nodes-cpp \
    demo-nodes-cpp-rosnative \
    demo-nodes-py \
    cyclonedds \
    rmw-cyclonedds-cpp \
    tmux \
    python3-argcomplete \
    glibc-utils \
    localedef \
    rt-tests \
    stress \
    \
    opencv-staticdev \
    lttng-tools lttng-modules lttng-ust \
    libstdc++ \
    libstdc++-dev \
    libnvvpi1 \
    libnvvpi1-dev \
"


IMAGE_LINGUAS = "en-us"
GLIBC_GENERATE_LOCALES = "en_US.UTF-8"
