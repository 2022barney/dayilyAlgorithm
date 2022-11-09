cmake_minimum_required(VERSION 3.23)
project(dailyAlgorithm)

set(CMAKE_CXX_STANDARD 14)

include_directories(out/production/dailyAlgorithm/org/calm/October)
include_directories(src/org/calm/November)
include_directories(src/org/calm/October)

add_executable(dailyAlgorithm
        out/production/dailyAlgorithm/org/calm/October/Day1020.cpp
        out/production/dailyAlgorithm/org/calm/October/Day1020.h
        src/org/calm/November/Day1108.cpp
        src/org/calm/November/Day1109.cpp
        src/org/calm/November/Day1109.h
        src/org/calm/October/Day1020.cpp
        src/org/calm/October/Day1020.h)
