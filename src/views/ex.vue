<!-- <template>
  <div>
    <h1>ex1.vue</h1>
    <button @click="emitData">Emit Data</button>
  </div>
</template>

<script>
export default {
  methods: {
    emitData() {
      this.$EventBus.$emit('data-shared', 'Hello from ex1.vue!'); // 이벤트명, 데이터정의
    },
  },
};
</script>

<template>
  <div>
    <h1>ex2.vue</h1>
    <p>{{ sharedData }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sharedData: '',
    };
  },
  mounted() {
    this.$EventBus.$on('data-shared', (data) => {
      this.sharedData = data;
    });
  },
};

// sendSelectedArea() {
    // // 선택한 지역 값을 서버로 전송
    // const serverAddress = 'http://52.79.243.233:8080/info';
    // axios.get(serverAddress, {
    //   params :{
    //     "gu" : this.selectedArea,
    //     "page" : 0,
    //   }
    // })
    // .then(response => {
    //   // 서버로부터 응답을 받으면 원하는 작업을 수행
    //   console.log('서버 응답:', response.data);
    // })
    // .catch(error => {
    //   console.error('서버 요청 실패:', error);
    // });
    // }
</script> -->


