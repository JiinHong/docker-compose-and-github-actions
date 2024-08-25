# 베이스 이미지로 OpenJDK를 사용
FROM openjdk:17-jdk-slim

# 애플리케이션 JAR 파일을 컨테이너에 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 컨테이너에서 애플리케이션 실행
ENTRYPOINT ["java","-jar","/app.jar"]

