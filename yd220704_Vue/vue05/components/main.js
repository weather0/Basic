let template = `<div>
                <my-header :cartItemCount="cartItemCount"></my-header>
                  <main>
                    <div class="row product" v-for="product in products">
                      <div class="col-md-4">
                        <!-- 상품 이미지 -->
                        <figure>
                          <img :src="product.image" alt="사료" width="200px">
                        </figure>
                      </div>

                      <div class="col-md-4 col-expand">
                        <!-- 상품 설명 -->
                        <router-link tag="h1" v-bind:to="{name:'id', params: {id:product.id}}">
                        {{product.title}}
                        </router-link>
                        <p v-html="product.description"></p> <!-- html태그 끼임 주의! -->
                        <p class="price">{{product.price | formatPrice}}</p>
                      </div>

                      <!-- v-bind:disabled(회색비활성처리) 또는 v-show(아예 css상 요소 자체를 감춤)로 표시ON/OFF -->
                      <!-- v-if로 태그 자체 존재 유무를 결정 -->
                      <button class="btn btn-primary btn-lg" @click="addToCart(product)" :disabled="!canAddToCart(product)">장바구니
                        담기</button>
                      <span class="inventory-message" v-if="product.stock == cartCount(product.id)">품절!</span>
                      <span class="inventory-message" v-else-if="(product.stock - cartCount(product.id)) > 5">
                        {{product.stock - cartCount(product.id)}}남았습니다!</span>
                      <span class="inventory-message" v-else>지금 구매 하세요!</span>
                      <div class="rating">
                        <!-- 'rating-active'스타일 정의는 지금 이 부트스트랩css에 있음 -->
                        <span v-for="n in 5" :class="{'rating-active':checkRating(n, product)}">☆</span>
                      </div>

                    </div> <!-- end of v-for -->
                 </main>
                </div>`

import myHeader from './header.js'

export default {
  name: 'iMain',
  template: template,
  data: function () {
    return {
      products: [],
      cart: []
    }
  },
  computed: {
    cartItemCount: function () {
      return this.cart.length
    }
  },
  components: {
    myHeader
  },
  methods: {
    addToCart: function (product) {
      this.cart.push(product.id)
    },
    checkRating: function (n, product) {
      return (product.rating - n) >= 0; // 리턴에 비교연산자는 불린값
    },
    canAddToCart: function (product) {
      return this.cartCount(product.id) < product.stock; // 리턴에 비교연산자만 달랑 쓰면 자동으로 알아서 불린값 조절됨
    },
    cartCount: function (productId) {
      let count = 0;
      for (let i = 0; i < this.cart.length; i++) {
        if (this.cart[i] == productId) {
          count++;
        }
      }
      return count;
    }
  },
  // 필터는 data를 직접 연결 안 함(this.xxx 안 씀)
  // 그냥 말그대로 필터링 도구 느낌
  filters: {
    formatPrice: function (price) {
      if (!parseInt(price)) { return ''; }
      if (price > 99999) {
        // $1,000 이상의 값
        let priceString = (price / 100).toFixed(2) // 소수점 만듦
        let priceArray = priceString.split('').reverse(); // 한글자마다 다 짤라서 거꾸로 돌림
        let index = 3;
        while (priceArray.length > index + 3) {
          priceArray.splice(index + 3, 0, ','); // 천단위 쉼표 추가 (#,###)
          index += 4;
        }
        return '$' + priceArray.reverse().join('');
      } else {
        return '$' + (price / 100).toFixed(2);
      }
    }

  },

  // 외부 파일 끌어올 때
  // 요청식(fetch, ajax등)의 위치가 매우 매우 중요함
  // 맨 밑에 created 안에 넣어야 함
  // vue.js인스턴스 생명주기 참고 (https://kr.vuejs.org/v2/guide/instance.html#라이프사이클-다이어그램)
  created: function () {
    fetch("/vue05/products.json")
      .then(response => response.json()) // json -> 오브젝트
      .then(result => {
        console.log(result)
        console.log(result.products)
        this.products = result.products
      })
      .catch(err => console.log(err))
  }
}