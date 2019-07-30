# grails-docker-kuber
Example for grails3 app in docker and kubernetes

## Docker

1. create grails app with 3.3.10 `grails create-app grello`
2. remove extra unneeded stuff, simplify. comment out `apply plugin:"war"` in build.gradle so we build a runnable jar
3. added `'org.grails.plugins:external-config:1.2.2'` and created `extData` dir
4. see added `conf/application.groovy` with pointers for external config and tomcat logging. 
5. cd into grello, run `./gradle build` to generate the runnable jar and sanity check with `java -jar build/libs/grello-0.1.jar`
6. see Dockerfile, run `docker build -t yakworks/grello .` to build from Dockerfile
7. sanity check with `docker run --rm -p 8080:8080 -v "$PWD/extData":/extData yakworks/grello`. it should be using the grello-config.groovy and logback-config.groovy and outputting the logging to its logs dir
8. TODO: use ENVIRONMENT var instead to setup logback.groovy pointer.

## Kubernetes (TODO)

1. [setup minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/) on mac use `brew cask install minikube`
2. on mac docker desktop has kubctl but you need to later version so 
  - `brew install kubectl` and `brew link --overwrite kubernetes-cli` if brew link fails 
3. `minikube start`
4. `kubectl create -f grello-kub.yml`
5. `minikube service grello`

## Refs from duckduckgo searches

### kubectl

`kubectl config use-context minikube` switching contexts. basically the pointer to the k8s cluster we want to be using with kubectl
`kubectl get nodes`


### Logging
http://docs.grails.org/3.3.10/guide/single.html#externalLoggingConfiguration
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html

For externalizing logback https://stackoverflow.com/questions/38853935/grails-3-external-logback-groovy-file

#### Tomcat
default for grails 3 which uses springboot 1.5.21 is embed-tomcat 8.5.40
https://docs.spring.io/spring-boot/docs/1.5.21.RELEASE/reference/html/howto-embedded-servlet-containers.html#howto-configure-accesslogs

https://stackoverflow.com/questions/36780680/how-do-you-tell-spring-boot-to-send-the-embedded-tomcats-access-logs-to-stdout
 https://github.com/spring-projects/spring-boot/issues/13365

```
server.tomcat.accesslog.enabled=true
server.tomcat.accesslog.directory=/rootLocation/logs
```

### Loader and PropertiesLauncher
//see https://stackoverflow.com/questions/40994851/spring-boot-executable-jar-layout-changes-break-classpath
//https://stackoverflow.com/questions/36168310/how-to-specify-the-launcher-in-spring-boot-gradle
// springBoot{
//     layout = "ZIP" //triggers jar launcher to use PropertiesLauncher
// }
then can use "-Dloader.path=/rootLocation/conf/, /rootLocation/conf/"

### Kuber
good intro https://medium.com/google-cloud/kubernetes-101-pods-nodes-containers-and-clusters-c1509e409e16

https://www.youtube.com/watch?v=RelPurLZnII
https://github.com/trisberg/s1p2017-boot-k8s/blob/master/demo-hello.adoc

https://itnext.io/migrating-a-spring-boot-service-to-kubernetes-in-5-steps-7c1702da81b6
https://github.com/sbrosinski/spring-boot-on-k8s

https://www.cebuscripts.com/2019/04/20/how-to-automate-deployments-to-digitalocean-kubernetes-with-circleci/

### persistent volumes
https://supergiant.io/blog/persistent-storage-with-persistent-volumes-in-kubernetes/