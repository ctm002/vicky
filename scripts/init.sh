#!/bin/bash
SPRING_OPTS=""
JAVA_PATH="java"
PIDFile="application.pid"

check_if_process_is_running () {
        if [ -f $PIDFile ]; then
                if ps -p $(print_process) > /dev/null; then
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
                        echo "App no se encuentra en ejecución"
                        exit 0
                fi

                echo "Deteniendo app ..."
                kill $(print_process)
                sleep 5

                if ! check_if_process_is_running; then
                        echo "App detenida"
                else
                        echo "No fue posible detener app. Proceso (PID): $(print_process)"
                        exit 1
                fi
                ;;
        start)
                if check_if_process_is_running; then
                        echo "App ya se encuentra en ejecución"
                        exit 1
                fi

                if [ -z "$2" ]; then
                        $JAVA_PATH $SPRING_OPTS -jar $(find . -type f -name '*.jar' | sort -n | tail -1) &
                        echo "App $(find . -type f -name '*.jar' | sort -n | tail -1) iniciada"
                else
                        if [ -f $2 ]; then
                                $JAVA_PATH $SPRING_OPTS -jar $2 &
                                echo "App $2 iniciada"
                        else
                                echo "Archivo $2 no encontrado"
                                exit 1
                        fi
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