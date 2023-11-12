<template>
  <div class="wrap">
    <div class="intro_bg">
      <div class="header">
        <div class="searchArea">
          <form>
            <input type="search" placeholder="SEARCH">
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
      <div class="visualArea">
        <h3 class="subject">
          내 주변 평생학습 정보확인하기
        </h3>
        <div class="visualArea_inner">
          <div class="background_wrap">
            <div class="pick_wrap">
              <div class="pick_b">
                <button type="button" title="열기" class="pick_tit active" @click="toggleList"><em>{{ selectedArea }}</em></button> <!-- 토클 나오게-->
                <div class="pick_b_wrap" v-show="categoryListVisible">
                  <input type="hidden" name="local" id="local" value="">
                  <ul id="categoryList">
                    <li><button id="JUNGU" @click="areaClick('중구')">중구</button></li>
                    <li><button id="DONGU" @click="areaClick('동구')">동구</button></li>
                    <li><button id="SEOGU" @click="areaClick('서구')">서구</button></li>
                    <li><button id="NAMGU" @click="areaClick('남구')">남구</button></li>
                    <li><button id="BUKGU" @click="areaClick('북구')">북구</button></li>
                    <li><button id="SUSGU" @click="areaClick('수성구')">수성구</button></li>
                    <li><button id="DALGU" @click="areaClick('달서구')">달서구</button></li>
                    <li><button id="DAGGU" @click="areaClick('달성군')">달성군</button></li>
                  </ul>
                </div>
              </div>
              <button type="button" class="gps-button" @click="getLocation">
                <span class="material-symbols-outlined">
                  my_location
                </span>
              </button>
              <router-link to="/pagetwo" class="router-link-pagetwo">선택</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'PageOne',
  data() {
    return {
      selectedArea: '📍지역 선택',
      categoryListVisible: false,
      locationInfo : {
        page : 0,
        courses : [],
        maxPage : 0,
      }
    };
  },

  

  methods: {
    toggleList() {
      this.categoryListVisible = !this.categoryListVisible; // 토글 상태 변경
    },
    areaClick(selectedArea) {
      this.selectedArea = selectedArea; // 선택한 값 넣어줌
      this.$store.commit('setGu',this.selectedArea);
      console.log('선택된 값:', this.selectedArea);
      console.log('보내진값:', this.$store.state.gu);
      this.categoryListVisible = false; // 토글을 닫음
    },

    getLocation() {
      const serverAddress = 'http://52.79.243.233:8080/position';
      if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition((position) => {
          const latitude = position.coords.latitude;
          const longitude = position.coords.longitude;
          axios.get(serverAddress, {
            params : {
              longitude : longitude,
              latitude : latitude
            }
          })
          .then(response => {
            console.log('서버 응답:', response.data);
            this.$store.commit('setGu',response.data);
            console.log('보내진값:', this.$store.state.gu);
            console.log('서버 응답2:', response.data);
          })


          alert(`현재 위치 - 경도: ${latitude}, 위도: ${longitude}`);
        });
      } else {
        alert("Geolocation을 지원하지 않는 브라우저입니다.");
      }
    },

    
  },
};
</script>

<style>
@import "../style/style1View.css";
</style>