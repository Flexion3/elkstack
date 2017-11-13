#!/bin/bash
set -e

docker-compose kill && docker-compose rm -f
docker-compose -f docker-compose.yml up -d --remove-orphans
