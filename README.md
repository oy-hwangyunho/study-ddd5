## Java11
## USE_TESTCONTAINERS
docker 설치
```
brew install --cask docker
```

testcontainers option 설정
```
# mac 
# 경로: ~/.testcontainers.properties
docker.client.strategy=org.testcontainers.dockerclient.UnixSocketClientProviderStrategy
~```