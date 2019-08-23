#!/usr/bin/env bash

# deletes everythign with a app=grello
kubectl delete deployment,svc,ingress,configmap --selector=app=grello

# kubectl delete configmap grello-config || true
# kubectl delete deployment grello || true
# kubectl delete service grello || true
# kubectl delete ingress grello-ingress || true
