#!/bin/bash

# system
sh ./local-run-system.sh &
sleep 3
# services
javac ./services/order-service/target/order-service-0.0.1-SNAPSHOT.jar &
javac ./services/payment-service/target/payment-service-0.0.1-SNAPSHOT.jar &
javac ./services/product-service/target/product-service-0.0.1-SNAPSHOT.jar &
sleep 1
# frontend
(cd ui && ng serve)