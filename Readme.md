# Kotlin Currency Converter API

자바 개발자의 코틀린 백엔드 학습 프로젝트입니다. Spring Boot와 Kotlin을 활용하여 실시간 환율 정보를 제공하고 계산 이력을 관리하는 RESTful API 서버입니다.

## 주요 기능
* **실시간 환율 계산**: 외부 API를 연동하여 최신 환율 정보를 제공합니다.
* **로그 저장**: 모든 환율 계산 내역을 MySQL DB에 영구적으로 기록합니다.
* **자동 업데이트**: Spring Scheduler를 이용해 매시간 환율 정보를 자동으로 최신화합니다.
* **안전한 설정 관리**: 환경 변수와 `.gitignore`를 활용하여 민감한 정보를 보호합니다.

## 사용 기술 (Tech Stack)
* **Language**: Kotlin 2.x
* **Framework**: Spring Boot 3.x
* **Database**: MySQL (External)
* **Build Tool**: Gradle (Kotlin DSL)
* **ORM**: Spring Data JPA

## 프로젝트 구조
```text
src/main/kotlin/com/example/currency_api/
├── config/            # 설정값 매핑 클래스 (ConfigurationProperties)
├── controller/        # API 엔드포인트 정의
├── dto/               # 데이터 전송 객체 (API 응답/요청 포맷)
├── entity/            # DB 테이블 매핑 클래스 (JPA Entity)
├── exception/         # 전역 예외 처리 (Global Exception Handler)
├── repository/        # JPA 데이터 접근 인터페이스
└── service/           # 환율 계산 및 스케줄러 비즈니스 로직

## 실행 방법 (Getting Started)
1. 이 저장소를 클론합니다.
2. src/main/resources/application-sample.yml을 복사하여 application.yml을 생성합니다.
3. 로컬 DB 정보를 입력하거나 환경 변수(DB_USERNAME, DB_PASSWORD)를 설정합니다.
4. ./gradlew bootRun 명령어로 서버를 실행합니다.

## 주요 API
GET /api/convert?amount=10000&target=USD: 원화를 대상 통화로 변환

GET /api/logs: 전체 변환 이력 조회