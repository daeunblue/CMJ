# 추못죽

## 🗓️프로젝트 개요

- **진행 기간 : 2022.08.29 ~ 2022.10.7 (7주)**
- **목표**
  - 빅데이터 분산 프로젝트로서, 하둡 에코시스템을 통한 웹소설 추천 서비스 입니다.
- **배포 링크**
  - https://j7a207.p.ssafy.io/

## 👯팀원 정보 및 업무 분담 내역

김동욱(팀장, BE) - UI 설계, UI 구현

전민재(FE) - UI 설계, UI 구현

최태순(BE) - ERD 설계, 데이터 전처리, 서버 개발

박예인(BE) - ERD 설계, 데이터 전처리, 서버 개발

김다은(Data,DevOps) - 웹 크롤링, 데이터 전처리, 하둡 에코시스템 구축 , CI/CD

이성민(Data,DevOps) - 웹 크롤링, 데이터 전처리, 하둡 에코시스템 구축

## :paperclip: 발표 자료

https://drive.google.com/file/d/1YYx4bnAN-2mFJwcSGTj6Wa0jTdxgIC25/view?usp=sharing

## :video_camera: 광고 영상

https://drive.google.com/file/d/1wD2AeuQnoK3OyLOt5QG4jfPolMGPY_jr/view?usp=sharing



### 메인 페이지

![메인화면](README.assets/메인화면.PNG)



### 로그인 전 기본 추천

![로그인 전 기본 추천](README.assets/로그인_전_기본추천.PNG)



### 로그인 후 사용자 정보 기반 추천 (성별, 나이)

![로그인 후 사용자 정보 기반 추천](README.assets/로그인후_추천.PNG)



### 웹소설 취향 유형검사 시작화면

![유형검사](README.assets/유형검사.PNG)



### 유형 검사 진행화면

![유형검사 진행화면](README.assets/유형검사_시작.PNG)



### 유형 검사 결과화면

![유형검사 결과화면](README.assets/유형검사결과.PNG)



### 이상형 월드컵 시작화면

![이상형 월드컵 시작화면](README.assets/이상형월드컵.PNG)

### 이상형 월드컵 진행화면

![이상형 월드컵 진행화면](README.assets/이상형월드컵_시작.PNG)

### 이상형 월드컵 결과화면

![이상형 월드컵 결과화면](README.assets/이상형월드컵_결과.PNG)

### 태그검색 페이지

![태그검색페이지](README.assets/태그검색페이지.PNG)

## 기술 스택

![image-20220823113947380](README.assets/image-20220823113947380.png)

1. Sprint/Quasar (Vue) Server: AWS EC2 Ubuntu 20.04 LTS
2. Openvidu Server: Oracle Cloud Ubuntu 20.04 LTS (Openvidu Server의 경우 ARM CPU 사용불가)
3. Compiler Server: Oracle Cloud Ubuntu 20.04 LTS
4. Mysql: 20.04.2
5. Spring Boot: 2.4.5
6. Quasar: 1.0.5
7. Openvidu: 2.22.0
8. Nginx: 1.18.0
9. Node.js: 10.19.0
10. java: 1.8.0
11. gcc: 9.4.0
12. g++: 9.4.0
13. Python: 3.8.10



## ERD

![image-20220823111429633](README.assets/image-20220823111429633.png)



## 기능 정의서/API 명세서/테스트 시나리오

https://docs.google.com/spreadsheets/d/1hJ3F-pyaeCHFWGd1NqcsIKce6SUxkpg3S4VU9M1ses4/edit?usp=sharing



## 기획 자료(figma)

https://www.figma.com/file/xYiCDWV2GYnX3pQCz61hbz/%EC%BD%94%EC%9C%97%EB%AF%B8-%EA%B8%B0%ED%9A%8D-by-A304?node-id=0%3A1

