FROM ${docker.registry.host}/${docker.base.image}
LABEL From="${docker.registry.host}/${docker.base.image}"
LABEL MAINTAINER="ATLAS DevOps"

# Uncomment the ENV and add Environment Variables here as needed.  Use  the format KEY=VALUE \ new line repeat new KEY=VALUE as often as needed
ENV JAVA_APP_DIR=/opt/atlas JAVA_APP_NAME=event-aggregation JAVA_INIT_MEM_RATIO=25 JAVA_MAJOR_VERSION=8 JAVA_OPTIONS="-XX:+UseG1GC"

# Uncomment the EXPOSE and add Ports that SHOULD BE EXPOSED here as needed.  Do NOT list ports that are internal to the running container
EXPOSE 8080 8443

CMD ./run-java.sh

COPY spring-boot-app/run-java-sh/fp-files/run-java.sh /opt/atlas/
COPY spring-boot-app/event-aggregation-app-${project.version}.jar /opt/atlas/
# Uncomment the RUN and add any new image configuration requirements here. Use the \ newline format for more than 1.
# If using a package manager (yum/apt) to install new packages, ALWAYS USE A SPECIFIC VERSION NUMBER DEFINED IN YOUR PARENT POM
RUN useradd -s /sbin/nologin -d /opt/atlas -c "Atlas User" atlas; \
    chown -R atlas:atlas /opt/atlas; \
    chmod -R 500 /opt/atlas

USER atlas

