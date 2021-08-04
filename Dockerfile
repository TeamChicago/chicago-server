FROM gradle:jdk11

WORKDIR /server
COPY . /server

RUN ["gradle", "build"]
CMD ["sh", "entrypoint.sh"]
