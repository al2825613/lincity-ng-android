cmake_minimum_required(VERSION 3.10)

project(lincity-ng)

# Set SDL2 directories
set(SDL2_DIR ${CMAKE_CURRENT_SOURCE_DIR}/SDL)
set(SDL2_IMAGE_DIR ${CMAKE_CURRENT_SOURCE_DIR}/SDL_image)
set(SDL2_MIXER_DIR ${CMAKE_CURRENT_SOURCE_DIR}/SDL_mixer)
set(SDL2_TTF_DIR ${CMAKE_CURRENT_SOURCE_DIR}/SDL_ttf)
set(LIBXML2_DIR ${CMAKE_CURRENT_SOURCE_DIR}/libxml2)
set(FMT_DIR ${CMAKE_CURRENT_SOURCE_DIR}/fmt)

# Include SDL2
add_subdirectory(${SDL2_DIR})

# Include SDL2 companion libraries
set(SDL2_IMAGE_VENDORED ON CACHE BOOL "" FORCE)
add_subdirectory(${SDL2_IMAGE_DIR})

set(SDL2_MIXER_VENDORED ON CACHE BOOL "" FORCE)
add_subdirectory(${SDL2_MIXER_DIR})

set(SDL2_TTF_VENDORED ON CACHE BOOL "" FORCE)
add_subdirectory(${SDL2_TTF_DIR})

# Include fmt
add_subdirectory(${FMT_DIR})

# Include libxml2 (simplified build)
add_library(xml2 STATIC
    ${LIBXML2_DIR}/buf.c
    ${LIBXML2_DIR}/c14n.c
    ${LIBXML2_DIR}/catalog.c
    ${LIBXML2_DIR}/chvalid.c
    ${LIBXML2_DIR}/debugXML.c
    ${LIBXML2_DIR}/dict.c
    ${LIBXML2_DIR}/encoding.c
    ${LIBXML2_DIR}/entities.c
    ${LIBXML2_DIR}/error.c
    ${LIBXML2_DIR}/globals.c
    ${LIBXML2_DIR}/hash.c
    ${LIBXML2_DIR}/HTMLparser.c
    ${LIBXML2_DIR}/HTMLtree.c
    ${LIBXML2_DIR}/list.c
    ${LIBXML2_DIR}/nanoftp.c
    ${LIBXML2_DIR}/nanohttp.c
    ${LIBXML2_DIR}/parser.c
    ${LIBXML2_DIR}/parserInternals.c
    ${LIBXML2_DIR}/pattern.c
    ${LIBXML2_DIR}/relaxng.c
    ${LIBXML2_DIR}/SAX.c
    ${LIBXML2_DIR}/SAX2.c
    ${LIBXML2_DIR}/schematron.c
    ${LIBXML2_DIR}/threads.c
    ${LIBXML2_DIR}/tree.c
    ${LIBXML2_DIR}/uri.c
    ${LIBXML2_DIR}/valid.c
    ${LIBXML2_DIR}/xinclude.c
    ${LIBXML2_DIR}/xlink.c
    ${LIBXML2_DIR}/xmlIO.c
    ${LIBXML2_DIR}/xmlmemory.c
    ${LIBXML2_DIR}/xmlmodule.c
    ${LIBXML2_DIR}/xmlreader.c
    ${LIBXML2_DIR}/xmlregexp.c
    ${LIBXML2_DIR}/xmlsave.c
    ${LIBXML2_DIR}/xmlschemas.c
    ${LIBXML2_DIR}/xmlschemastypes.c
    ${LIBXML2_DIR}/xmlstring.c
    ${LIBXML2_DIR}/xmlunicode.c
    ${LIBXML2_DIR}/xmlwriter.c
    ${LIBXML2_DIR}/xpath.c
    ${LIBXML2_DIR}/xpointer.c
)
target_include_directories(xml2 PUBLIC ${LIBXML2_DIR}/include)
target_compile_definitions(xml2 PRIVATE LIBXML_STATIC)

# Game source
add_subdirectory(src)
