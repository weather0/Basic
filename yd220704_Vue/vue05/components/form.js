let template = `
            <div>
              <my-header v-bind:cartItemCount="cartItemCount"></my-header>
              <div class="row">
                <div class="col-md-10 col-md-offset-1">
                  <div class="panel panel-info">

                    <div class="panel-heading">애완용품샵 체크아웃</div>

                    <div class="panel-body">

                      <div class="form-group">
                        <div class="col-md-12">
                          <h4><strong>정보를 입력하세요</strong></h4>
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-6">
                          <strong>이름:</strong>
                          <input class="form-control" v-model.trim="order.firstName">
                        </div>
                        <div class="col-md-6">
                          <strong>성:</strong>
                          <input class="form-control" v-model.trim="order.lastName">
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-12">
                          <strong>주소:</strong>
                        </div>
                        <div class="col-md-12">
                          <input class="form-control" v-model.trim="order.address">
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-12">
                          <strong>도시:</strong>
                        </div>
                        <div class="col-md-12">
                          <input class="form-control" v-model.trim="order.city">
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-2">
                          <strong>주:</strong>
                          <select class="form-control" v-model="order.state">
                            <option disabled value="">주</option>
                            <!-- 배열 아닌 오브젝트에도 v-for 적용 가능!! -->
                            <option v-for="(val, key) in states" :value="val">{{key}}</option>
                          </select>
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-4">
                          <strong>우편번호:</strong>
                          <!-- .number해주면 vue에서 알아서 숫자타입으로 인식 -->
                          <!-- 걍 type="number"쓸때는 .number 무조건 붙여주자 편하다 좋다 -->
                          <input class="form-control" type="number" v-model.number="order.zip">
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-6 boxes">
                          <!-- type="checkbox"에는 :true-value :false-value -->
                          <!-- 태그의 value="true"는 초기값? 좀더 이해 필요 -->
                          <input type="checkbox" id="gift" value="true" :true-value="order.sendGift"
                            :false-value="order.dontSendGift" v-model="order.gift">
                          <label for="gift">선물보내기</label>
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-6 boxes">
                          <!-- Vue.js 쓰는 동안은 id, name속성을 굳이 쓸 일이 거의 없다! 
                            (라디오버튼들 name으로 안 묶어줘도 됨).
                            vue로 다 bind하기 때문(여기서 id 준 목적은 라벨 for 연결하는 용도 뿐) -->
                          <input type="radio" id="home" :value="order.home" v-model="order.method">
                          <label for="home">자택</label>
                          <input type="radio" id="business" :value="order.business" v-model="order.method">
                          <label for="business">직장</label>
                        </div>
                      </div>

                      <div class="form-group">
                        <div class="col-md-12">
                          <button type="submit" class="btn btn-primary submit">주문하기</button>
                        </div>
                      </div>

                      <div class="col-md-12 verify">
                        <!-- <pre>: 코드에 쓴 그대로(줄바꿈 등) 화면에 보여주는 기능  -->
                        <pre>
                          이름: {{order.firstName}}
                          성: {{order.lastName}}
                          주소: {{order.address}}
                          도시: {{order.city}}
                          우편번호: {{order.zip}}
                          주: {{order.state}}
                          배송지: {{order.method}}
                          선물: {{order.gift}}
                        </pre>
                      </div>



                    </div>

                  </div>
                </div>
              </div>
            </div>`

import myheader from './header.js'

export default {
  name: 'form',
  template: template,
  props: ['cartItemCount'],
  data: function () {
    return {
      order: {
        firstName: '',
        lastName: '',
        address: '',
        city: '',
        zip: '',
        state: '',
        method: '자택주소',
        business: '직장주소',
        home: '자택주소',
        gift: '선물보내기',
        sendGift: '선물보내기',
        dontSendGift: '선물보내지않기'
      },
      states: {
        AL: '알라바마',
        AK: '알래스카',
        AR: '애리조나',
        CA: '캘리포니아',
        NV: '네바다'
      }

    }
  },
  components: {
    myheader
  },
  methods: {
    submitForm: function () {
      alert('제출 완료')
    }
  }
}