#!/bin/bash

i=0
while [ $i -lt 1000 ]
do
    curl -H "Content-Type: application/json" -d '{"id":100}' -X POST http://localhost:8080/farm/
    ((i++))
    let waitingTime=$RANDOM/10000
    echo "call $i, waiting for $waitingTime seconds"
    sleep $waitingTime
done