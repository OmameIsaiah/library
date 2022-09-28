#!/usr/bin/env bash
echo "Compiling project"
mvn compile
echo "Building artifact"
mvn clean package

echo "Application built successfully"

