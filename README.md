# 📝내 위치 기반 공공 WIFI 정보를 제공하는 웹서비스 개발


## 💡 서울공공데이터(Api)를 활용해서 서블렛으로 구현해보기.

- 프로젝트 기간 : 2022.08.28 ~ 2022.09.09




## 💡 주요기능
1. 공공 와이파이 정보 가져오기 기능 구현 (서울 열린데이터 광장 API 이용) 
2. 내 위치 정보를 입력하면 가까운 위치에 있는 와이파이 정보 20개 보여주는 기능 구현
3. 내가 입력한 위치정보에 대해서 조회하는 시점에 DB에 히스토리를 저장 및 보여주는 기능 구현
4. DB CRUD 적용 (JDBC_MariaDB) 


## 💡 사용 기술

![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4a6176612d303037333936](https://user-images.githubusercontent.com/43702182/189212938-b87173c1-47ae-411c-916f-5431af631439.svg)
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4170616368253230546f6d6361742d463844433735](https://user-images.githubusercontent.com/43702182/189212944-9a709fc5-ea05-45be-ae06-3137e0188ed4.svg)
![마리아](https://user-images.githubusercontent.com/43702182/189213021-b3b90493-4446-4c30-bd5e-4196734279f7.svg)
![부트스트랩](https://user-images.githubusercontent.com/43702182/189214946-83b90ebf-8c03-4132-b40a-716e9808fb87.svg)
![제이쿼리](https://user-images.githubusercontent.com/43702182/189214957-054a8515-4eae-4656-9662-54f99f100f30.svg)
![HTML](https://user-images.githubusercontent.com/43702182/189214960-8813240f-49d6-4c76-888e-666d1b8286d2.svg)
![CSS](https://user-images.githubusercontent.com/43702182/189214959-a83e2a19-d446-4116-b982-d2b17f22d806.svg)
![자바스크립트](https://user-images.githubusercontent.com/43702182/189214954-fc2e7e07-a129-4f71-aeb8-4d4bd90a01f7.svg)
![그레이들](https://user-images.githubusercontent.com/43702182/190194765-941ef188-383c-441c-bad9-716d63f64f9a.svg)
![깃허브](https://user-images.githubusercontent.com/43702182/189214961-5ae8258f-5df1-45b5-9eee-b9eaee2f034f.svg)

-개발 언어: Java 8, HTML 5, CSS, JavaScript

-DataBase: MariaDB 10.6


- API
    - [서울공공데이터(API)](https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do)

* Front
  * Bootstrap 5.1.3 , jquery/3.6.0 
  



    
* Back , Gradle
  * Java 8 , Mariadb-java-client 3.0.7 , gson 2.9.0 , jstl 1.2  
  * lombok:1.18.24 , tomcat-servlet-api 9.0.65 , okhttp:4.9.3


- 개발 환경 
   - intelliJ IDEA, Gradle, Lombok , JDBC
   
   
   
   
   ## 💡 ERD

|Json|API 파싱부분|
|------|---|
|![Animation2](https://user-images.githubusercontent.com/43702182/189230408-787f3e2b-ca58-47e0-b53d-e687ec380953.gif)|![api가져오는부분](https://user-images.githubusercontent.com/43702182/189246046-1b814a93-d917-4c2b-9c5f-25fca701b344.PNG)|
|가까운 WIFI 20개뽑기 |저장된 히스토리 리스트목록, 목록삭제 |
|![20개근처가까운wifi리스트](https://user-images.githubusercontent.com/43702182/189246052-f74572d3-112c-48ad-8567-aaf272ee9b04.PNG)|![히스토리목록및삭제](https://user-images.githubusercontent.com/43702182/189246051-1ecaf92b-a15e-4d34-b3ea-639bf7125cde.PNG)|


   

## 🐱페이지별 상세 기능
- ERD 시각화

|데이터베이스 로직|쿼리 들어갔는지 체크|
|------|---|
|  ![image](https://user-images.githubusercontent.com/43702182/189228323-96e2c06e-3be5-473f-8e30-d5fc0f0e9b04.png)|![Animation](https://user-images.githubusercontent.com/43702182/189230009-a18cf920-74f0-4b33-9aa6-825a3eb0324d.gif)|
|처음 해보는 Junit 단위테스트|Data transfer object |
|![junit](https://user-images.githubusercontent.com/43702182/189232081-c097b1af-253f-4a1d-b9d5-990a52dcac93.gif)|![dto](https://user-images.githubusercontent.com/43702182/189232092-3d30da0e-32c1-49cd-a1c8-03cc55a01ab5.gif)|









## 💡 상세 기능 
1. 히스토리 리스트 시각화
2. 히스토리 삭제 기능 구현
3. 내가 입력한 위치정보에 대해서 조회하는 시점에 DB에 히스토리를 저장 및 보여주는 기능 구현

| 와이파이 정보 가져오기|내 위치 가져오기, 근처 Wifi 검색|
|------|---|
|![locationLoding](https://user-images.githubusercontent.com/43702182/189233709-2997fd0d-ceb8-4fc8-a38f-91e96dc6968e.gif)|![locationSle](https://user-images.githubusercontent.com/43702182/189233715-b458caca-760d-4e7d-b549-4ab1fcbb7312.gif)|
|위치 히스토리 목록| 히스토리 목록 삭제 테스트 |
|![locationList](https://user-images.githubusercontent.com/43702182/189233703-b3c707bc-f53b-4daf-a911-7da7281d5e44.gif)|![locationRemove](https://user-images.githubusercontent.com/43702182/189233712-05b2e8fa-e8a0-46c9-a2c1-8c0928b5040f.gif)|


## 💡 🐱프로젝트 리뷰 및 개선방향 


-   README.md 작성하는법을 처음배워배움.(재미있었음) , GIT을 꼭 배우자.
-   첫 프로젝트라 걱정도 많았지만 .. 어찌어찌 돌아가네요. 처음에  어디서부터 진행해야할지 많이 막막했습니다.
-  여기서 느낀점은 실전은 다르구나.. 이 작은 프로젝트 조차도 못하는 제 자신을 보며 열심히 해야겠구나.. 원인을 찾자라고 생각(결론 기초 및 실습)
-  그리고 객체지향적인 사고능력이 많이 부족하다는걸 느꼈습니다. ( 객체지향의 사실과 오해) 책 매일 읽도록 노력하기. 
-  자바, 웹 , 그리고 DB를 사용,라이브러리,셋팅 등  한층더 스킬 업  [Api 프로젝트를 마치며 (미완성 회고)](https://nabi1993.tistory.com/88)  
-  지금 짠 구조는  컨트롤러, 모델 , 뷰로 구성된건 맞지만 옛날 스타일 -> POJO (MVC) 형태로 추후 리팩토링 예정 
-  약 2주뒤에 스프링으로 넘어갈텐데 그전에 [기초 탄탄하게 쌓기](https://nabi1993.tistory.com/89)
-  항상 받아드리는 자세로, 해야할것이 산더미라 이렇게 지금은 물러나지만 추후 꼭 리팩토링을 해볼것이다.
-   옆에서 항상 도움을 주시는 동훈님께 감사하고 배워야할점이 많다는걸 매일같이  깨닳는중 



