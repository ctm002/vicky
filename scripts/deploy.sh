#!/bin/bash
echo "$REMOTE_USER@$REMOTE_HOST:$REMOTE_APP_DIR" && \
cd $TRAVIS_BUILD_DIR && \
pwd && \
ls -la && \
JAR=$(find $TRAVIS_BUILD_DIR/ -type f -name '*.jar' | sort -n | tail -1) && \
scp -o StrictHostKeyChecking=no -i ~/.ssh/vicky /home/travis/build/ctm002/vicky/target/vicky-0.0.1-SNAPSHOT.jar ctapia@161.35.122.230:/home/ctapia/backend/
