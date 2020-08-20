# Product-service

## Requirements
- [OpenJDK8](https://openjdk.java.net/install/) 
- [Maven](https://maven.apache.org/install.html)
- [Docker-desktop](https://www.docker.com/products/docker-desktop)

install with **[HomeBrew](https://brew.sh/)** (MacOs or Linux)

``` shell
$ brew tap AdoptOpenJDK/openjdk
$ brew cask install adoptopenjdk8
$ brew install maven
```

install with **[Chocolatey](https://chocolatey.org/install)** (Windows)

``` powershell
> choco install openjdk8
> choco install maven
```

> **Docker-desktop** install manually.

## How to build

- Go to project folder
``` shell
cd product-service
```
- Maven clean and package(.jar)
``` shell
mvn clean package -DskipTests
```

- Docker Build Image
``` shell
export IMAGE_TAG=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
docker build $DOCKER_USER/product-service:$IMAGE_TAG .
```
> **On Window** get IMAGE_TAG=project.version in pom.xml 

## Publish Docker Image to Docker Hub

``` shell
docker login -u "$DOCKER_USER" -p "$DOCKER_PASS"
docker tag product-service:$IMAGE_TAG product-service:latest
docker push product-service:latest
docker push product-service:$IMAGE_TAG
```

## How to run

Set environment link : https://github.com/appman-agm/local-devops/tree/feature/workshop