#!/bin/bash

echo "Zatrzymywanie kontenera home-office-service..."
docker stop home-office-service

echo "Usuwanie kontenera home-office-service..."
docker rm home-office-service

echo "Uruchamianie polecenia clean dla home-office..."
../gradlew home-office:clean

echo "Uruchamianie polecenia bootJar dla home-office..."
../gradlew home-office:bootJar

echo "Uruchamianie docker-compose..."
docker-compose up -d

echo "Skrypt zakończony."