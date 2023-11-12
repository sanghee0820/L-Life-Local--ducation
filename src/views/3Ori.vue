<template>
  <div class="wrap">
    <div class="intro_bg">
      <div class="header">
        <div class="searchArea">
          <form>
            <input type="search" placeholder="SEARCH" />
            <span>검색</span>
          </form>
        </div>
        <ul class="nav">
          <li><a href="#">HOME</a></li>
          <li><a href="#">ABOUT</a></li>
          <li><a href="#">SERVICE</a></li>
          <li><a href="#">CONTACT</a></li>
        </ul>
      </div>
      <div class="visualArea3">
        <h3 class="apply_header">신청서 작성</h3>
        <div class="visualArea_inner">
          <!-- 서비스검색 -->
          <div class="apply_wrap">
            <div class="content_wrap">
              <div :class="{ 'page': true, 'active': currentPage === 0 }">
                <div class="question">
                  <div class="name">성명을 입력해주세요</div>
                  <input type="text" id="name" placeholder="Ex) 홍길동" />
                </div>
                <div class="question">
                  <div class="gender">성별을 선택해주세요</div>
                  <select id="gender">
                    <option value="male">남성</option>
                    <option value="female">여성</option>
                  </select>
                </div>
                <div class="question">
                  <div class="birthdate">생년월일을 입력해주세요</div>
                  <input type="text" id="name" placeholder="Ex) 2000-01-01" />
                </div>
                <button2 @click="nextPage">다음</button2>
              </div>

              <div :class="{ 'page': true, 'active': currentPage === 1 }">
                <div class="question">
                  <div class="phone"> 휴대폰 번호를 입력해주세요 </div>
                  <input type="text" id="phone" placeholder="Ex) 010-1234-5678">
                </div>
                <button2 @click="prevPage">이전</button2>
                <button2 @click="nextPage">다음</button2>
              </div>

              <div :class="{ 'page': true, 'active': currentPage === 2 }">
                <div class="question">
                  <div class="address">주소를 입력해주세요</div>
                  <input type="text" id="address" placeholder="Ex) 대구광역시 북구 대학로 80 (경북대학교)">
                </div>
                <button2 @click="prevPage">이전</button2>
                <button2 @click="nextPage">다음</button2>
              </div>

              <div :class="{ 'page': true, 'active': currentPage === 3 }">
                <div class="question">
                  <div class="duration">희망기간을 입력해주세요</div>
                  <input type="text" id="duration" placeholder="Ex) 1101~1201">
                </div>
                <button2 @click="prevPage">이전</button2>
                <button2 @click="nextPage">다음</button2>
              </div>

              <div :class="{ 'page': true, 'active': currentPage === 4 }">
                <div class="question" id="consent-text">
                  <div class="consent">개인정보 활용 여부에 체크해주세요</div>
                  <input type="checkbox" id="consent" v-model="consentChecked" /> 개인정보 처리에 동의합니다.
                </div>
                <button2 @click="prevPage">이전</button2>
                <button2 @click="submitSurvey">제출</button2>
              </div>

              <div :class="{ 'page': true, 'active': currentPage === 5 }">
                <div class ="final">
                  신청이 완료되었습니다.
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentPage: 0,
      consentChecked : false,
      submitted : false,
      name : '';
      
    };
  },
  methods: {
    nextPage() {
      if (this.currentPage < 5) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 0) {
        this.currentPage--;
      }
    },
    submitSurvey() {
      //체크 박스가 체크되지 않았을때 경고
      if(!this.consentChecked){
        alert("개인정보 활용 동의를 해주셔야합니다.");
        return;
      }
      // 여기에서 설문조사 데이터를 수집하고 처리할 수 있습니다.
      if (this.submitted) {
        alert('이미 제출되었습니다.');
      } else {
        // 여기에서 설문조사 데이터를 수집하고 처리할 수 있습니다.
        alert('설문조사가 제출되었습니다.');
        this.submitted = true; // 제출 상태를 true로 변경
        this.nextPage();
      }
    },
  },
};
</script>

<style scoped>
/* 여기에 필요한 스타일을 추가합니다. */
@import "../style/style3View.css";
@import "../style/survey.css";
</style>
