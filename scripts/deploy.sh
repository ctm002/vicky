#!/bin/bash
echo "$REMOTE_USER@$REMOTE_HOST:$REMOTE_APP_DIR" && \
scp -o StrictHostKeyChecking=no -i ../vicky vicky-0.0.1-SNAPSHOT.jar ctapia@161.35.122.230:/home/ctapia/backend/
