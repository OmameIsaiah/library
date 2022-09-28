#!/usr/bin/env bash
echo "Compiling project"
mvn compile
echo "Building artifact"
mvn clean install

echo "Application built successfully"

