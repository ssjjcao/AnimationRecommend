FROM java:8
VOLUME /resource
COPY target/animation_recommend_backend-0.0.1.jar animation.jar
RUN bash -c "touch /animation.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","animation.jar"]
