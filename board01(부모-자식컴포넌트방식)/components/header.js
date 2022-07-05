export default {
  name: 'my-header',
  template:
    `<header>
      <h2>간단한 게시판</h2>
      <p>게시판 데이터 json 파일 읽기</p>
      <input type="file" @change="loadData($event)">
      <button @click="saveBoardList">게시판 저장하기</button>
     </header>`,
  // Vue인스턴스의 data를 parentData로 받음
  props: ['parentData'],
  methods: {
    loadData: function (event) {
      // 파일을 가져옴
      let file = event.target.files[0];
      // file이 true면
      if (file) {
        // ajax진행 시 this대신 Vue객체변수(v1)를 적어야 함
        fetch(file.name)
          .then(res => res.json())
          .then(data => {
            console.log(data)
            this.parentData.dataArray = data; // JS의 유연성 덕에 초기값과 상관없이 다른타입(object)으로 담기 가능
            if (this.parentData.dataArray != null && this.parentData.dataArray['board'].length > 0) {
              this.parentData.listOk = true;
            }
            // 자식 컴포넌트 호출 시 v-bind:parentData.sync="뷰 인스턴스 프로퍼티"
            this.$emit('update:parentData', this.parentData);
          }).catch(err => console.log(err))

      }
    },
    saveBoardList: function () {
      let data = this.parentData.dataArray;
      if (data.length == 0) {
        alert('저장할 게시판 내용이 없습니다')
        return
      }

      if (typeof data === 'object') {
        data = JSON.stringify(data, undefined, 4);
      }

      let blob = new Blob([data], { type: 'text/json' });
      let a = document.createElement('a');
      // 브라우저 보안상 직접 다운은 불가하여 a태그를 생성하고 href를 이용해 다운받는 방식으로 우회한다.

      a.download = 'board.json'; // 다운로드 파일명 지정
      a.href = window.URL.createObjectURL(blob);
      a.click();

    }

  }





}

