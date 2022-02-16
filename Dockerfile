FROM openjdk:11-jre-slim-buster
WORKDIR /home
ARG DEPENDENCY=target/dependency
COPY  ${DEPENDENCY}/BOOT-INF/lib app/lib
COPY ${DEPENDENCY}/META-INF app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes app
USER 1
ENTRYPOINT [ "java" ,"-cp","app:app/lib/*","com.raghul.expenseservice.ExpenseserviceApplicationKt"]
