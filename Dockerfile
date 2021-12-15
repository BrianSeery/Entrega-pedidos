FROM openjdk:11
ADD target/docker-entrega-pedidos.jar docker-entrega-pedidos.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "docker-entrega-pedidos.jar"]
