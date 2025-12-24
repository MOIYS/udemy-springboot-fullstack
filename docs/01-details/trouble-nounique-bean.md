## 같은 타입의 Bean 중복에 따른 주입 실패(NoUniqueBeanDefinitionException)

### 1. 문제 발생

- 동일한 클래스 타입을 가진 Bean이 2개 이상 등록된 상태에서 타입으로 Bean을 조회하거나 주입받으려 할 때, 스프링이 어떤 빈을 선택해야 할지 몰라 예외가 발생

### 2. 발생 케이스

- **Case 1: 명시적 조회 시**

```java
// Address.class 타입의 빈이 2개 이상인 경우
System.out.println(
	context.getBean(
	HelloWorldConfiguration.Address.class
	));
```

- **Case 2: 의존성 주입 시**

```java
// Address 후보가 2개 이상인 경우
@Bean
public Person person3Parameters(String name, int age, Address address) {    
	return new Person(name, age, address);
}
```

### 3. 원인 분석

- 로그의 Caused by에서 `NoUniqueBeanDefinitionException` 발견
- 코드에서 Address 타입을 반환하는 @Bean 메서드가 2개가 있음
- person3Parameters 메서드 파라미터 Address에 값을 넣을 때, 후보가 2개라 선택의 모호성이 발생

### 4. 해결 시도 및 과정

- **시도 1: 단일 빈 사용**
    - **방법**: 후보를 1개로 만듦
    - **평가**: 현재로써는 명확한 해결 방법이나, 2개를 사용해야만 하는 경우 해결 방법이 아님
- **시도 2: 변수명을 빈 이름과 일치시키기**
    - **방법**: 파라미터 변수명을 `address`에서 `address2`로 변경
    - **평가**: 변수명이 강제되는 문제가 있음, 실수해도 발견하기 어렵고 치명적이라고 생각
- **시도 3: 우선순위 지정**
    - **방법**: 주로 사용될 것 같은 빈에 `@Primary` 어노테이션 추가
    - **선택 이유**: 같은 타입의 여러 빈을 사용하면서, 별도의 지정이 없을 경우 자동으로 주입되기 때문에 효율적이라고 판단

### **5.** 결과 및 검증

- person3Parameters 빈을 조회했을 때, address2의 값이 주입되어 있음을 확인