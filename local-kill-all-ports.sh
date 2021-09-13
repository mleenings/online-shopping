#!/bin/sh
# call for example: kill-port.sh 8080
kill -9 $(lsof -t -i:8761) # eureka
kill -9 $(lsof -t -i:9196) # config-server
kill -9 $(lsof -t -i:8989) # cloud-gateway
kill -9 $(lsof -t -i:9195) # hysterix-dashboard
kill -9 $(lsof -t -i:8761) # service-regestry
