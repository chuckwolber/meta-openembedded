DESCRIPTION = "The goal of this project is to provide a tiny library that would \
facilitate the common operations with sizes in bytes."
HOMEPAGE = "https://github.com/rhinstaller/libbytesize"
LICENSE = "LGPL-2.0-or-later"
SECTION = "devel/lib"

LIC_FILES_CHKSUM = "file://LICENSE;md5=c07cb499d259452f324bb90c3067d85c"


SRCREV = "9da72b2732508b0ba0ceed27f5e50bc276ef31f2"
SRC_URI = "git://github.com/storaged-project/libbytesize;branch=main;protocol=https"

inherit gettext autotools pkgconfig python3native

DEPENDS += " \
    libpcre2 \
    gmp \
    mpfr \
    gettext-native \
"

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/bytesize"

PACKAGECONFIG ??= "python3"
PACKAGECONFIG[python3] = "--with-python3, --without-python3,,python3-core"

EXTRA_OECONF = "--without-gtk-doc"
EXTRA_OEMAKE = "py3libdir=${PYTHON_SITEPACKAGES_DIR}"
