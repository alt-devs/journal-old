<template lang="pug">
  div
    v-form
      v-text-field(
        :label="$t('auth.fields.email')" 
        name="email" 
        type="email"
      )
      v-text-field(
        :label="$t('auth.fields.phone')" 
        name="phone" 
        type="text"
      )
      v-text-field(
        :label="$t('auth.fields.name')" 
        name="name" 
        type="text"
      )
      v-text-field(
        :label="$t('auth.fields.surname')" 
        name="surname" 
        type="text"
      )
      v-text-field(
        :label="$t('auth.fields.patronymic')" 
        name="patronymic" 
        type="text"
      )
      v-text-field(
        :label="$t('auth.fields.password')"
        id="password"
        name="password"
        type="password"
      )
      v-text-field(
        :label="$t('auth.fields.passwordConfirmation')"
        id="passwordConfirm"
        name="passwordConfirm"
        type="password"
      )
      div.text-xs-right
        nuxt-link(to="./login") {{ $t("auth.alreadyHasAccount") }}
        v-btn(color="primary") {{ $t("auth.signup.go") }}
</template>

<script>
export default {
  layout: 'auth',
  head() {
    return { title: this.$t('auth.signup.title') }
  }
}
</script>
