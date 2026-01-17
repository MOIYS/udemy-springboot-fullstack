# [Spring Boot] record 사용 시, `@ConfigurationProperties` 바인딩 문제


### 1. 문제 상황

- 설정값을 관리하기 위해서 Java `record`를 사용하고 `@Component`로 빈 등록 시도함
- 앱 실행 시, `Parameter 0 of constructor in MOIYS.project.learn_spring_boot.CurrencyServiceConfiguration required a bean of type 'java.lang.String' that could not be found.` 에러 발생하며 구동 실패

<br>

### 2. 원인 추론 및 시도

- 처음에는 `yaml` 파일 인식이 안 되었거나, 오타 문제인 줄 알았지만 정상이었음
이후 에러 메시지에 대해 알아보니, 스프링이 설정값이 아닌 **String 타입의 빈**을 찾고 있는 것을 발견

<br>

### 3. 원인

- `@Component`와 `record`의 충돌
    - `@Component`가 붙으면, 스프링은 일반 컴포넌트로 인식하여 DI를 시도함. 하지만 `record`의 경우 생성자가 하나뿐이라 자동으로 주입을 시도했고, 컨테이너에 **String 빈**이 없어서 실패함 → **설정값 바인딩이 아닌 DI가 일어난 것이 원인**

<br>

### 4. 해결

- `record` 클래스에서 `@Component` 제거
- 애플리케이션 클래스에 `@ConfigurationPropertiesScan` 추가

<br>

### 5. 배운점

- `record`를 사용할 때는 `@Component` 대신 **스캔 방식**을 사용하는 것이 스프링 부트의 의도대로 동작하게 하는 방식임을 알게 됨