<template lang="pug">
  v-app
    v-content
      v-container(fluid fill-height)
        v-layout(align-center justify-center)
          v-flex(xs12 sm8 md4)
            v-card.elevation-12
              v-toolbar(dark color="primary")
                v-toolbar-title {{ $t("auth.signin.caption") }}
                v-spacer
              v-card-text
                nuxt
</template>
