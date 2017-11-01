#!/bin/bash
set -e

docker-compose kill && docker-compose rm -f
docker-compose-full -f docker-compose.yml up -d --remove-orphans
npm config set registry http://localhost:4873
