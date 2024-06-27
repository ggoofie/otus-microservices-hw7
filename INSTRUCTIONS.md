### Инструкции (ПРАКТИЧЕСКАЯ ЧАСТЬ)

- создаем _namespace_ и устанавливаем контекст, укажите именно _"hw7-stream-processing"_
```console
kubectl create namespace hw7-stream-processing
kubectl config set-context --current --namespace=hw7-stream-processing
``` 
<br>

- устанавливаем _Kafka_, с отключенной аутентификацией, для этого используем [файл](./kafka_settings/values.yaml)
```console
helm install kafka oci://registry-1.docker.io/bitnamicharts/kafka -f ./kafka-settings/values.yaml
``` 
<br>

- устанавливаем приложение из _Helm_
```console
helm upgrade --install <release> ./helm-chart
```

<br>

- запускаем тесты _Postman_ с помощью _newman_
```console
newman run ./postman-test/otus_microservices_hw7.postman_collection.json --verbose
```
<br>

- [результат](postman-test/newman_output) запуска тестов с помощью _newman_ 
