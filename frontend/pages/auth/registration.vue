<template lang="pug">
  v-form
    v-text-field(
      name="email" 
      label="email" 
      type="email"
    )
    v-text-field(
      name="name" 
      label="name" 
      type="text"
    )
    v-text-field(
      name="surname" 
      label="surname" 
      type="text"
    )
    v-text-field(
      name="patronymic" 
      label="patronymic" 
      type="text"
    )
    v-text-field(
      id="password"
      name="password"
      label="password"
      type="password"
    )
    v-text-field(
      id="passwordConfirm"
      name="passwordConfirm"
      label="password confirm"
      type="password"
    )
    div.text-xs-right
      nuxt-link(to="./login") Уже есть аккаунт?
      v-btn(color="primary") Зарегистрировать
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'

@Component({
  layout: 'auth'
})
export default class Registration {}
</script>
