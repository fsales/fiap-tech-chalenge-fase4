# Stage 1: Build the native image with GraalVM
FROM ghcr.io/graalvm/graalvm-ce:22.3.0 AS builder

RUN microdnf install -y unzip zip && \
    curl -s "https://get.sdkman.io" | bash && \
    bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install maven"

WORKDIR /app

COPY ./pom.xml ./pom.xml
COPY ./src ./src/

ENV MAVEN_OPTS='-Xmx8g'

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    mvn -Dmaven.test.skip=true clean package"


# Stage 2: Create a minimal image to run the application
FROM public.ecr.aws/lts/ubuntu:22.04

RUN addgroup --system spring && adduser --system spring --ingroup spring && \
   # apt-get update && apt-get install -y openjdk-17-jre-headless && \
    mkdir /app && chown spring:spring /app

USER spring:spring
WORKDIR /app

#COPY --from=builder /app/target/NexStream.jar /app/NexStream.jar
#
#CMD ["java", "-jar", "/app/NexStream.jar"]
COPY --from=builder /app/target/nex-stream /app/nex-stream

CMD ["/app/nex-stream"]
