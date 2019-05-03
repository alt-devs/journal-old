<template lang="pug">
  v-form
    v-text-field(
      :label="$t('auth.fields.login')" 
      prepend-icon="person" 
      name="login" 
      type="text"
    ) 
    v-text-field(
      :label="$t('auth.fields.password')"
      id="password"
      prepend-icon="lock"
      name="password"
      type="password"
    )
    div.text-xs-right
      nuxt-link(to="./registration")  {{ $t("auth.newUser") }}
      v-btn(color="primary") {{ $t("auth.signin.go") }}
</template>

<script lang="ts">
export default {
  layout: 'auth',
  head() {
    return { title: this.$t('auth.signin.title') }
  }
}
</script>
