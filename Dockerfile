FROM gradle:jdk11

WORKDIR /server
COPY . /server

RUN ["gradle", "-x", "test", "build"]
CMD ["sh", "entrypoint.sh"]
