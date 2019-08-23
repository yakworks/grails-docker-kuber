# grails-docker-kuber
Example for grails3 app in docker and kubernetes

## Local docker testing

1. `cd grello` can try `./gradlew build` and `java -jar build/libs/grello-0.1.jar` too see that grails app works

2. Or just build jar and the docker with `./build.sh` (comment out the push if you just want to test locally but will need to pus when deployeing to k8s)

3. try running the docker with `./dock-run-app.sh`

4. cd to mysql and `./build.sh` again comment out the push if you just want to try locally.

5. go to root dir and try `./dock-run-app-mysql.sh` to run the 2 dockers for a mysql and external config example

## Kubernetes

1. make sure you are setup to talk to your minikube or rancher/kubernetes cluster with the `kubectl config use-context .....`, run `./k8s/clean.sh` if the k8s cluster already has grello on it

2. for the same simple example without mysql try `./kub-grello-simple.sh`. see script for what its doing. 
   When run against rancher it go to https://grello.9ci.io

3. NOTE: MINICUBE: instructions not tested with minikube. will need to do something like `kubectl expose deployment grello --type=NodePort` and then `minikube service grello`. might need to comment out part that creates ingress too.

4. do a cleanup with `./k8s/clean.sh` to remove what just got pushed to kubernetes

5. to do a full mysql apply run `./kub-grello-mysql.sh`

6. wait for a bit or check rancher to see when ready and visit. https://grello.9ci.io

7. to connect to the mysql try `kubectl get pods` and copy the mysql pod and do `kubectl port-forward grello-mysql-66cc57fb85-bzmvq 7306:3306` . now you should be able to connect from something like SequelPro to localhost:7306 and it will be forwarded to the mysql database we jsut deployed. In theory same thing would work for Sql Server as well
