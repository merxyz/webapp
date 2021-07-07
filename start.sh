#!/bin/bash
gradle --version
gradle clean build --parallel
gradle test