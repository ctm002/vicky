#!/bin/sh
set -x
scp vicky-0.0.1-SNAPSHOT.jar $REMOTE_USER@$REMOTE_HOST:$REMOTE_APP_DIR && \
