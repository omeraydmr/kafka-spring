**README.md**

## Spring Boot Kafka Producer and Consumer in Kotlin with Gradle and Docker Compose

This repository demonstrates how to create a simple Kafka producer and consumer using Spring Boot, Gradle-Kotlin, and Docker Compose.

**Prerequisites**

* Docker
* Gradle

**Instructions**

1. Clone this repository:

```
git clone https://github.com/omeraydmr/kafka-spring.git
```

2. Build the application:

```
./gradlew build
```

3. Start the Kafka cluster and the producer and consumer containers:

```
docker-compose up -d
```

**Testing**

To test the producer and consumer, you can use the following curl commands:


# Produce a message to the `test-topic` topic
curl http://localhost:8080/kafka-produce

# Consume a message from the `test-topic` topic
You can see them in your console.


You should see the message "[%d] -- Hello World", [number]" printed to the console.

**Docker Compose YAML**

The following Docker Compose YAML file defines the Kafka cluster and the producer and consumer containers:

```yaml
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
```

To contribute to this repository, please create a pull request.
