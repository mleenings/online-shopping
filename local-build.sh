#!/bin/sh
set -euo pipefail
cd ${0%/*}/coffee-shop

mvn clean package

docker build -t coffee-shop .
