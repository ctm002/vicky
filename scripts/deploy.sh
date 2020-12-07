#!/bin/bash
echo "$REMOTE_USER@$REMOTE_HOST:$REMOTE_APP_DIR" && \
scp -i ../vicky vicky-0.0.1-SNAPSHOT.jar -q -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null ctapia@161.35.122.230:/home/ctapia/backend/
