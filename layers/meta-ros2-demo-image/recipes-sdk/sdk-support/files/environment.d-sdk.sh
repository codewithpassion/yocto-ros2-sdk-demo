
export PYTHONPATH="${OECORE_NATIVE_SYSROOT}/usr/lib/python3.10/site-packages:${SDKTARGETSYSROOT}/usr/lib/python3.10/site-packages"
export AMENT_PREFIX_PATH=${OECORE_NATIVE_SYSROOT}/usr:${SDKTARGETSYSROOT}/usr
export ROS_PYTHON_VERSION=3
export ROS_DISTRO=iron

# if file sdk.cmake exists, then we are in the SDK
if [ -f ${OECORE_NATIVE_SYSROOT}/environment-setup.d/sdk.cmake ]; then
    echo "Moving cmake config."
    mkdir -p ${OECORE_NATIVE_SYSROOT}/usr/share/cmake/OEToolchainConfig.cmake.d
    mv ${OECORE_NATIVE_SYSROOT}/environment-setup.d/sdk.cmake ${OECORE_NATIVE_SYSROOT}/usr/share/cmake/OEToolchainConfig.cmake.d/
fi