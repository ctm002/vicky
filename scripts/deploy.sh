#!/bin/bash
echo ${REMOTE_USER}@${REMOTE_HOST}:${REMOTE_APP_DIR} && \
cd $TRAVIS_BUILD_DIR && \
pwd && \
ls -la && \
chmod ao+rx ./scripts/init.sh && \
APP_JAR=$(find $TRAVIS_BUILD_DIR/target -type f -name '*.jar' | sort -n | tail -1) && \
scp -r -o StrictHostKeyChecking=no -i ~/.ssh/vicky $APP_JAR ctapia@161.35.122.230:/home/ctapia/backend/ && \
scp -r -o StrictHostKeyChecking=no -i ~/.ssh/vicky ./scripts/init.sh ctapia@161.35.122.230:/home/ctapia/backend/ && \
echo "fin scp"
