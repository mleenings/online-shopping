#!/bin/bash

java -jar ./system/hystrix-dashboard/target/hystrix-dashboard-0.0.1-SNAPSHOT.jar &
sleep 3
java -jar ./system/service-registry/target/service-registry-0.0.1-SNAPSHOT.jar &
sleep 3
java -jar ./system/cloud-gatway/target/cloud-gatway-0.0.1-SNAPSHOT.jar &
sleep 3
java -jar ./system/cloud-config-server/target/cloud-config-server-0.0.1-SNAPSHOT.jar