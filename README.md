# Quarkus minimal service example with GraalVM native binary build packaged into a Docker image

This is a minimal Java API service implemented by following the [Quarkus getting
started guide](https://quarkus.io/guides/getting-started).

This repo aims to give a working example of building a minimal but working Java
11 API service that will be built into a native Linux binary using GraalVM. This
binary is then packaged into a Docker image for ease of deployment and execution
across platforms and cloud providers.

This repository, when it was originally bootstrapped from Maven, came with its
own [README file](README-original.md).

## Tooling

* Maven 3.6.3 ([Download link](https://maven.apache.org/download.cgi)]
* Quarkus 1.2.0 (Nothing to install, everything is resolved through Maven)
* GraalVM Version 19.3.1 CE ([Download link](https://www.graalvm.org/downloads/))
* Docker ([Download link](https://docs.docker.com/install/))

Note that there's also a _Dockerized_ build, which mean that you can build this
repo without having to install anything if you're just looking to give Quarkus
a trial run.

## Building

Assuming you have everything installed and configured according to Quarkus and
GraalVM instructions, you can build this project like this:

```
./mvnw package -Pnative -Dquarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.native -t quarkus-minimal-service .
```

If you do not wish to install these things, you can use a multistage Docker
build as explained by [Quarkus](https://quarkus.io/guides/building-native-image#creating-a-container-with-a-multi-stage-docker-build).

In short, you simply need to delete the .dockerignore file and then use the
multi-stage build file of this repo:

```
rm .dockerignore
docker build -f src/main/docker/Dockerfile.multistage -t quarkus-minimal-service .
```

The build, regardless of the method, takes about 4 minutes on my Machine
(MacBook Pro 2018, 2.3 GHz Quad-Core Intel Core i5).

You can then run `docker run -i --rm -p 8080:8080 quarkus-minimal-service` to
start a Docker container running the native executable and point your browser to
http://localhost:8080/greeting/yourname to test it out.

## License

All the content in this repository that is my authorship (code that I wrote) is
made freely available for anyone to use without any restriction. See the
[unlicense](LICENSE) of this repository. However, all the trademarks, copyrights
, logos and whatnot that I might have included, used or mentioned  in this
repository are the property of their respective owners.
