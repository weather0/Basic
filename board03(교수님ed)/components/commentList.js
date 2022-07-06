import commentListItem from './commentListItem.js'
import commentCreate from './commentCreate.js'

export default {
  template:
    `<div>
      <div v-for="item in comments" :key="item.comment_id">
        <comment-list-item :commentObj="item"></comment-list-item>
      </div>
      <comment-create :contentId="contentId" :reloadComment="reloadComment"></comment-create>
    </div>`,
  components: {
    commentListItem,
    commentCreate
  },
  props: ['contentId'],
  data: function () {
    return {
      comments: this.$parent.$parent.getData().commentData.filter(comment => {
        return comment.content_id == this.contentId;
      })
    }
  },
  methods: {
    reloadComment: function () {
      this.comments = this.$parent.$parent.getData().commentData.filter(comment => {
        return comment.content_id == this.contentId;
      })
    }
  }
}