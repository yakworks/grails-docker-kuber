#!/usr/bin/env bash

kubectl apply -f k8s/grello-kub.yml
kubectl apply -f k8s/grello-ingress.yml
kubectl apply -f k8s/grello-mysql.yml
