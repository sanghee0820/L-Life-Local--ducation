a<template>
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
            <div class="main_text0">
                <h1 class="subject2">
                    원하는 강좌를 선택하세요!
                </h1>
                <!-- 1번째 줄 -->
                <template v-for="(infoGroup, groupIndex) in groupedInfo" :key="groupIndex">
                    <div class="info-line">
                        <div v-for="(info, index) in infoGroup" :key="index" class="info">
                            <div class="class_name">강좌 이름 <br> {{ info.name}}</div>
                            <div class="location">장소 : {{ info.location }}</div>
                            <div class="class_time">강좌 시간 : {{ formatClassTime(info.classTime) }}</div>
                            <router-link to="/pagethree" class="router-link-three">신청 :</router-link>
                        </div>
                    </div>
                </template>
                <!-- 페이지네이션 컨트롤 -->
                <div class="pagination">
                    <button @click="prevPage" :disabled="currentPage === 0">이전</button>
                    <span>페이지 {{ currentPage + 1 }} / {{ totalPages }}</span>
                    <button @click="nextPage" :disabled="currentPage === totalPages - 1">다음</button>
                </div>
                <!-- 1번째 줄 끝-->
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
        gu : '',
        infoPerPage: 9, // 한 페이지에 표시될 info 개수
        max_Page : 0,
        currentPage: 0, // 현재 페이지
        current_position:1,
        nextPage_val : 0,
        sendCurrentPage : 0,
        j : 0,
        allInfo: [
            { name: 'hello', location: '', classTime: '' },     
            { name: 'hello2', location: '', classTime: '' },
            { name: '', location: '', classTime: '' },
            { name: '', location: '', classTime: '' },
            { name: '', location: '', classTime: '' },
            { name: '', location: '', classTime: '' },
            { name: '', location: '', classTime: '' },
            { name: '', location: '', classTime: ''},
            { name: '', location: '', classTime: '' },
            ], // 모든 info 데이터
        }; 
    },

    created() {
    // 선택한 지역 값을 서버로 전송
    const serverAddress = 'http://52.79.243.233:8080/info';
    axios.get(serverAddress, {
    params :{
        "gu" : this.$store.state.gu,
        "page" : 0,
    }
    })
    .then(response => {
            // console.log('인포:',this.allInfo[1].name);
            this.max_Page = response.data.maxPage;
            for(this.j = 0; this.j < 9; this.j = this.j + 1)
            {
                this.allInfo[this.j].name = response.data.courses[this.j].courseName;
                this.allInfo[this.j].location = response.data.courses[this.j].location;
                this.allInfo[this.j].classTime = response.data.courses[this.j].startTime;
            }

            this.current_position = this.current_position + 1;
    })
    
    .catch(error => {
            console.error('서버 요청 실패:', error);
    });
    },

    computed: {
        groupedInfo() {
            const grouped = [];
            const itemsPerRow = 3; // 한 줄에 표시할 정보 개수
            for (let i = 0; i < this.allInfo.length; i += itemsPerRow) {
                grouped.push(this.allInfo.slice(i, i + itemsPerRow));
            }
            return grouped;
        },
        displayedInfo() {
            // 현재 페이지의 그룹화된 info 데이터 반환
            const startIndex = this.currentPage * this.infoPerPage;
            const endIndex = startIndex + this.infoPerPage;
            return this.allInfo.slice(startIndex, endIndex);
        },
        totalPages() {
        // 전체 페이지 수 계산
        return this.max_Page;
        },
    },

    methods: {
        nextPage() {
            if (this.currentPage < this.totalPages - 1) {
                this.currentPage++;
                // console.log("current",this.current_position);
                const serverAddress = 'http://52.79.243.233:8080/info';
                axios.get(serverAddress, {
                    params :{
                    "gu" : this.$store.state.gu,
                    "page" : this.current_position-1,
                }
                })
                .then(response => {
                    // this.allInfo[0].name = "2page"
                    
                    for(this.j = 0; this.j < 9; this.j = this.j + 1)
                    {
                        this.allInfo[this.j].name = response.data.courses[this.j].courseName;
                        this.allInfo[this.j].location = response.data.courses[this.j].location;
                        this.allInfo[this.j].classTime = response.data.courses[this.j].startTime;
                    }    
                    this.current_position = this.current_position + 1;
                })
                .catch(error => {
                    console.error('서버 요청 실패:', error);
                });
            }
        },

        prevPage() {
            if (this.currentPage > 0) {
                this.currentPage--;
                const serverAddress = 'http://52.79.243.233:8080/info';
                axios.get(serverAddress, {
                    params :{
                    "gu" : this.$store.state.gu,
                    "page" : this.current_position-1,
                }
                })
                .then(response => {
                    for(this.j = 0; this.j < 9; this.j = this.j + 1)
                    {
                        this.allInfo[this.j].name = response.data.courses[this.j].courseName;
                        this.allInfo[this.j].location = response.data.courses[this.j].location;
                        this.allInfo[this.j].classTime = response.data.courses[this.j].startTime;
                    }    
                    this.current_position = this.current_position + 1;
                })
                .catch(error => {
                    console.error('서버 요청 실패:', error);
                });
            }
        },

        formatClassTime(classTime) {
            const timeParts = classTime.split(':');
            const hours = timeParts[0];
            const minutes = timeParts[1];
            return `${hours}:${minutes}`;
        },  
    },
};
</script>

<style scoped>
@import "../style/style2View.css";
</style>
