#!/bin/bash
nohup java -jar ../target/task1-1.0-SNAPSHOT.jar > ../scripts/temp/logs.txt 2>&1 &
echo $! > ../scripts/temp/pid.file