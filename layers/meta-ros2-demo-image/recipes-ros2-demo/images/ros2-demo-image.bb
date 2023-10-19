DESCRIPTION = "Mission Robotics Nadir OS image"
LICENSE = "MIT"

inherit core-image
inherit ros2_image
require ros2-demo.inc
inherit python3-dir


DEPENDS += " util-linux-native "

# THis is probably a hack, but I don't know where to get /opt/sdk from
SDKNATIVE="/opt/sdk/sysroots/${SDK_SYS}"

SDK_SUPPORT = " \
    nativesdk-ros2-demo-image-sdk-support \
"

# There are probably packages in these lists that aren't needed, feel free to use only what you need.
TOOLCHAIN_HOST_TASK:append = " \
    ${SDK_SUPPORT} \
    \
    nativesdk-make \
    nativesdk-cmake \
    nativesdk-ament-cppcheck \
    nativesdk-ament-cppcheck \
    nativesdk-ament-copyright \
    nativesdk-ament-uncrustify \
    nativesdk-ament-cpplint \
    nativesdk-ament-cmake \
    nativesdk-ament-flake8 \
    nativesdk-ament-pep257 \
    \
    nativesdk-python3-dateutil \
    nativesdk-python3-docutils \
    nativesdk-python3-numpy \
    nativesdk-python3-lark-parser \
    nativesdk-python3-jinja2 \
    nativesdk-python3-typeguard \
    nativesdk-python3-distlib \
    nativesdk-python3-colcon-common-extensions \
    \
    nativesdk-rosidl-generator-type-description \
    nativesdk-rosidl-parser \
    nativesdk-rosidl-adapter \
    nativesdk-rosidl-generator-cpp \
    nativesdk-rosidl-typesupport-c \
    nativesdk-rosidl-typesupport-cpp \
    nativesdk-rosidl-typesupport-fastrtps-c \
    nativesdk-rosidl-generator-py \
    nativesdk-rosidl-pycommon \
    nativesdk-rpyutils \
    nativesdk-libusb1 \
    nativesdk-libusb-compat \
    nativesdk-protobuf \
    nativesdk-protobuf-compiler \
    nativesdk-python3-lxml \
    nativesdk-rclpy \
    nativesdk-fastcdr \
    \
    nativesdk-ros2cli \
    nativesdk-ros2cli-common-extensions \
    nativesdk-ros-workspace \
    nativesdk-ros-workspace-implicitworkspace \
    \
"

TOOLCHAIN_TARGET_TASK:append = " \
    ament-cmake \
    foonathan-memory-staticdev \
    fastcdr \
    geographiclib-staticdev \
    geographiclib-tools \
    libusb1 \
    libusb-compat \
    nlohmann-json \
    python3-numpy \
    python3-future \
    diagnostic-msgs \
    sensor-msgs \
    nav-msgs \
    action-tutorials-interfaces \
    rclcpp-action \
    ${TOOLCHAIN_AMENT_PACKAGES} \
"

TOOLCHAIN_AMENT_PACKAGES = "\
    ament-package \
    ament-lint \
    ament-lint-auto \
    ament-cmake \
    ament-cmake-auto \
    ament-cmake-catch2 \
    ament-cmake-copyright \
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
    ament-cmake-flake8 \
    ament-cmake-gen-version-h \
    ament-cmake-gmock \
    ament-cmake-google-benchmark \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake-lint-cmake \
    ament-cmake-mypy \
    ament-cmake-pclint \
    ament-cmake-pep257 \
    ament-cmake-pycodestyle \
    ament-cmake-pyflakes \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-uncrustify \
    ament-cmake-version \
    ament-cmake-xmllint \
"