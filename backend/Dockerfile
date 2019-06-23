
FROM maven:latest AS MAVEN_TOOL_CHAIN

COPY pom.xml .
RUN mvn dependency:go-offline

COPY ./ /build
WORKDIR /build
RUN mvn package

FROM jboss/wildfly:12.0.0.Final
USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
COPY --from=MAVEN_TOOL_CHAIN /build/target/journal-0.0.1.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

