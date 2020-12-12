#!/bin/bash
SPRING_OPTS="-Xms1024m -Xmx1024m -XX:+HeapDumpOnOutOfMemoryError -DLOG_PATH=/home/vtapia/backend/logs"
JAVA_PATH="java"
PIDFile="application.pid"

check_if_process_is_running () {
        if [ -f $PIDFile ]; then
                if [ -s application.pid ]; then
                        return 0
                fi
        fi
        return 1
}

print_process () {
        echo "$(cat $PIDFile)"
}

stop_process () {
        echo "init stop"
        if ! check_if_process_is_running; then
                PIDs=`ps -ef | grep 'jar' | grep -v grep | awk '{print $2}'`
                if [ -n $PIDs ]; then
                        if [ -z $PIDs ]; then
                                echo "App no se encuentra en ejecución"
                        else
                                for p in $PIDs; do
                                        echo "Deteniendo proceso $p"
                                        kill -9 $p
                                done
                        fi
                fi
        fi
        echo "end stop"
}

start_process() {
        echo "Iniciando App"
        APP_JAR=`find . -type f -name '*.jar' | sort -n | tail -1`
        noup $JAVA_PATH $SPRING_OPTS -jar $APP_JAR > /dev/null &
        echo "App $APP_JAR iniciada"
}

case "$1" in
        status)
                if check_if_process_is_running; then
                        echo "App se encuentra en ejecución. Proceso (PID): $(print_process)"
                else
                        echo "App no se encuentra en ejecución"
                fi
                ;;
        stop)
                stop_process
               ;;
        start)
                start_process
                ;;
        restart)
                echo "init restart"
                stop_process
                start_process
                echo "end restart"
                ;;
        *)
                echo "Uso: $0 {start|stop|restart|status} [jar-file]"
                exit 1
esac
exit 0