SUMMARY = "Module::Build::Tiny - A tiny replacement for Module::Build"
DESCRIPTION = "Many Perl distributions use a Build.PL file instead of a \
Makefile.PL file to drive distribution configuration, build, test and \
installation. Traditionally, Build.PL uses Module::Build as the underlying \
build system. This module provides a simple, lightweight, drop-in replacement. \
Whereas Module::Build has over 6,700 lines of code; this module has less than \
120, yet supports the features needed by most distributions."
SECTION = "libs"

HOMEPAGE = "https://metacpan.org/release/LEONT/Module-Build-Tiny-0.048"

LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b9e8b5e2bd19fcc97ac84b78a271a64"

DEPENDS = "libextutils-config-perl-native libextutils-helpers-perl-native libextutils-installpaths-perl-native"

SRC_URI = "${CPAN_MIRROR}/authors/id/L/LE/LEONT/Module-Build-Tiny-${PV}.tar.gz"
SRC_URI[sha256sum] = "79a73e506fb7badabdf79137a45c6c5027daaf6f9ac3dcfb9d4ffcce92eb36bd"

S = "${UNPACKDIR}/Module-Build-Tiny-${PV}"

inherit cpan_build ptest-perl

do_install:append() {
  sed -i \
    -e 's|${TMPDIR}||g' \
    `find ${D}/usr/lib/perl5 -type f -name .packlist`
}


RDEPENDS:${PN} += " \
    libextutils-config-perl \
    libextutils-helpers-perl \
    libextutils-installpaths-perl \
    perl-module-carp \
    perl-module-cpan \
    perl-module-data-dumper \
    perl-module-encode-encoding \
    perl-module-exporter \
    perl-module-extutils-cbuilder \
    perl-module-extutils-cbuilder-base \
    perl-module-extutils-install \
    perl-module-extutils-makemaker \
    perl-module-extutils-parsexs \
    perl-module-file-path \
    perl-module-file-spec \
    perl-module-file-temp \
    perl-module-getopt-long \
    perl-module-io-handle \
    perl-module-ipc-cmd \
    perl-module-json-pp \
    perl-module-load \
    perl-module-metadata \
    perl-module-parse-cpan-meta \
    perl-module-perl-ostype \
    perl-module-pod-man \
    perl-module-tap-harness-env \
    perl-module-test-more \
    perl-module-text-parsewords \
    perl-module-xsloader \
"

RDEPENDS:${PN}-ptest += " \
    packagegroup-core-buildessential \
    perl-dev \
    perl-module-blib \
    perl-module-ipc-open2 \
"

INSANE_SKIP:${PN}-ptest += "dev-deps"

BBCLASSEXTEND = "native"
