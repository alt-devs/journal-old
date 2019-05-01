<template lang="pug">
  v-form
    v-text-field(
      prepend-icon="person" 
      name="login" 
      label="login" 
      type="text"
    ) 
    v-text-field(
      id="password"
      prepend-icon="lock"
      name="password"
      label="password"
      type="password"
    )
    div.text-xs-right
      nuxt-link(to="./registration")  Новый пользователь?
      v-btn(color="primary") Войти
</template>

<script lang="ts">
// import axios from 'axios'
import { Component, Vue, Prop } from 'vue-property-decorator'
// import Post from '~/models/Post'

// interface Post {
//   id: number
//   title: string
//   description: string
// }

@Component({
  layout: 'auth'
})
export default class Login extends Vue {
  // @Prop({ type: Object, required: false }) post: Post
}
</script>
