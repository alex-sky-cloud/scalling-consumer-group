FROM openjdk:17.0.2-jdk-slim-buster

# добавляем в создаваемый образ файл с расширением *.jar
# который должен быть предварительно собран командой : mvn clean package
ADD target/*.jar consumer.jar

# Добавляем переменную среды с именем BROKER,
# чтобы переопределить список брокеров
# При запуске приложения-Producer мы указываем, что нужно будет переопределить список
# kafka-brokers
# Через переменную $MESSAGE_PROCESSING_TIME, в миллисекундах, будет передаваться
# значение временного интервала для задержки обработки в методе consumer().
# Это нужно для имитации того, что Consumer долго обрабатывает задание
ENTRYPOINT java -jar consumer.jar \
                --spring.kafka.bootstrap-servers=$BROKER \
                --message.processing.time=$MESSAGE_PROCESSING_TIME
