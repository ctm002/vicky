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

case "$1" in
        status)
                if check_if_process_is_running; then
                        echo "App se encuentra en ejecución. Proceso (PID): $(print_process)"
                else
                        echo "App no se encuentra en ejecución"
                fi
                ;;
        stop)
                if ! check_if_process_is_running; then
                        PIDs=`ps -ef | grep 'jar' | grep -v grep | awk '{print $2}'`
                        if [ -n $PIDs ]; then
                                if [ -z $PIDs ]; then
                                        echo "App no se encuentra en ejecución"
                                        exit 0
                                else
                                  for p in $PIDs; do
                                          echo "deteniendo proceso $p"
                                          kill -9 $p
                                  done
                                  exit 0
                                fi
                        fi
                fi
               ;;
        start)
#                if check_if_process_is_running; then
#                        echo "App ya se encuentra en ejecución"
#                        exit 1
#                fi

                if [ -z "$2" ]; then
                        echo "Iniciando App"
                        $JAVA_PATH $SPRING_OPTS -jar $(find . -type f -name '*.jar' | sort -n | tail -1) > /dev/null &
                        echo "App $(find . -type f -name '*.jar' | sort -n | tail -1) iniciada"
                        exit 0
#                else
#                        echo "iniciando app.."
#                        if [ -f $2 ]; then
#                                $JAVA_PATH $SPRING_OPTS -jar $2 &
#                                echo "App $2 iniciada"
#                        else
#                                echo "Archivo $2 no encontrado"
#                                exit 1
#                        fi
                fi
                ;;
        restart)
                sh $0 stop
                if [ $? = 1 ]; then
                        exit 1
                fi
                sh $0 start
                ;;
        *)
                echo "Uso: $0 {start|stop|restart|status} [jar-file]"
                exit 1
esac
exit 0