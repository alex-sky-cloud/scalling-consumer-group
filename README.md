### Scalling Consumers in Consumers group

Показывается, как масштабировать **Consumers**, 
когда скорость обработки **Consumer** меньше, по сравнению с **Producers**.

Для создания кластера:

    docker-compose -f kafka-cluster.yml up

Для запуска сервисов:

    docker-compose -f producer-consumer.yml up --scale consumer=2

Для подключения к Kafka manager:

[http://localhost:9000/ ](http://localhost:9000/ )