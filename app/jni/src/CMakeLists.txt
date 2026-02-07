file(GLOB_RECURSE LINCITY_SOURCES
    "gui/*.cpp"
    "lincity/*.cpp"
    "lincity-ng/*.cpp"
    "util/*.cpp"
)

add_library(main SHARED ${LINCITY_SOURCES})

target_include_directories(main PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${CMAKE_CURRENT_SOURCE_DIR}/gui
    ${CMAKE_CURRENT_SOURCE_DIR}/lincity
    ${CMAKE_CURRENT_SOURCE_DIR}/lincity-ng
    ${CMAKE_CURRENT_SOURCE_DIR}/util
    ${CMAKE_CURRENT_SOURCE_DIR}/../SDL/include
    ${CMAKE_CURRENT_SOURCE_DIR}/../SDL_image
    ${CMAKE_CURRENT_SOURCE_DIR}/../SDL_mixer
    ${CMAKE_CURRENT_SOURCE_DIR}/../SDL_ttf
    ${CMAKE_CURRENT_SOURCE_DIR}/../libxml2/include
    ${CMAKE_CURRENT_SOURCE_DIR}/../fmt/include
)

target_link_libraries(main
    SDL2
    SDL2_image
    SDL2_mixer
    SDL2_ttf
    xml2
    fmt
    log
    android
)

target_compile_definitions(main PRIVATE ANDROID)
target_compile_definitions(main PRIVATE UNIX)
target_compile_definitions(main PRIVATE "PACKAGE_VERSION=\"2.14.2\"")
target_compile_definitions(main PRIVATE "DATA_PATH=\"data/\"")
