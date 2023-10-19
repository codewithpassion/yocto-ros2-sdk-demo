LICENSE = "CLOSED"

inherit toolchain-scripts

SRC_URI:append:class-nativesdk = " \
    file://environment.d-sdk.sh \
    file://cmake-sdk.cmake \
"
do_install:append:class-nativesdk() {

    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d
    install -m 644 ${WORKDIR}/environment.d-sdk.sh ${D}${SDKPATHNATIVE}/environment-setup.d/sdk.sh

    mkdir -p ${D}${SDKPATHNATIVE}/usr/share/cmake/OEToolchainConfig.cmake.d
    install -m 644 ${WORKDIR}/cmake-sdk.cmake ${D}${SDKPATHNATIVE}/usr/share/cmake/OEToolchainConfig.cmake.d/sdk.cmake
    install -m 644 ${WORKDIR}/cmake-sdk.cmake ${D}${SDKPATHNATIVE}/environment-setup.d/sdk.cmake
    # ln -s ${D}${SDKPATHTARGET}/lib/ld-*.so* ${D}/lib/
}

BBCLASSEXTEND =+ "nativesdk"

FILES:${PN}:append:class-nativesdk = " \
    ${SDKPATHNATIVE}/environment-setup.d/   \
    ${SDKPATHNATIVE}/usr/share/cmake/OEToolchainConfig.cmake.d/sdk.cmake \
"