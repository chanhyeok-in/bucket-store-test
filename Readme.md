먼저 실행을 위해 git에서 소스를 Clone합니다.
https://github.com/chanhyeok-in/bucket-store-test.git

해당 프로젝트는 Spring Boot 3 으로 구성되어있으며,
Spring Boot 3 프로젝트를 실행하려면 아래의 작업이 선행되어야 합니다.

Java 17 이상이 설치되어 있어야 합니다.
터미널에 다음 명령어 입력하여 설치를 확인합니다.
    java -version
설치되지 않았다면 AdoptOpenJDK 또는 Oracle JDK를 설치하세요.

코드를 편집하고 실행하기 위해 IntelliJ IDEA, Eclipse, VS Code 같은 IDE를 설치하세요.
IntelliJ IDEA 다운로드가 가장 추천됩니다.
프로젝트 실행 준비
Clone 받은 프로젝트 열기

IDE를 실행하고 클론한 프로젝트 폴더를 엽니다.


이제, 같이 첨부한 backup.sql 파일에 대해 설명드리겠습니다.
이 백업 파일은 특정 데이터베이스(bucket_db)를 대상으로 작성되었습니다.
데이터베이스가 없는 경우, 아래 명령으로 새 데이터베이스를 생성합니다.

mysql -u <username> -p

CREATE DATABASE bucket_db;
EXIT;

backup.sql 파일을 bucket_db 데이터베이스에 복원합니다.
mysql -u root -p bucket_db < backup.sql
비밀번호를 입력하면 backup.sql의 내용이 데이터베이스에 복원됩니다.


IDE에서 @SpringBootApplication이 붙어 있는 메인 클래스 [bucketStoreTestApplication.java](src%2Fmain%2Fjava%2Fcom%2Fin%2FbucketStore%2FbucketStoreTestApplication.java)를 실행.

기본적으로 Spring Boot는 **http://localhost:8080**에서 실행됩니다.
브라우저를 열고 http://localhost:8080으로 접속해 실행 상태를 확인합니다.

이미 8080 포트를 사용하는 애플리케이션이 있을 경우 application.yml 파일에서 포트를 변경
server.port=9090

Gradle/Maven 의존성 충돌 시, 터미널에서 의존성을 다시 다운로드
./gradlew clean build