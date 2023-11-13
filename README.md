# L-ducation  [2023 대구를 빛내는 SW 해커톤]
포스트 코로나 시대의 혼란을 해결하는 SW 개발 : 포스트코로나 시대의 지역 문화센터 평생학습 프로그램 활성화 서비스

### 📸 [시연영상 바로가기](https://www.youtube.com/watch?v=TyKLRLAwvko)


## 😀 팀명

- **L- ducation**

## 💾 제출 타입

  - **Type C**
  - **포스트코로나 시대의 지역 문화센터 평생학습 프로그램 활성화 방안**

## 📖 프로젝트 설명
1. 위치를 기반으로 자신 주변의 평생학습 강좌를 목록화 하여 소개합니다.
2. 기존의 복잡한 신청서 작성을 단계식으로 구성, 보다 간편하게 신청서를 작성할 수 있도록 도와줍니다.
3. 작성된 신청서는 담당자의 이메일로 pdf형식으로 전송됩니다.

## 🖥️ 프로젝트에 사용된 기술

- ### [ BackEnd ](https://github.com/sanghee0820/L-ducation/tree/BE_MAIN)
  - [WebClient를 활용한 외부서버 통신](https://github.com/sanghee0820/L-ducation/pull/2/commits/83dfeb6edf96e38a76420d054d241bb984dfc507#diff-f2ebe6d5260da58ea3e26f0050e56c423e132073d9d33ba85e952a2855484aa3)
    - WebClient를 통해 외부 서버와 통신합니다.
    - WebClient는 비동기적으로 동작하며, 리액터(Reactor) 라이브러리를 기반으로 합니다
    - Mono 또는 Flux를 사용하여 비동기 응답을 처리하였습니다.
    - 결과에 대한 json을 Parsing하여, 원하는 값만 처리하도록 하였습니다.
    - 모든 KEY값은 [Configuratation](https://github.com/sanghee0820/L-ducation/pull/2/commits/95153cbcc2e8d2466d5b2bff191c5f59e46e5b66)을 통해 처리하였습니다.
  - [JavaMail API를 활용한 메일 보내기](https://github.com/sanghee0820/L-ducation/pull/13/commits/5f498f32d38081c2a0da8a5200f1c33690fbb6b3)
    - JavaMail API를 통해 메일을 전송합니다
    - Session 객체와 MimeMessage를 활용하여 메시지 내용과 메일 서버 정보를 설정한 후, SMTP(Simple Mail Transfer Protocol)을 통해 메일 서버와 통신합니다.
    - Session 객체는 메일 서버와의 연결 정보를 저장합니다.
    - MimeMessage 객체는 이메일의 내용을 정의합니다.
    - 설정된 정보를 기반으로 Transport 클래스를 사용하여 이메일을 메일 서버로 전송하며, 전송 결과는 SMTP 프로토콜을 통해 확인할 수 있습니다.
- ### [ FrontEnd ](https://github.com/sanghee0820/L-ducation/tree/FE_MAIN)
