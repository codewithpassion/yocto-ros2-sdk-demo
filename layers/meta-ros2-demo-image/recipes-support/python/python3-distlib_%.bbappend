# Later version of distlib doesn't have a setup.py.
# This is a workaround for that.

do_configure:prepend() {
    cat > ${S}/setup.py <<-EOF
from setuptools import setup

setup(
    name="${PYPI_PACKAGE}",
    version="${PV}",
    license="${LICENSE}",
    packages=[
        'distlib',
    ],
)
EOF
}