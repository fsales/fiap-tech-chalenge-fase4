FROM maven:3-amazoncorretto-17 as builder


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src


RUN mvn -Dmaven.test.skip=true clean package && \
cd target && \
java -Djarmode=layertools -jar NexStream.jar extract && \
chmod +x mvnw # Dar permissões de execução ao arquivo mvnw
# https://aws.amazon.com/pt/blogs/containers/start-spring-boot-applications-faster-on-aws-fargate-using-soci/



FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
RUN yum install -y shadow-utils

WORKDIR application


RUN groupadd --system --gid 3000 spring \
    && useradd --system --uid 1000 --shell /bin/false --gid spring spring

#RUN groupadd --system spring && \
#    spring -g spring

USER spring:spring

COPY --from=builder target/dependencies/ ./
COPY --from=builder target/spring-boot-loader/ ./
COPY --from=builder target/snapshot-dependencies/ ./
COPY --from=builder target/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

#FROM amazoncorretto:17-alpine-jdk
#
#ENV EXPOSE_PORT=8080
#
## Adicione dependências do sistema necessárias para o GraalVM
##RUN apk --no-cache add libstdc++ libgcc
#
#ARG DEPENDENCY=/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#
#EXPOSE $EXPOSE_PORT
#
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -cp app:app/lib/* br.com.fsales.nexstream.NexStreamApplication ${0} ${@}"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","br.com.fsales.nexstream.NexStreamApplication"]

# mkdir target/extracted
# java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted
# docker build -t fosales/nex-stream:latest -t fosales/nex-stream:0.0.1-SNAPSHOT .
# docker  build -f ./nex-stream/Dockerfile -t fosales/nex-stream:latest ./nex-stream/