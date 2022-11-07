FROM openjdk:17.0.2-jdk-slim-buster

# добавляем в создаваемый образ файл с расширением *.jar
# который должен быть предварительно собран командой : mvn clean package
ADD target/*.jar producer.jar

# Добавляем переменную среды с именем BROKER,
# чтобы переопределить список брокеров
# ENTRYPOINT предоставляет команды и аргументы для выполняющегося контейнера
# Мы указываем, что при развертывании контейнера нужно запустить файл producer.jar
# При запуске приложения-Producer мы указываем, что нужно будет переопределить список
# kafka-brokers
ENTRYPOINT java -jar producer.jar --spring.kafka.bootstrap-servers=$BROKER
